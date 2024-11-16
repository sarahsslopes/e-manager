package src.main.java.com.sa.development.eManager.domain.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends Person {

    private List<Budget> budgets;
}
