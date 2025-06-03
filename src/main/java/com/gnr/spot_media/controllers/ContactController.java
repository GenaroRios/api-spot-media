package com.gnr.spot_media.controllers;

import com.gnr.spot_media.dto.ContactRequest;
import com.gnr.spot_media.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final EmailService emailService;
    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Void> sendContact(
            @Validated @RequestBody ContactRequest request) {
        emailService.sendContact(request);
        return ResponseEntity.ok().build();
    }
}
