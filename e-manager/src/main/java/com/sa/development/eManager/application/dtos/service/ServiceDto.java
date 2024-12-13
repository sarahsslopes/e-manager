package com.sa.development.eManager.application.dtos.service;

import java.math.BigDecimal;

public record ServiceDto(
        Integer code,
        String name,
        BigDecimal price
) {}
