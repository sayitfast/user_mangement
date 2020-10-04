package com.example.usere_mangement.controller;

import com.example.usere_mangement.repository.UserRepository;
import com.example.usere_mangement.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


  private final UserRepository userRepository;
  private final UserRoleRepository userRoleRepository;

  @Autowired
  public MainController(UserRepository userRepository,
      UserRoleRepository userRoleRepository) {
    this.userRepository = userRepository;
    this.userRoleRepository = userRoleRepository;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping(value = {"", "/", "/index", "/index.html"})
  public String findAll(Model model) {
    model.addAttribute("appuser", userRepository.findAll());
    return "index";
  }

  @GetMapping("delete/{id}")
  public String deleteStudent(@PathVariable("id") long id, Model model) {
//   AppUser user = userRepository.findById(id)
//  .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    userRepository.deleteById(id);
    model.addAttribute("appuser", userRepository.findAll());
    return "redirect:/admin?userDeleted";
  }

  @GetMapping(value = {"admin", "/admin", "/admin/index.html"})
  public String getAdminHomepage(Model model) {
    model.addAttribute("appuser", userRepository.findAll());
    return "/admin/index";
  }
}
