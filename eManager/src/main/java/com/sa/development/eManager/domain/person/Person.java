package src.main.java.com.sa.development.eManager.domain.person;

import lombok.Data;
import lombok.NoArgsConstructor;
import src.main.java.com.sa.development.eManager.domain.AbstractEntityBase;
import src.main.java.com.sa.development.eManager.domain.enums.PersonType;
import src.main.java.com.sa.development.eManager.domain.enums.Profile;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Person extends AbstractEntityBase<Integer> {

    private int id;
    private String name;
    private String telephone;
    private String email;
    private PersonType personType;
    private Set<Profile> profiles;
    private LocalDate createdAt;

    public Person(
            int id,
            String name,
            String telephone,
            String email,
            PersonType personType
    ) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.personType = personType;
        this.profiles = new HashSet<>();
        this.createdAt = LocalDate.now();
    }

    private void validate() {
        if (name == null || name.trim().isEmpty()) {
            throw new main.java.com.sa.development.eManager.domain.InvalidInput("Person name must be at least 1 character long.");
        }
    }
}
