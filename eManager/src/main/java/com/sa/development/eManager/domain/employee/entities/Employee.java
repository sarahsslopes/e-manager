package com.sa.development.eManager.domain.employee.entities;

import com.sa.development.eManager.domain.budget.entities.Budget;
import com.sa.development.eManager.domain.person.entities.Person;
import com.sa.development.eManager.domain.ticket.entities.Ticket;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import static com.sa.development.eManager.domain.employee.entities.Employee.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    public static final String NAME_TABLE = "employee";

    @OneToMany(mappedBy = "employee")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "employee")
    private List<Ticket> tickets;
}
