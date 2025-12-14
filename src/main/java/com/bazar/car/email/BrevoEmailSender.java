package com.bazar.car.email;

import com.bazar.car.exception.ApiValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class BrevoEmailSender {

    private static final String BREVO_URL = "https://api.brevo.com/v3/smtp/email";

    private final BrevoConfig config;
    private final RestClient restClient;

    public BrevoEmailSender(BrevoConfig config) {
        this.config = config;
        this.restClient = RestClient.create();
    }

    public void send(BrevoEmailRequest request) {

        try {
            restClient.post()
                    .uri(BREVO_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("api-key", config.apiKey())
                    .body(request.toPayload(
                            config.mailFrom(),
                            config.mailFromName()
                    ))
                    .retrieve()
                    .toBodilessEntity();

            log.info("Brevo email sent to {}", request);

        } catch (Exception ex) {
            log.error("Brevo email sending failed", ex);
            throw new ApiValidationException(HttpStatus.BAD_REQUEST,"Failed to send email via Brevo", ex.getMessage());
        }
    }
}
