package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import com.nicki.thyroidbackend.user.UserRepository;
import com.nicki.thyroidbackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService{
    private final SymptomRepository symptomRepository;
    private final UserRepository userRepository;
    private final UserService userService;


    @Override
    public List<SymptomDTO> getUserSymptomsByDate(String date) {
        User user = userService.getAuthenticatedUser();
        List<Symptom> symptoms = symptomRepository.findByUserAndDate(user, date);

        return mapSymptomsToDTOs(symptoms);
    }

    @Override
    public List<SymptomDTO> getUserSymptoms() {
        User user = userService.getAuthenticatedUser();
        List<Symptom> symptoms = symptomRepository.findByUserId(user.getId());

        return mapSymptomsToDTOs(symptoms);
    }


    @Override
    public List<SymptomDTO> getUserSymptomsByType(String type) {
        User user = userService.getAuthenticatedUser();
        List<Symptom> symptoms = symptomRepository.findByUserAndTypeOrderByDate(user, type);
        return mapSymptomsToDTOs(symptoms);
    }

    @Override
    public Symptom saveSymptom(Symptom symptom) {
        User user = userService.getAuthenticatedUser();

        user.addSymptom(symptom);
        userRepository.save(user);

        return symptom;
    }



    private List<SymptomDTO> mapSymptomsToDTOs(List<Symptom> symptoms) {
        return symptoms.stream()
                .map(symptom -> new SymptomDTO(
                        symptom.getId(),
                        symptom.getDate(),
                        symptom.getType(),
                        symptom.getValue(),
                        symptom.getBottomRef(),
                        symptom.getTopRef()
                ))
                .collect(Collectors.toList());
    }
}
