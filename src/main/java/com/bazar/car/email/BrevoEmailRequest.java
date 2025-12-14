package com.bazar.car.email;

import java.util.Map;

public class BrevoEmailRequest {
    private final String to;
    private final String subject;
    private final String htmlContent;

    public BrevoEmailRequest(String to, String subject, String htmlContent) {
        this.to = to;
        this.subject = subject;
        this.htmlContent = htmlContent;
    }

    public Map<String, Object> toPayload(
            String fromEmail,
            String fromName
    ) {
        return Map.of(
                "sender", Map.of(
                        "email", fromEmail,
                        "name", fromName
                ),
                "to", new Object[] {
                        Map.of("email", to)
                },
                "subject", subject,
                "htmlContent", htmlContent
        );
    }

}
