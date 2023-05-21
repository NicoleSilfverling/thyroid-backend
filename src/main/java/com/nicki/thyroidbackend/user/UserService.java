package com.nicki.thyroidbackend.user;

import com.nicki.thyroidbackend.symptom.Symptom;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getAuthenticatedUser();
    String getAuthenticatedUserFirstName();


}
