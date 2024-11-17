package src.main.java.com.sa.development.eManager.domain.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import src.main.java.com.sa.development.eManager.domain.person.Person;
import src.main.java.com.sa.development.eManager.domain.budget.Budget;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    private List<Budget> budgets;
}
