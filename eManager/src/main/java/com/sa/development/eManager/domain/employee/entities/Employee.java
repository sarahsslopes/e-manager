package com.sa.development.eManager.domain.employee.entities;

import com.sa.development.eManager.domain.budget.entities.Budget;
import com.sa.development.eManager.domain.person.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    private int id;
    private List<Budget> budgets;
}
