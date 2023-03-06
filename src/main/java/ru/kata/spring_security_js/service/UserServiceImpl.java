package ru.kata.spring_security_js.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring_security_js.error.UserNotFoundException;
import ru.kata.spring_security_js.model.User;
import ru.kata.spring_security_js.model.UserInDto;
import ru.kata.spring_security_js.model.UserOutDto;
import ru.kata.spring_security_js.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserOutDto> getAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public UserOutDto getByEmail(String email) {
        return userMapper.toDto(getByEmailOrThrowException(email));
    }

    @Transactional
    @Override
    public UserOutDto create(UserInDto user) {
        return userMapper.toDto(userRepository.save(userMapper.toUser(user)));
    }

    @Transactional
    @Override
    public UserOutDto update(long id, UserInDto userDto) {
        User user = getByIdOrThrowException(id);
        userMapper.updateUserFromDto(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    @Override
    public void delete(long id) {
        userRepository.delete(getByIdOrThrowException(id));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return getByEmailOrThrowException(email);
    }

    private User getByIdOrThrowException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("user with id=%d not found", id)));
    }

    private User getByEmailOrThrowException(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("user with email=%s not found", email)));
    }
}
