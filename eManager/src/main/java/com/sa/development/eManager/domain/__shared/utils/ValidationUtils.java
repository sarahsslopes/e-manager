package com.sa.development.eManager.domain.__shared.utils;

import java.math.BigDecimal;

public class ValidationUtils {

    public static boolean isValid(BigDecimal value) {
        return value == null || value.compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isValid(Integer value) {
        return value != null && value > 0;
    }

    public static boolean isValid(String value) {
        return value != null && value.length() > 1;
    }
}
