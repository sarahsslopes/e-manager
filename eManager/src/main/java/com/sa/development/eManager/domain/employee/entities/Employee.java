package src.main.java.com.sa.development.eManager.domain.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import src.main.java.com.sa.development.eManager.domain.budget.entities.Budget;
import src.main.java.com.sa.development.eManager.domain.person.entities.Person;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    private List<Budget> budgets;
}
