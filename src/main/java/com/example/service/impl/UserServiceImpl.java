package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found!");
        }

        userRepository.deleteById(id);

    }

    @Override
    public List<User> findUsersByAge(int age) {
        return userRepository.findUsersByAge(age);
    }

    @Override
    public User findByAgeAndEmail(int age, String email) {
        return userRepository.findUserByAgeAndEmail(age, email);
    }

    @Override
    public List<User> findAllAdults() {
        return userRepository.findUsersByAgeGreaterThanEqual(18);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.userByMail(email);
    }
}
