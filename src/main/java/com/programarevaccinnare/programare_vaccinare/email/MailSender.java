package com.programarevaccinnare.programare_vaccinare.email;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class MailSender {

    private EmailProvider emailProvider; // EmailProvider emailProvider = new SmtpEmailProvider();

    public void sendEmail(Email email){
        if (emailProvider == null){
            throw new RuntimeException("Este necesar un email provider");
        }
        try{
            emailProvider.sendEmail(email);
        }catch (Exception e){
            System.out.println("Eroare email");
        }
    }
}
