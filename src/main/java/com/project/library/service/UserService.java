package com.project.library.service;

import com.project.library.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final Set<User> userRepo = new HashSet<>();

    public void save(User user) {
        userRepo.add(user);
    }

    public User findUser(String username, String password) {
        return userRepo.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
