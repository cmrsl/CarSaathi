package com.bazar.car.email;

import java.util.Map;

public interface EmailTemplate {
    String subject(Map<String, Object> data);

    String body(Map<String, Object> data);
}
