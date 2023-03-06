package ru.kata.spring_security_js.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring_security_js.model.UserOutDto;
import ru.kata.spring_security_js.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserOutDto getUser() {
        return userService.getByEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());
    }
}
