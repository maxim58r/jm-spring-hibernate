package ru.max.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.max.webapp.models.Role;

public interface RoleDao extends JpaRepository<Role,Long> {


}
