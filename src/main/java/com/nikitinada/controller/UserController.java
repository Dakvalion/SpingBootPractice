package com.nikitinada.controller;

import com.nikitinada.model.UserEntity;
import com.nikitinada.model.UserRequest;
import com.nikitinada.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserEntity getUserById(@RequestParam int id) {
        return userService.getUser(id);
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public UserEntity findByIdFromJson(@RequestBody Map<String, Integer> requestBody) {
        Integer id = requestBody.get("id");

        return userService.getUser(id);
    }


    @PostMapping
    public UserEntity addUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }
}
