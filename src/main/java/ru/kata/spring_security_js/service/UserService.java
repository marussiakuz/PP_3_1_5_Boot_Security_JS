package ru.kata.spring_security_js.service;

import ru.kata.spring_security_js.model.UserInDto;
import ru.kata.spring_security_js.model.UserOutDto;

import java.util.List;

public interface UserService {

    List<UserOutDto> getAll();

    UserOutDto create(UserInDto user);

    UserOutDto update(long id, UserInDto user);

    UserOutDto getByEmail(String email);

    void delete(long id);
}
