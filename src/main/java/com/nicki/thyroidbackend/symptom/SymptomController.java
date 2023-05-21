package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import com.nicki.thyroidbackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/symptom")
    public ResponseEntity<Symptom> createSymptom(@RequestBody Symptom symptom){

        return ResponseEntity.status(HttpStatus.CREATED).body(symptomService.saveSymptom(symptom));
    }

}
