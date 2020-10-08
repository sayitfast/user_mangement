package com.example.usere_mangement.service;

import com.example.usere_mangement.dto.UserRegistrationDto;
import com.example.usere_mangement.model.AppUser;
import com.example.usere_mangement.model.Role;
import com.example.usere_mangement.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  // @Autowired
  private final UserRepository userRepository;

  @Autowired
  BCryptPasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository) {
    super();
    this.userRepository = userRepository;
  }

  @SneakyThrows
  @Override
  public AppUser save(UserRegistrationDto registrationDto) {
    AppUser appUser = new AppUser(registrationDto.getFirstName(),
        registrationDto.getLastName(), registrationDto.getEmail(),
        // use following to send unencypted data to DB. TESTING only
        //registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        passwordEncoder.encode(registrationDto.getPassword()),
        Arrays.asList(new Role("ROLE_USER")));
    // check if email address already exists before saving account
    if (userRepository.existsByEmail(registrationDto.getEmail())) {
      throw new Exception("An account with that email address already exists!");
    } else {
      return userRepository.save(appUser);
    }
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password");
    }
    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), mapRolesToAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList());
  }
}
