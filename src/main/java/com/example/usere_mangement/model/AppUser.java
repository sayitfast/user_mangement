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
import javax.validation.constraints.Size;

@Entity
@Table(name = "appuser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class AppUser {

  LocalDateTime utc_date_Time = LocalDateTime.now();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", unique = true, nullable = false)
  @Email
  private String email;

  @Column(name = "phone")
  @Size(min = 10, max = 10)
  private String phone;

  private String password;

  @Column(name = "created_local_time")
  private String date_stamp = utc_date_Time.format(DateTimeFormatter.ISO_DATE_TIME);

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Role> roles;

  public AppUser() {

  }

  public AppUser(String firstName, String lastName, String email, String phone,
      String password, Collection<Role> roles) {

    super();

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
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

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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

  public LocalDateTime getUtc_date_Time() {
    return utc_date_Time;
  }

  public void setUtc_date_Time(LocalDateTime utc_date_Time) {
    this.utc_date_Time = utc_date_Time;
  }

  public String getDate_stamp() {
    return date_stamp;
  }

  public void setDate_stamp(String date_stamp) {
    this.date_stamp = date_stamp;
  }
}