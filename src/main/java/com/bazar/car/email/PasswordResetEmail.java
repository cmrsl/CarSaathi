package com.bazar.car.email;

import java.util.Map;

public class PasswordResetEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Reset your Motor Bazaar password";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            We received a request to reset your Motor Bazaar account password.

            Use the OTP below to proceed:

            OTP: %s

            This code is valid for %s minutes.
            If you did not request this, please ignore this email.

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