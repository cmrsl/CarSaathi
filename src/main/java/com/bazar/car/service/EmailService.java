package com.bazar.car.service;

import com.bazar.car.entity.User;

public interface EmailService {


    void sendOtpMail(String otp, User user, int expiryMinutes);










//    public void sendOtpMail(String otp, User user,int otpExpiryMinutes) {
//        log.info("Sending OTP email to {}", user.getEmail());
//        try {
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//            helper.setFrom("motorbazaap.mp@gmail.com");
//            helper.setTo(user.getEmail());
//            helper.setSubject(EmailTemplate.signUpOtpSubject());
//            helper.setText(EmailTemplate.signUpOtpBody(user.getUsername(), otp, otpExpiryMinutes)
//            );
//
//            mailSender.send(message);
//            log.info("Sign-up OTP email sent to {}", user.getEmail());
//        } catch (Exception e) {
//            log.error("Error sending OTP email to {}: {}", user.getEmail(), e.getMessage());
//            throw new ApiValidationException(HttpStatus.INTERNAL_SERVER_ERROR, "EMAIL_SEND_FAILURE", "Failed to send verification email");
//        }
//    }
}

