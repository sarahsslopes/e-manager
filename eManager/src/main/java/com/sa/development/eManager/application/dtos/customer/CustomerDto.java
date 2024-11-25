package com.sa.development.eManager.application.dtos.customer;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;

import java.util.List;

public class CustomerDto {

    private List<BudgetEntity> budgets;
    private List<TicketEntity> tickets;
}
