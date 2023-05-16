package com.nicki.thyroidbackend;

import com.nicki.thyroidbackend.symptom.Symptom;
import com.nicki.thyroidbackend.symptom.SymptomRepository;
import com.nicki.thyroidbackend.user.User;
import com.nicki.thyroidbackend.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private  final UserRepository userRepository;
    private final SymptomRepository symptomRepository;


    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages(){
        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }

    @PostMapping("/symptom/{email}")
    public Symptom symptom(@PathVariable String email, @RequestBody Symptom symptom){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));


        user.addSymptom(symptom);
        userRepository.save(user);

        return symptom;
    }


/*    @PostMapping("/users/{userId}/symptoms")
    public ResponseEntity<Symptom> createSymptom(@PathVariable(value = "userId") Integer userId, @RequestBody Symptom symptom) throws ResponseStatusException, URISyntaxException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        symptom.setUser(user);
        Symptom newSymptom = symptomRepository.save(symptom);
        return ResponseEntity.created(new URI("/users/" + userId + "/symptoms/" + newSymptom.getId())).body(newSymptom);
    }*/



    @PostMapping("/symptom")
    public ResponseEntity<Symptom> createSymptom( @RequestBody Symptom symptom){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        symptom.setUser(user); /*AccessDeniedException: Access Denied, access between symptom and user*/

        user.addSymptom(symptom);
        userRepository.save(user);
        System.out.println("Authenticated user: " + email);


        return ResponseEntity.status(HttpStatus.CREATED).body(symptom);
    }


    /*@PostMapping("/api/v1/user/symptom")
    *//*    @PreAuthorize("isAuthenticated()")*//*
    public ResponseEntity<Symptom> createSymptom( @RequestBody Symptom symptom){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));


        symptom.setUser(user);
        Symptom newSymptom = symptomRepository.save(symptom);


        System.out.println("Authenticated user: " + email);


        *//*return ResponseEntity.ok(symptom);*//*
        return ResponseEntity.status(HttpStatus.CREATED).body(newSymptom);
        *//*return ResponseEntity.created(new URI("/users/symptoms/" + newSymptom.getId())).body(newSymptom);*//*
    }*/

}
