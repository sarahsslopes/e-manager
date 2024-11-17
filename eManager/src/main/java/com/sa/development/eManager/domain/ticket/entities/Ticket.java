package com.sa.development.eManager.domain.ticket.entities;

import com.sa.development.eManager.domain.AbstractEntityBase;
import com.sa.development.eManager.domain.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import com.sa.development.eManager.domain.customer.entities.Customer;
import com.sa.development.eManager.domain.employee.entities.Employee;
import com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.sa.development.eManager.domain.__shared.utils.ValidationUtils.isValid;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ticket extends AbstractEntityBase<Integer> {

    private int id;
    private String title;
    private String code;
    private Customer customer;
    private Employee employee;
    private BudgetStatus status;
    private TicketPriority priority;
    private String notes;

    private LocalDate createdAt;
    private LocalDate finishedAt;

    public Ticket(
            int id,
            String title,
            String code,
            String notes,
            BudgetStatus status,
            TicketPriority priority,
            LocalDate finishedAt,
            Employee employee,
            Customer customer
    ) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.notes = notes;
        this.status = status;
        this.priority = priority;
        this.createdAt = LocalDate.now();
        this.finishedAt = finishedAt;
        this.employee = employee;
        this.customer = customer;
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
