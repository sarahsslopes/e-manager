package com.sa.development.eManager.domain.customer.entities;

import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import com.sa.development.eManager.domain.person.entities.PersonEntity;
import com.sa.development.eManager.domain.ticket.entities.TicketEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerEntity extends PersonEntity {

    @OneToMany(mappedBy = "customer")
    private List<BudgetEntity> budgets;

    @OneToMany(mappedBy = "customer")
    private List<TicketEntity> tickets;
}
