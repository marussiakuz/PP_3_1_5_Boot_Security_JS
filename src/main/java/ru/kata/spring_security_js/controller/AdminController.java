package ru.kata.spring_security_js.controller;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring_security_js.model.UserInDto;
import ru.kata.spring_security_js.model.UserOutDto;
import ru.kata.spring_security_js.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserOutDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public UserOutDto create(@RequestBody UserInDto user) {
        return userService.create(user);
    }

    @PatchMapping("/user/{id}")
    public UserOutDto update(@PathVariable long id, @RequestBody UserInDto user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }
}
