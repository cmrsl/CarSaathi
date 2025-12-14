package com.bazar.car.email;

import java.util.Map;

public class ListingStatusUpdateEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Update on your vehicle listing";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            Your vehicle listing status has been updated.

            Vehicle:
            %s

            Status:
            %s

            %s

            Regards,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "userName"),
                        value(data, "vehicleTitle"),
                        value(data, "status"),
                        value(data, "reason")
                );
    }
}