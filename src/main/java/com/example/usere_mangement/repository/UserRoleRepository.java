package com.example.usere_mangement.repository;

import com.example.usere_mangement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA. User: Rhett Herring 10/3/20 3:27 PM
 */
public interface UserRoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);
}
