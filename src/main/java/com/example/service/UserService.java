package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(Long id);

    List<User> findUsersByAge(int age);

    User findByAgeAndEmail(int age, String email);

    List<User> findAllAdults();

    User findByEmail(String email);

}
