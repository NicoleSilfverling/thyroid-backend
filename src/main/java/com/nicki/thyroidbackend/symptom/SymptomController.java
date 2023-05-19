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
    private final SymptomRepository symptomRepository;
    private final UserService userService;


    @GetMapping("/symptoms/{date}")
    public ResponseEntity<List<SymptomDTO>> getUserSymptoms(@PathVariable String date) {
        User user = userService.getAuthenticatedUser();
        System.out.println(date);
        List<Symptom> symptoms = symptomRepository.findByUserAndDate(user, date);

        List<SymptomDTO> symptomDTOs = symptoms.stream()
                .map(symptom -> new SymptomDTO(
                        symptom.getId(),
                        symptom.getDate(),
                        symptom.getType(),
                        symptom.getValue(),
                        symptom.getBottomRef(),
                        symptom.getTopRef()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(symptomDTOs);
    }

     @GetMapping("/symptoms")
     public ResponseEntity<List<SymptomDTO>> getUserSymptoms() {
         User user = userService.getAuthenticatedUser();
         List<Symptom> symptoms = symptomRepository.findByUserId(user.getId());

         List<SymptomDTO> symptomDTOs = symptoms.stream()
                 .map(symptom -> new SymptomDTO(
                         symptom.getId(),
                         symptom.getDate(),
                         symptom.getType(),
                         symptom.getValue(),
                         symptom.getBottomRef(),
                         symptom.getTopRef()
                 ))
                 .collect(Collectors.toList());

         return ResponseEntity.ok(symptomDTOs);
     }
}
