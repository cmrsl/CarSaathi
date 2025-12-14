package com.bazar.car.email;

import java.util.Map;

public class VehicleLikedEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Vehicle added to your wishlist";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            You have added the following vehicle to your wishlist:

            %s

            View it anytime from your saved vehicles section.

            Happy browsing,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "userName"),
                        value(data, "vehicleTitle")
                );
    }
}