package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    List<Symptom> findByUser(User user);
    List<Symptom> findByUserAndDate(User user, String date);
}
