package com.sa.development.eManager.domain.employee.entities;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import com.sa.development.eManager.domain.person.entities.PersonEntity;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmployeeEntity extends PersonEntity {

    @OneToMany(mappedBy = "employee")
    private List<BudgetEntity> budgets;

    @OneToMany(mappedBy = "employee")
    private List<TicketEntity> tickets;
}
