package com.example.usere_mangement.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

@Entity
@Table(name = "appuser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AppUser {

  LocalDateTime utc_date_Time_Stamp = LocalDateTime.now();
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;
  private String password;
  @Column(name = "local_date_time_stamp")
  private String date_stamp = utc_date_Time_Stamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

  private Collection<Role> roles;

  public AppUser() {

  }

  public AppUser(String firstName, String lastName, String email, String password,
      Collection<Role> roles) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

}