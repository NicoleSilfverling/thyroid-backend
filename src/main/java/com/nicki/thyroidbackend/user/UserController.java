package com.nicki.thyroidbackend.user;


import com.nicki.thyroidbackend.symptom.Symptom;
import com.nicki.thyroidbackend.symptom.SymptomRepository;
import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/firstname")
    public ResponseEntity<String> getCurrentUserFirstName(){
        return ResponseEntity.ok( userService.getAuthenticatedUserFirstName());
    }


    @PostMapping("/symptom")
    public ResponseEntity<Symptom> createSymptom(@RequestBody Symptom symptom){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveSymptom(symptom));
    }


/*
    @GetMapping("/symptoms")
    public void getSymptomsByDate(@RequestParam String date) {

        System.out.println(userService.getSymptomsByUserAndDate(date));

     }
*/



}
