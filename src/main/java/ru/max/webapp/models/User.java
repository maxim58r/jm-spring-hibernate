package ru.max.webapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "car_id")
//    private Car car;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User" +
                "\n Id: " + id  +
                "\n; FirstName: " + firstName +
                "\n; LastName: " + lastName +
                "\n; email: " + email;
    }
}
