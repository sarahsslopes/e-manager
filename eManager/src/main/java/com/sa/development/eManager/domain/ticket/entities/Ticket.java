package com.sa.development.eManager.domain.ticket.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sa.development.eManager.domain.AbstractEntityBase;
import com.sa.development.eManager.domain.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import com.sa.development.eManager.domain.customer.entities.Customer;
import com.sa.development.eManager.domain.employee.entities.Employee;
import com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

import static com.sa.development.eManager.domain.__shared.utils.ValidationUtils.isValid;
import static com.sa.development.eManager.domain.ticket.entities.Ticket.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ticket extends AbstractEntityBase<String> {

    public static final String NAME_TABLE = "ticket";

    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

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

    public Ticket(
            String title,
            String code,
            String notes,
            BudgetStatus status,
            TicketPriority priority,
            Date finishedAt,
            Employee employee,
            Customer customer
    ) {
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
    public void validate() {
        if (!isValid(title)) {
            throw new InvalidInputException("Title must be be at least 1 character long.");
        }

        if(!isValid(code)) {
            throw new InvalidInputException("Code cannot be null or empty.");
        }
    }
}
