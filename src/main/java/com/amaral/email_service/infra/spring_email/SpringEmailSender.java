package com.amaral.email_service.infra.spring_email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amaral.email_service.adapters.EmailSenderGateway;

@Service
public class SpringEmailSender implements EmailSenderGateway {

    private final JavaMailSender mailSender;

    public SpringEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("noreply@email.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
    
}
