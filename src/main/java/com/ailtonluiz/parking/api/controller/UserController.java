package com.ailtonluiz.parking.api.controller;

import com.ailtonluiz.parking.domain.model.User;
import com.ailtonluiz.parking.domain.repository.UserRepository;
import com.ailtonluiz.parking.domain.service.RegisterUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterUserService registerUserService;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User search(@PathVariable Long userId) {
        return registerUserService.searchOrFail(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User user) {
        return user = registerUserService.save(user);
    }

    @PutMapping("/{userId}")
    public User update(@PathVariable Long userId,
                       @RequestBody User user) {
        User currentUser = registerUserService.searchOrFail(userId);

        BeanUtils.copyProperties(user, currentUser, "id");
        return registerUserService.save(currentUser);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long userId) {
        registerUserService.delete(userId);
    }
}
