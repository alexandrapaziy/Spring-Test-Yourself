package com.examserver.service;

import com.examserver.model.User;
import com.examserver.model.UserRole;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
