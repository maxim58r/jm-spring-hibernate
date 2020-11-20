package ru.max.webapp.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Serov Maxim
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "role",nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    protected Set<User> users = new HashSet<>();

    public Role(Long id, String role, Set<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    @Override
    public String getAuthority() {
        StringBuilder sb = new StringBuilder();
        sb.append(users.stream().map(p -> p.roles));
        return new String(sb);
    }
}
