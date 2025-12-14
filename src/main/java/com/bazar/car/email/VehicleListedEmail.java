package com.bazar.car.email;

import java.util.Map;

public class VehicleListedEmail extends BaseEmailTemplate {

    @Override
    public String subject(Map<String, Object> data) {
        return "Your vehicle listing is live on Motor Bazaar";
    }

    @Override
    public String body(Map<String, Object> data) {

        return """
            Hi %s,

            Your vehicle has been successfully listed on Motor Bazaar.

            Vehicle:
            %s

            Listing ID:
            %s

            Interested buyers can now view and enquire about your vehicle.

            Regards,
            Motor Bazaar Team
            """
                .formatted(
                        value(data, "userName"),
                        value(data, "vehicleTitle"),
                        value(data, "listingId")
                );
    }
}