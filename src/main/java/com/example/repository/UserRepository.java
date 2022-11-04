package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUsersByAge(int age);

    User findUserByAgeAndEmail(int age, String email);

    List<User> findUsersByAgeGreaterThanEqual(int age);

    @Query("Select u from User u where u.email =:email")
    User userByMail(String email);


}
