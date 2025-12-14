package com.bazar.car.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrevoConfig {

    @Value("${BREVO_API_KEY}")
    private String apiKey;

    @Value("${MAIL_FROM}")
    private String mailFrom;

    @Value("${MAIL_FROM_NAME}")
    private String mailFromName;

    public String apiKey() {
        return apiKey;
    }

    public String mailFrom() {
        return mailFrom;
    }

    public String mailFromName() {
        return mailFromName;
    }

}
