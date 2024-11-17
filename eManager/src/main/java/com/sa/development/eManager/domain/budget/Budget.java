package src.main.java.com.sa.development.eManager.domain.budget;

import lombok.Data;
import src.main.java.com.sa.development.eManager.domain.enums.BudgetStatus;
import src.main.java.com.sa.development.eManager.domain.enums.Priority;
import src.main.java.com.sa.development.eManager.domain.customer.Customer;
import src.main.java.com.sa.development.eManager.domain.employee.Employee;
import src.main.java.com.sa.development.eManager.domain.service.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Budget {

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

    public Budget(int id,
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
}
