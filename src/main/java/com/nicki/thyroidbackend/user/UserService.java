package com.nicki.thyroidbackend.user;

import com.nicki.thyroidbackend.symptom.Symptom;

public interface UserService {

    User getAuthenticatedUser();
    String getAuthenticatedUserFirstName();

    Symptom saveSymptom(Symptom symptom);
}
