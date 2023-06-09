package com.nicki.thyroidbackend.user;


import com.nicki.thyroidbackend.symptom.Symptom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/firstname")
    public ResponseEntity<String> getCurrentUserFirstName(){
        return ResponseEntity.ok( userService.getAuthenticatedUserFirstName());
    }


}
