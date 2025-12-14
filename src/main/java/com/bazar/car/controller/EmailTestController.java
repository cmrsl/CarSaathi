package com.bazar.car.controller;


import com.bazar.car.email.BrevoEmailRequest;
import com.bazar.car.email.BrevoEmailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class EmailTestController {

    private final BrevoEmailSender sender;

    public EmailTestController(BrevoEmailSender sender) {
        this.sender = sender;
    }

    @GetMapping("/email")
    public String testEmail() {

        sender.send(new BrevoEmailRequest(
                "deepakguptarohit@gmail.com",
                "Local Brevo Test",
                "<h3>Brevo email working locally ✅</h3>"
        ));
        return "Email sent";
    }
}
