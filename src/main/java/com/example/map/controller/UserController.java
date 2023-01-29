package com.example.map.controller;

import com.example.map.dto.binding.UserRegisterBindingModel;
import com.example.map.service.user.UserService;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerModel")
    public UserRegisterBindingModel registerMode() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/login")
    public String login(CsrfToken token) {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

//    @GetMapping("/logout")
//    public String logout(){
//        userService.logout();
//        return "redirect:/";
//    }
//
//    @GetMapping("/profile/{id}")
//    public String profile(@PathVariable Long id, Model model){
//
//        model.addAttribute("user", modelMapper
//                .map(userService.findById(id), UserViewModel.class));
//        return "profile";
//    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute("email") String email,
                              RedirectAttributes attributes) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("email", email);

        return "redirect:/users/login";
    }

}
