package com.sa.development.eManager.application.dtos.budget;

import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;

import java.math.BigDecimal;
import java.util.Date;

public record BudgetDto(
        String id,
        String code,
        CustomerEntity customer,
        EmployeeEntity employee,
        ServiceEntity service,
        BigDecimal increase,
        BigDecimal discount,
        String notes,
        Date expirationAt
) {}
