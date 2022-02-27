package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

import static java.util.Objects.hash;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return
                (Objects.equals(firstName, user.firstName)
                        || (firstName != null && firstName.equals(user.getFirstName()))) && (Objects.equals(lastName, user.lastName)
                        || (lastName != null && lastName.equals(user.getLastName())
                ));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = (int) (prime * result + (hash(firstName)+hash(lastName)));
        result = prime * result + ((lastName == null) ? 0 : (lastName.hashCode() >>> 31));
        return result;
    }
}
