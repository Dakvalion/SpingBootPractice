package com.nikitinada.service;

import com.nikitinada.model.UserEntity;
import com.nikitinada.model.UserRequest;

public interface UserService {
    UserEntity getUser(int id);
    UserEntity addUser(UserRequest userRequest);
}
