package com.amaral.email_service.core;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
