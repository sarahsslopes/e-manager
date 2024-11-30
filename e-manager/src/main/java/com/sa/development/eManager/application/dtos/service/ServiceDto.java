package com.sa.development.eManager.application.dtos.service;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;

import java.math.BigDecimal;
import java.util.List;

public class ServiceDto {

    private String id;
    private Integer code;
    private String name;
    private BigDecimal price;
    private List<BudgetEntity> budgets;
}
