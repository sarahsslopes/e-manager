package com.sa.development.eManager.domain.ticket.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sa.development.eManager.__shared.EntityBase;
import com.sa.development.eManager.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

import static com.sa.development.eManager.__shared.utils.ValidationUtils.isValid;
import static com.sa.development.eManager.domain.ticket.entities.TicketEntity.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TicketEntity extends EntityBase<String> {

    public static final String NAME_TABLE = "ticket";

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @Enumerated(EnumType.STRING)
    private BudgetStatus status;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    @Column
    private String notes;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startedAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date finishedAt;

    public TicketEntity(
            String title,
            String code,
            String notes,
            BudgetStatus status,
            TicketPriority priority,
            Date finishedAt,
            EmployeeEntity employee,
            CustomerEntity customer
    ) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.code = code;
        this.notes = notes;
        this.status = status;
        this.priority = priority;
        this.startedAt = new Date();
        this.finishedAt = finishedAt;
        this.employee = employee;
        this.customer = customer;
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
        if (!isValid(title)) {
            throw new InvalidInputException("Title must be be at least 1 character long.");
        }

        if(!isValid(code)) {
            throw new InvalidInputException("Code cannot be null or empty.");
        }
    }
}
