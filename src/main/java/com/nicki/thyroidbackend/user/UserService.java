package com.nicki.thyroidbackend.user;

import com.nicki.thyroidbackend.symptom.Symptom;

import java.util.List;

public interface UserService {

    User getAuthenticatedUser();
    String getAuthenticatedUserFirstName();

    Symptom saveSymptom(Symptom symptom);

 /*   List<Symptom> getSymptomsByUserAndDate(String date);*/
}
