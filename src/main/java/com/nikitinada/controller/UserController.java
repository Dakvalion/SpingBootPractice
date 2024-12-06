package com.nikitinada.controller;

import com.nikitinada.entity.UserEntity;
import com.nikitinada.model.UserRequest;
import com.nikitinada.service.UserService;
import lombok.Generated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping({"/v1/users"})
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserEntity getUserById(@RequestParam int id) {
        return this.userService.getUser(id);
    }

    @GetMapping(
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public UserEntity findByIdFromJson(@RequestBody Map<String, Integer> requestBody) {
        Integer id = (Integer)requestBody.get("id");
        return this.userService.getUser(id);
    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserRequest userRequest) {
        return this.userService.addUser(userRequest);
    }

    @Generated
    public UserController(final UserService userService) {
        this.userService = userService;
    }
}
