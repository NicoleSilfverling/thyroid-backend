package com.nicki.thyroidbackend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/firstname")
    public ResponseEntity<String> getCurrentUserFirstName(){
        return ResponseEntity.ok( userService.getAuthenticatedUserFirstName());
    }
}
