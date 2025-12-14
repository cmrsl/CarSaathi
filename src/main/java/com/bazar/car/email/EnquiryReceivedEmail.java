package com.bazar.car.email;

import java.util.Map;

public class EnquiryReceivedEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "New enquiry received for your vehicle";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            You have received a new enquiry for your vehicle:

            Vehicle:
            %s

            Interested buyer:
            %s

            Please log in to your dashboard to respond.

            Regards,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "sellerName"),
                        value(data, "vehicleTitle"),
                        value(data, "buyerName")
                );
    }
}