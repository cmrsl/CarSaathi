package com.bazar.car.service.Impl;

import com.bazar.car.email.BrevoEmailRequest;
import com.bazar.car.email.BrevoEmailSender;
import com.bazar.car.email.SignupOtpEmail;
import com.bazar.car.entity.User;
import com.bazar.car.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final BrevoEmailSender brevoEmailSender;
    private final SignupOtpEmail signupOtpEmail;

    @Override
    public void sendOtpMail(String otp, User user, int expiryMinutes) {
        Map<String, Object> data = Map.of(
                "userName", user.getUsername(),
                "otp", otp,
                "minutesValid", expiryMinutes
        );

        String subject = signupOtpEmail.subject(data);
        String body = signupOtpEmail.body(data);

        brevoEmailSender.send(
                new BrevoEmailRequest(
                        user.getEmail(),
                        subject,
                        body.replace("\n", "<br>") // temporary HTML support
                )
        );
    }
}
