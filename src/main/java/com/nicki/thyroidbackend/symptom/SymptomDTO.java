package com.nicki.thyroidbackend.symptom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SymptomDTO {
    private Long id;
    private String date;
    private String type;
    private String value;
    private String bottomRef;
    private String topRef;

}