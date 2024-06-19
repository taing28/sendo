package com.example.sendo.models.services;

import com.example.sendo.models.services.interfaces.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

private final JavaMailSender _mailSender;

public EmailService(JavaMailSender _mailSender) {
this._mailSender = _mailSender;
}

    @Override
    public void sendEmailWithHTML(String to, String subject, String content) {
        MimeMessage mimeMessage = _mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);

            _mailSender.send(mimeMessage);
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }
}
