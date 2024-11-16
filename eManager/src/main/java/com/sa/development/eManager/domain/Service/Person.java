package src.main.java.com.sa.development.eManager.domain.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import src.main.java.com.sa.development.eManager.domain.Enums.PersonType;
import src.main.java.com.sa.development.eManager.domain.Enums.Profile;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
