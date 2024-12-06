package com.nikitinada.service;

import com.nikitinada.model.UserEntity;
import com.nikitinada.model.UserRequest;
import com.nikitinada.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDao implements UserService {

    private UserRepository userRepository;

    @Override
    public UserEntity getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public UserEntity addUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setJob(userRequest.getJob());
        return userRepository.save(userEntity);
    }
}