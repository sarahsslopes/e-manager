package com.sa.development.eManager.domain.customer.entities;

import com.sa.development.eManager.domain.budget.entities.Budget;
import com.sa.development.eManager.domain.person.entities.Person;
import com.sa.development.eManager.domain.ticket.entities.Ticket;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import static com.sa.development.eManager.domain.customer.entities.Customer.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    public static final String NAME_TABLE = "customer";

    @OneToMany(mappedBy = "customer")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> tickets;
}
