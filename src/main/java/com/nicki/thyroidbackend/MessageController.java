package com.nicki.thyroidbackend;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MessageController {




    @GetMapping("/messages")
    public ResponseEntity<List<String>> messages(){
        return ResponseEntity.ok(Arrays.asList("first", "second"));
    }


}
