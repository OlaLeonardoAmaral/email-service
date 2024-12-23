package com.amaral.email_service.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amaral.email_service.application.EmailSenderService;
import com.amaral.email_service.core.EmailRequest;
import com.amaral.email_service.core.exceptions.EmailServiceException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/sendemail")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.emailSenderService.sendEmail(
                    request.to(),
                    request.subject(),
                    request.body());

            return ResponseEntity.ok("email send successfully");
        } catch (EmailServiceException e) {
            return ResponseEntity.internalServerError().body("Error while sending email");
        }
    }

}
