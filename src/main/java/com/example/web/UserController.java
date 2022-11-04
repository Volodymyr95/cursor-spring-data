package com.example.web;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping(value = "/user") //user?id=
    public void delete(@RequestParam Long id) {
        userService.delete(id);
    }

    @GetMapping(value = "/user/{age}")
    public List<User> getByAge(@PathVariable int age) { // users/user/42
        return userService.findUsersByAge(age);
    }

    @GetMapping(value = "/user")
    public User getByAgeAndEmail(@RequestParam int age, @RequestParam String email) { // /users/user?age=42&email=sdsdcdc
        return userService.findByAgeAndEmail(age, email);
    }

    @GetMapping(value = "/adults")
    public List<User> getAllAdults() { // users/user/42
        return userService.findAllAdults();
    }

    @GetMapping(value = "/user/email/{email}")
    public User getByEmail(@PathVariable String email) { // users/user/42
        return userService.findByEmail(email);
    }
}
