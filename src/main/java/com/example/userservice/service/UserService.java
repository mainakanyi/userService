package com.example.userservice.service;

import com.example.userservice.model.Role;
import com.example.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role user);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
