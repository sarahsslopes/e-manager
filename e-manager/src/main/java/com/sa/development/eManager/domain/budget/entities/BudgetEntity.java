package com.sa.development.eManager.domain.budget.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sa.development.eManager.__shared.EntityBase;
import com.sa.development.eManager.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.service.entities.ServiceEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static com.sa.development.eManager.__shared.utils.ValidationUtils.isValid;
import static com.sa.development.eManager.domain.budget.entities.BudgetEntity.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BudgetEntity extends EntityBase<String> {

    public static final String NAME_TABLE = "budget";

    @Id
    private String id;

    @Column
    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @Column
    private BigDecimal increase;

    @Column
    private BigDecimal discount;

    @Column
    private String notes;

    @Column
    private Integer createdBy;

    @JsonFormat(pattern = "dd/MM/YY")
    @Column
    private Date createdAt;

    @JsonFormat(pattern = "dd/MM/YY")
    @Column
    private Date expirationAt;

    public BudgetEntity(
            String notes,
            BigDecimal increase,
            BigDecimal discount,
            ServiceEntity service,
            String code,
            Integer createdBy
    ) {
        this.id = UUID.randomUUID().toString();
        this.notes = notes;
        this.increase = increase;
        this.discount = discount;
        this.service = service;
        this.createdAt = new Date();
        this.code = code;
        this.createdBy = createdBy;
    }

    @Override
    public String setId() {
        return generateUUID();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void validate() {
        if (!isValid(code)) {
            throw new InvalidInputException("Code cannot be null or empty.");
        }
    }
}
