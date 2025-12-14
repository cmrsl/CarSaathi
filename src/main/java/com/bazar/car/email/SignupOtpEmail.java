package com.bazar.car.email;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignupOtpEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Motor Bazaar – Your OTP Code";
    }


    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            Welcome to Motor Bazaar!

            To continue, please use the One-Time Password (OTP) below:

            OTP: %s

            This code is valid for %s minutes.
            Please do not share this OTP with anyone.

            If you did not request this, you can safely ignore this email.

            Regards,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "userName"),
                        value(data, "otp"),
                        value(data, "minutesValid")
                );
    }
}
