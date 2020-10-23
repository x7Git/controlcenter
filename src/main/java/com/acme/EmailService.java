package com.acme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(int temperature, String alertStage) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("maschine1@meldung.de");
        msg.setTo("irgendwas@acme.com");
        msg.setSubject("Maschine 1 " + alertStage);
        msg.setText("Die Maschine hat eine Temperature von: " + temperature + "°C");

        javaMailSender.send(msg);
    }
}
