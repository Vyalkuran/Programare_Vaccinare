package com.programarevaccinnare.programare_vaccinare.email;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class MailSender {

    private EmailProvider emailProvider;

    public void sendEmail(Beneficiar beneficiar, CentruVaccinare centruVaccinare, String subiect, String mesaj){
        if (emailProvider == null){
            throw new RuntimeException("Este necesar un email provider");
        }
        try{
            emailProvider.sendEmail(beneficiar, centruVaccinare, subiect, mesaj);
        }catch (Exception e){
            System.out.println("Eroare email");
        }
    }
}
