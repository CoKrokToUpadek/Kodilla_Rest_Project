package com.crud.task.service;

import com.crud.task.domain.Mail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleEmailService {
    private final JavaMailSender javaMailSender;

    public void send(Mail mail) {
        log.info("Starting email preparation...");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(mailMessage);
            log.info("Email has been sent.");

        } catch (MailException e) {
            log.error("Failed to process email sending: " + e.getMessage(), e);
        }

    }

    private SimpleMailMessage createMailMessage(Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        Optional<String> toCC=Optional.ofNullable(mail.getToCc());
        if (toCC.isPresent()){
            mailMessage.setCc(mail.getToCc());
        }
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        return mailMessage;
    }

}
