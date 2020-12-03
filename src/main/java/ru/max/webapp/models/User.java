package ru.max.webapp.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "id")
@Entity
@Table(name = "users")
public class User /*implements UserDetails */ {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name must be more 2 chars")
    @NotBlank(message = "Name should not be empty")
    @Column(name = "username", nullable = false)
    private String username;

    @Size(min = 3, message = "Password must be more 2 chars")
    @NotBlank(message = "Password should not be empty")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Transient
    private Map<String, String> roles;

    @Transient
    private Map<String, Boolean> enableds;

    @Min(value = 0, message = "The amount of funds must be greater than 0")
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    {
        roles = new HashMap<>();
        roles.put("Employee", "ROLE_EMPLOYEE");
        roles.put("Client", "ROLE_CLIENT");

        enableds = new HashMap<>();
        enableds.put("False", false);
        enableds.put("True", true);
    }

    public User(Long id, @Size(min = 3, message = "Name must be more 2 chars")
    @NotBlank(message = "Name should not be empty") String username,
                @Size(min = 3, message = "Password must be more 2 chars")
                @NotBlank(message = "Password should not be empty") String password,
                String role, boolean enabled,
                @Min(value = 0, message = "The amount of funds must be greater than 0") BigDecimal salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.salary = salary;
    }
}
