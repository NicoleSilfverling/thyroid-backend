package com.nicki.thyroidbackend.symptom;

import java.util.List;

public interface SymptomService {
    List<SymptomDTO> getUserSymptoms(String date);
    List<SymptomDTO> getUserSymptoms();
    List<SymptomDTO> getUserSymptomsByType(String type);

    Symptom saveSymptom(Symptom symptom);
}
