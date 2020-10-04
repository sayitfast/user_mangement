package com.example.usere_mangement.controller;

import com.example.usere_mangement.dto.UserRegistrationDto;
import com.example.usere_mangement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

  //@Autowired
  private final UserService userService;

  public <userService> UserRegistrationController(UserService userService) {
    super();
    this.userService = userService;
  }

  @ModelAttribute("appuser")
  public UserRegistrationDto userRegistrationDto() {
    return new UserRegistrationDto();
  }
  //    // could just use below instead of above.
  //    @GetMapping
  //    public String showRegistrationForm(Model model) {
  //        model.addAttribute("appuser", new UserRegistrationDto());
  //        return "registration";
  //    }

  @GetMapping
  public String showRegistrationForm() {
    return "registration";
  }

  @PostMapping
  public String registarUserAccount(
      @ModelAttribute("appuser") UserRegistrationDto registrationDto) {
    try {
      userService.save(registrationDto);
      return "redirect:/registration?success";
    } catch (Exception ex) {
      return "redirect:/registration?emailExists";
    }
  }
}
