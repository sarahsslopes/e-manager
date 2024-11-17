package src.main.java.com.sa.development.eManager.domain.service;

import lombok.Data;
import main.java.com.sa.development.eManager.domain.InvalidInput;

import java.math.BigDecimal;

@Data
public class Service {

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
            throw new InvalidInput("Service name must be at least 1 character long.");
        }

        if (code == null || code.trim().isEmpty()) {
            throw new InvalidInput("Code must be at least 1 character long.");
        }

        if (price == null || price.equals(BigDecimal.ZERO) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInput("Price value must be at greater than zero.");
        }
    }
}
