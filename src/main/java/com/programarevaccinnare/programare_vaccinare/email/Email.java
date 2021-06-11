package com.programarevaccinnare.programare_vaccinare.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Email {

    private String to;
    private String from;
    private String cc;
    private String subject;
    private String body;

    private static final Email instance = new Email();

    public static Email getInstance() {
        return instance;
    }
}
