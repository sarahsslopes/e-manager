package src.main.java.com.sa.development.eManager.domain.Service;

import lombok.Data;
import src.main.java.com.sa.development.eManager.domain.Enums.BudgetStatus;
import src.main.java.com.sa.development.eManager.domain.Enums.Priority;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Budget {

    private int id;
    private String code;
    private Customer customer;
    private Employee employee;
    private BudgetStatus status;
    private Priority priority;
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
                  Priority priority,
                  BudgetStatus status,
                  LocalDate expirationAt,
                  String code,
                  Integer createdBy
    ) {
        this.id = id;
        this.notes = notes;
        this.increase = increase;
        this.discount = discount;
        this.service = service;
        this.priority = priority;
        this.status = status;
        this.createdAt = LocalDate.now();
        this.code = code;
        this.createdBy = createdBy;
    }
}
