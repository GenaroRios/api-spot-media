package com.gnr.spot_media.service;

import com.gnr.spot_media.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final String smtpUser;
    private final String recipient;

    public EmailService(JavaMailSender mailSender,
                        @Value("${spring.mail.username}") String smtpUser,
                        @Value("${app.mail.contact-recipient}")String recipient) {
        this.mailSender = mailSender;
        this.smtpUser = smtpUser;
        this.recipient = recipient;
    }

    public void sendContact(ContactRequest req) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(smtpUser);
        msg.setTo(recipient);
        msg.setReplyTo(req.getEmail());            // para que al responder vaya al usuario
        msg.setSubject("[Consulta] " + req.getServicio());

        String body = String.format(
                "De: %s <%s>%n%n%s%n%n%s",
                req.getNombre(), req.getEmail(), req.getMensaje(), req.getCelular()
        );
        msg.setText(body);

        mailSender.send(msg);
    }
}
