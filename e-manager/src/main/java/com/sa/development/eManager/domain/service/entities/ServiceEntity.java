package com.sa.development.eManager.domain.service.entities;

import com.sa.development.eManager.__shared.EntityBase;
import com.sa.development.eManager.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.budget.entities.BudgetEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.sa.development.eManager.__shared.utils.ValidationUtils.isValid;
import static com.sa.development.eManager.domain.service.entities.ServiceEntity.NAME_TABLE;

@Data
@Entity
@Table(name = NAME_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceEntity extends EntityBase<String> {

    public static final String NAME_TABLE = "service";

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "service")
    private List<BudgetEntity> budgets;

    @Builder
    public ServiceEntity(
            BigDecimal price,
            String name,
            Integer code
    ) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.name = name;
        this.code = code;
        this.validate();
    }

    @Override
    public String setId() {
        return generateUUID();
    }

    @Override
    public String getId() {
        return this.id;
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
