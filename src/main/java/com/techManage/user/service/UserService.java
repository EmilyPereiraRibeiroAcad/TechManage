package com.techManage.user.service;

import com.techManage.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User user);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
