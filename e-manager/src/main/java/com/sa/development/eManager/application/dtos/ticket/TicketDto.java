package com.sa.development.eManager.application.dtos.ticket;

import com.sa.development.eManager.domain.budget.entities.enums.BudgetStatus;
import com.sa.development.eManager.domain.customer.entities.CustomerEntity;
import com.sa.development.eManager.domain.employee.entities.EmployeeEntity;
import com.sa.development.eManager.domain.ticket.entities.enums.TicketPriority;

import java.util.Date;

public record TicketDto(
         String id,
         String title,
         String code,
         CustomerEntity customer,
         EmployeeEntity employee,
         BudgetStatus status,
         TicketPriority priority,
         String notes,
         Date startedAt,
         Date finishedAt
) {}
