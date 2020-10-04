package com.example.usere_mangement.service;

import com.example.usere_mangement.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Object save(UserRegistrationDto registrationDto);
}
