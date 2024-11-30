package com.sa.development.eManager.domain.person.entities.enums;

import com.sa.development.eManager.__shared.exceptions.NotFoundException;

import java.util.Arrays;

public enum PersonType {
    NATURAL,
    LEGAL;

    public static Integer value;

    public PersonType getByValue(Integer value) {
        if (PersonType.value != null) {
            Arrays.stream(PersonType.values()).findFirst().ifPresent(e -> PersonType.value = value);
        }

        throw new NotFoundException("PersonType with value " + value + " not found");
    }
}
