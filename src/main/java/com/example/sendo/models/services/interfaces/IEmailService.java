package com.example.sendo.models.services.interfaces;

public interface IEmailService {
    void sendEmailWithHTML(String to, String subject, String content);

}
