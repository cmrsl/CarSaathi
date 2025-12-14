package com.bazar.car.email;

import java.util.Map;

public abstract class BaseEmailTemplate implements EmailTemplate {

    protected String value(Map<String, Object> data, String key) {
        return String.valueOf(data.getOrDefault(key, ""));
    }

    protected int intValue(Map<String, Object> data, String key) {
        return Integer.parseInt(String.valueOf(data.getOrDefault(key, "0")));
    }
}
