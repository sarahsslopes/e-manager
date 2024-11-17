package com.sa.development.eManager.domain.budget.entities;

import com.sa.development.eManager.domain.AbstractEntityBase;
import com.sa.development.eManager.domain.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.customer.entities.Customer;
import com.sa.development.eManager.domain.employee.entities.Employee;
import com.sa.development.eManager.domain.service.entities.Service;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.sa.development.eManager.domain.__shared.utils.ValidationUtils.isValid;

@Data
@EqualsAndHashCode(callSuper = true)
public class Budget extends AbstractEntityBase<Integer> {

    private int id;
    private String code;
    private Customer customer;
    private Employee employee;
    private Service[] service;
    private BigDecimal increase;
    private BigDecimal discount;
    private String notes;

    private Integer createdBy;
    private LocalDate createdAt;
    private LocalDate expirationAt;

    public Budget(
            int id,
            String notes,
            BigDecimal increase,
            BigDecimal discount,
            Service[] service,
            String code,
            Integer createdBy
    ) {
        this.id = id;
        this.notes = notes;
        this.increase = increase;
        this.discount = discount;
        this.service = service;
        this.createdAt = LocalDate.now();
        this.code = code;
        this.createdBy = createdBy;
    }

    @Override
    public void validate() {
        if (!isValid(code)) {
            throw new InvalidInputException("Code cannot be null or empty.");
        }
    }
}
