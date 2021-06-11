package com.programarevaccinnare.programare_vaccinare.email;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTPEmailProvider implements EmailProvider{
    private String from = "alexsebastiandeveloper@gmail.com";
    private String host = "smtp.gmail.com";

    @Override
    public void sendEmail(Beneficiar beneficiar, CentruVaccinare centruVaccinare, String subiect, String mesaj) {
        Email email = new Email.EmailBuilder(beneficiar.getEmail(), from, subiect, mesaj).build();
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.auth", true);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getFrom(), "smtpmail80");
            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            Transport.send(message);
            System.out.println("Mail trimis cu succes");
        }catch (MessagingException mex){
            mex.printStackTrace();
        }

    }
}
