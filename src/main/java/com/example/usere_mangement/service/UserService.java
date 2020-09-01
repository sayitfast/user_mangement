package com.example.usere_mangement.service;

import com.example.usere_mangement.dto.UserRegistrationDto;
import com.example.usere_mangement.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 8/29/20
 * 6:15 PM
 */
public interface UserService extends UserDetailsService {
    AppUser save(UserRegistrationDto registrationDto);
}
