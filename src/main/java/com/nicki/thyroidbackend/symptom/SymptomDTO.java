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
    private double value;
    private double bottomRef;
    private double topRef;

}