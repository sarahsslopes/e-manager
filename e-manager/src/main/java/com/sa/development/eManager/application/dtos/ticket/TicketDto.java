package com.sa.development.eManager.application.dtos.ticket;

import com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;

import java.util.Date;

public class TicketDto {

    private String id;
    private String title;
    private String code;
    private CustomerEntity customer;
    private EmployeeEntity employee;
    private BudgetStatus status;
    private TicketPriority priority;
    private String notes;
    private Date startedAt;
    private Date finishedAt;
}
