package com.example.MIS.and.Invoicing.System.userregistration.login.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.EmailVerifiactionTokenRespository;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String resendApiKey;

    @Value("${app.backend.url:https://web-production-1845c.up.railway.app}")
    private String backendUrl;

    @Value("${app.frontend.url:https://misinvoicingsystem.netlify.app}")
    private String frontendUrl;

    private final EmailVerifiactionTokenRespository emailVerifiactionTokenRespository;
    private final UserRepository userRepository;

    public EmailService(EmailVerifiactionTokenRespository emailVerifiactionTokenRespository, UserRepository userRepository) {
        this.emailVerifiactionTokenRespository = emailVerifiactionTokenRespository;
        this.userRepository = userRepository;
    }

    public void sendVerificationMail(String toEmail, String token) {
        String link = backendUrl + "/user/verify?token=" + token;
        Resend resend = new Resend(resendApiKey);
        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to(toEmail)
                .subject("Verify your Email")
                .html("<p>Click the link to verify your email:</p><a href='" + link + "'>" + link + "</a>")
                .build();
        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            throw new RuntimeException("Failed to send verification email: " + e.getMessage());
        }
    }

    public void sendPasswordResetMail(String toEmail, String token) {
        String link = frontendUrl + "/reset-password/" + token;
        Resend resend = new Resend(resendApiKey);
        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to(toEmail)
                .subject("Password Reset Request")
                .html("<p>Click the link below to reset your password:</p><a href='" + link + "'>" + link + "</a><p>This link expires in 15 minutes.</p>")
                .build();
        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            throw new RuntimeException("Failed to send password reset email: " + e.getMessage());
        }
    }
}