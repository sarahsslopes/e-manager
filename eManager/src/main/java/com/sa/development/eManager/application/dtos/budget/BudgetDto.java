package com.sa.development.eManager.application.dtos.budget;

import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;

import java.math.BigDecimal;
import java.util.Date;

public class BudgetDto {

    private String id;
    private String code;
    private CustomerEntity customer;
    private EmployeeEntity employee;
    private ServiceEntity service;
    private BigDecimal increase;
    private BigDecimal discount;
    private String notes;
    private Integer createdBy;
    private Date createdAt;
    private Date expirationAt;
}