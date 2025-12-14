package com.bazar.car.email;

import java.util.Map;

public class EnquirySentEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Your enquiry has been sent";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            Your enquiry for the vehicle below has been successfully sent:

            Vehicle:
            %s

            The seller (%s) will contact you shortly.

            Regards,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "buyerName"),
                        value(data, "vehicleTitle"),
                        value(data, "sellerName")
                );
    }
}