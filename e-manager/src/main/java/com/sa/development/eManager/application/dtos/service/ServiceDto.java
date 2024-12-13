package com.sa.development.eManager.application.dtos.service;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;

import java.math.BigDecimal;
import java.util.List;

public record ServiceDto(
        String id,
        Integer code,
        String name,
        BigDecimal price,
        List<BudgetEntity> budgets
) {}
