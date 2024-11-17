package src.main.java.com.sa.development.eManager.domain.service.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import src.main.java.com.sa.development.eManager.domain.AbstractEntityBase;
import src.main.java.com.sa.development.eManager.domain.__shared.InvalidInputException;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Service extends AbstractEntityBase<Integer> {

    private int id;
    private String code;
    private String name;
    private BigDecimal price;

    public Service(
            int id,
            BigDecimal price,
            String name,
            String code
    ) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.code = code;
        this.validate();
    }

    private void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Service name must be at least 1 character long.");
        }

        if (code == null || code.trim().isEmpty()) {
            throw new InvalidInputException("Code must be at least 1 character long.");
        }

        if (price == null || price.equals(BigDecimal.ZERO) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException("Price value must be at greater than zero.");
        }
    }
}