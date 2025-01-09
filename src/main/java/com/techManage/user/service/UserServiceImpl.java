package com.techManage.user.service;

import com.techManage.user.model.User;
import com.techManage.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setFullName(user.getFullName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setBirthDate(user.getBirthDate());
            updatedUser.setUserType(user.getUserType());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
