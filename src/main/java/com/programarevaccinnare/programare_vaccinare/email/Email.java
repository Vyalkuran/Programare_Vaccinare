package com.programarevaccinnare.programare_vaccinare.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Email {

    private String to;
    private String from;
    private String cc;
    private String bcc;
    private String subject;
    private String body;

    public Email(EmailBuilder emailBuilder) {
        this.to = emailBuilder.to;
        this.from = emailBuilder.from;
        this.cc = emailBuilder.cc;
        this.bcc = emailBuilder.bcc;
        this.subject = emailBuilder.subject;
        this.body = emailBuilder.body;
    }

    public static class EmailBuilder{
        private final String to;
        private final String from;
        private final String subject;
        private final String body;
        private String cc;
        private String bcc;

        public EmailBuilder(String to, String from, String subject, String body){
            this.to = to;
            this.from = from;
            this.subject = subject;
            this.body = body;
        }

        public EmailBuilder cc(String cc){
            this.cc = cc;
            return this;
        }

        public EmailBuilder bcc(String bcc){
            this.bcc = bcc;
            return this;
        }

        public Email build(){
            Email email = new Email(this);
            return email;
        }
    }
}
