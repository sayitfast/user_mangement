package com.example.usere_mangement.repository;

import com.example.usere_mangement.model.AppUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

  AppUser findByEmail(String email);

  List<AppUser> findAll();

  @Transactional
  void deleteById(Long id); // Delete

  Boolean existsByEmail(String email);
}
