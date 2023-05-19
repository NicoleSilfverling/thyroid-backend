package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    List<Symptom> findByUserId(Integer userId);
    List<Symptom> findByUserAndDate(User user, String date);
}
