package src.main.java.com.sa.development.eManager.domain.ticket;

import lombok.Data;
import lombok.NoArgsConstructor;
import src.main.java.com.sa.development.eManager.domain.customer.Customer;
import src.main.java.com.sa.development.eManager.domain.enums.BudgetStatus;
import src.main.java.com.sa.development.eManager.domain.enums.Priority;
import src.main.java.com.sa.development.eManager.domain.employee.Employee;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Ticket implements Serializable {

    private int id;
    private String title;
    private String code;
    private Customer customer;
    private Employee employee;
    private BudgetStatus status;
    private Priority priority;
    private String notes;

    private LocalDate createdAt;
    private LocalDate finishedAt;

    public Ticket(
            int id,
            LocalDate finishedAt,
            String notes,
            Priority priority,
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
