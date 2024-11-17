package src.main.java.com.sa.development.eManager.domain.ticket.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import src.main.java.com.sa.development.eManager.domain.AbstractEntityBase;
import src.main.java.com.sa.development.eManager.domain.customer.entities.Customer;
import src.main.java.com.sa.development.eManager.domain.employee.entities.Employee;
import src.main.java.com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import src.main.java.com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;

import java.time.LocalDate;

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
            LocalDate finishedAt,
            String notes,
            TicketPriority priority,
            BudgetStatus status,
            Employee employee,
            Customer customer,
            String code,
            String title
    ) {
        this.id = id;
        this.finishedAt = finishedAt;
        this.createdAt = LocalDate.now();
        this.notes = notes;
        this.priority = priority;
        this.status = status;
        this.employee = employee;
        this.customer = customer;
        this.code = code;
        this.title = title;
    }
}
