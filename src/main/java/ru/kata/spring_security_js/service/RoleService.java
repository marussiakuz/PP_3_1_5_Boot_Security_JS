package ru.kata.spring_security_js.service;

import ru.kata.spring_security_js.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> getAllByName(Set<String> roles);
}
