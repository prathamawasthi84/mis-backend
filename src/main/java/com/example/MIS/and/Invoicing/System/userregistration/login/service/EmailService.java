package com.example.MIS.and.Invoicing.System.userregistration.login.service;

import com.example.MIS.and.Invoicing.System.userregistration.login.Status;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.EmailVerificationToken;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.EmailVerifiactionTokenRespository;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    private EmailVerifiactionTokenRespository emailVerifiactionTokenRespository;
    private UserRepository userRepository;
    public EmailService (EmailVerifiactionTokenRespository emailVerifiactionTokenRespository,UserRepository userRepository){
        this.emailVerifiactionTokenRespository=emailVerifiactionTokenRespository;
        this.userRepository=userRepository;
    }
    public void sendVerificationMail(String toEmail,String token){
        String link = "http://localhost:8080/user/verify?token=" + token;
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom("noob46966@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Verify your Email");
        simpleMailMessage.setText("Click the link to verify: " + link);
        javaMailSender.send(simpleMailMessage);
    }
    public String verifyEmail(String token){
        Optional<EmailVerificationToken> output = emailVerifiactionTokenRespository.findByToken(token);
        if(output.isEmpty()){
            throw new RuntimeException("Invalid Token");
        }
        EmailVerificationToken emailVerificationToken = output.get();
        if(emailVerificationToken.getExpiresAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Token Expired");
        }
        UserEntity userEntity = emailVerificationToken.getUserEntity();
        userEntity.setStatus(Status.ACTIVE);
        userRepository.save(userEntity);
        return "Email Verified Successfully";
    }
}
