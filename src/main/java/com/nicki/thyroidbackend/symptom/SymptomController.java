package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import com.nicki.thyroidbackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;

    @GetMapping("/symptoms/{date}")
    public ResponseEntity<List<SymptomDTO>> getUserSymptoms(@PathVariable String date) {
        List<SymptomDTO> symptomDTOs = symptomService.getUserSymptoms(date);
        return ResponseEntity.ok().body(symptomDTOs);
    }

    @GetMapping("/symptoms")
    public ResponseEntity<List<SymptomDTO>> getUserSymptoms() {
        List<SymptomDTO> symptomDTOs = symptomService.getUserSymptoms();
        return ResponseEntity.ok().body(symptomDTOs);
    }

}
