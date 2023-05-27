package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import com.nicki.thyroidbackend.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;

    @GetMapping("/symptoms/{date}")
    public ResponseEntity<List<SymptomDTO>> getUserSymptoms(@PathVariable String date) {
        List<SymptomDTO> symptomDTOs = symptomService.getUserSymptomsByDate(date);
        return ResponseEntity.ok().body(symptomDTOs);
    }

    @GetMapping("/symptoms/type/{type}")
    public ResponseEntity<List<SymptomDTO>> getUserSymptomsByType(@PathVariable String type) {
        List<SymptomDTO> symptomDTOs = symptomService.getUserSymptomsByType(type);
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

    @DeleteMapping("/symptom/{id}")
    public ResponseEntity<String> deleteSymptom(@PathVariable Long id){
        try {
            symptomService.deleteSymptomById(id);
            return ResponseEntity.ok("Symptom deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Symptom not found");
        } catch (AccessDeniedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not authorized to delete this symptom");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete symptom");
        }
    }

}
