package com.sa.development.eManager.domain.person.entities;

import com.sa.development.eManager.domain.AbstractEntityBase;
import com.sa.development.eManager.domain.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.person.entities.enums.PersonType;
import com.sa.development.eManager.domain.person.entities.enums.Profile;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.sa.development.eManager.domain.__shared.utils.ValidationUtils.isValid;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractEntityBase<Integer> {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private PersonType personType;
    private Set<Profile> profiles;
    private LocalDate createdAt;

    public Person(
            int id,
            String name,
            String phoneNumber,
            String email,
            PersonType personType
    ) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.personType = personType;
        this.profiles = new HashSet<>();
        this.createdAt = LocalDate.now();
    }


    @Override
    public void validate() {
        if (!isValid(name)) {
            throw new InvalidInputException("Person name must be at least 1 character long.");
        }

        if (!isValid(phoneNumber)) {
            throw new InvalidInputException("Phone number must be at least 1 character long.");
        }
    }
}
