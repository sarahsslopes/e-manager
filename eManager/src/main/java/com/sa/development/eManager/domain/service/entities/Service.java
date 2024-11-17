package com.sa.development.eManager.domain.service.entities;

import com.sa.development.eManager.domain.AbstractEntityBase;
import com.sa.development.eManager.domain.__shared.exceptions.InvalidInputException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

import static com.sa.development.eManager.domain.__shared.utils.ValidationUtils.isValid;

@Data
@EqualsAndHashCode(callSuper = true)
public class Service extends AbstractEntityBase<Integer> {

    private int id;
    private Integer code;
    private String name;
    private BigDecimal price;

    public Service(
            int id,
            BigDecimal price,
            String name,
            Integer code
    ) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.code = code;
        this.validate();
    }

    @Override
    public void validate() {
        if (!isValid(name)) {
            throw new InvalidInputException("Service name must be at least 1 character long.");
        }

        if (!isValid(code)) {
            throw new InvalidInputException("Code cannot be null or empty.");
        }

        if (!isValid(price)) {
            throw new InvalidInputException("Price value must be at greater than zero.");
        }
    }
}
