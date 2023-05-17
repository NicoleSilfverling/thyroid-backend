package com.nicki.thyroidbackend.user;

import com.nicki.thyroidbackend.symptom.Symptom;
import com.nicki.thyroidbackend.symptom.SymptomRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final SymptomRepository symptomRepository;

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }

    @Override
    public String getAuthenticatedUserFirstName() {
        User user = getAuthenticatedUser();
        return user.getFirstname();
    }

    @Override
    public Symptom saveSymptom(Symptom symptom) {
        User user = getAuthenticatedUser();

        symptom.setUser(user); //access denied, but still works?
        symptomRepository.save(symptom);

        return symptom;
    }


/*
    @Override
    public List<Symptom> getSymptomsByUserAndDate(String date) {
        User user = getAuthenticatedUser();
        return symptomRepository.findByUserAndDate(user, date);
    }*/

}
