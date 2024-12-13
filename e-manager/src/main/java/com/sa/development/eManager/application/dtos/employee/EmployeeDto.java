package com.sa.development.eManager.application.dtos.employee;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;

import java.util.List;

public record EmployeeDto(
         List<BudgetEntity> budgets,
         List<TicketEntity> tickets
) {}
