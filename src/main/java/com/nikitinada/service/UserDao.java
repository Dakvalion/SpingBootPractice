package com.nikitinada.service;

import com.nikitinada.entity.UserEntity;
import com.nikitinada.model.UserRequest;
import com.nikitinada.repository.UserRepository;
import lombok.Generated;
import org.springframework.stereotype.Service;

@Service
public class UserDao implements UserService {
    private final UserRepository userRepository;

    public UserEntity getUser(int id) {
        return (UserEntity)this.userRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("User not found with id: " + id);
        });
    }

    public UserEntity addUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setJob(userRequest.getJob());
        return (UserEntity)this.userRepository.save(userEntity);
    }

    @Generated
    public UserDao(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}