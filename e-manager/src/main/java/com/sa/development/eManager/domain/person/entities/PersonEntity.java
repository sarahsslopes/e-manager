package com.sa.development.eManager.domain.person.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sa.development.eManager.__shared.EntityBase;
import com.sa.development.eManager.__shared.exceptions.InvalidInputException;
import com.sa.development.eManager.domain.person.entities.enums.PersonType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

import static com.sa.development.eManager.__shared.utils.ValidationUtils.isValid;
import static com.sa.development.eManager.domain.person.entities.PersonEntity.NAME_TABLE;

@Entity
@Table(name = NAME_TABLE)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PersonEntity extends EntityBase<String> {

    public static final String NAME_TABLE = "person";

    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

   // private Set<Profile> profiles;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    public PersonEntity(
            String name,
            String phoneNumber,
            String email,
            PersonType personType
    ) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.personType = personType;
  //      this.profiles = new HashSet<>();
        this.createdAt = new Date();
    }

    public PersonEntity() {}

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
            throw new InvalidInputException("Person name must be at least 1 character long.");
        }

        if (!isValid(phoneNumber)) {
            throw new InvalidInputException("Phone number must be at least 1 character long.");
        }
    }
}
