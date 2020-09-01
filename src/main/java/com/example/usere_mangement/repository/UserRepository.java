package com.example.usere_mangement.repository;

import com.example.usere_mangement.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 8/29/20
 * 6:13 PM
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

    List<AppUser> findAll();

    @Transactional
    AppUser deleteUserById(Long id); // Delete
}
