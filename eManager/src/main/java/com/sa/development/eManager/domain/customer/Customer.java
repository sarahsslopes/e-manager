package src.main.java.com.sa.development.eManager.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import src.main.java.com.sa.development.eManager.domain.budget.Budget;
import src.main.java.com.sa.development.eManager.domain.person.Person;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    private List<Budget> budgets;
}