package com.example.usere_mangement.controller;

import com.example.usere_mangement.model.AppUser;
import com.example.usere_mangement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 8/30/20
 * 5:43 PM
 */
@Controller
public class MainController {

    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loging() {
        return "login";
    }

    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String findAll(Model model) {
        model.addAttribute("appuser", userRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
//        AppUser user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        userRepository.deleteById(id);
        model.addAttribute("appuser", userRepository.findAll());
        return "redirect:/index?userDeleted";
    }
}
