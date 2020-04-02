package com.Software.Project.Services;

import com.Software.Project.Domain.User;

import java.util.List;

public interface IUserService {
    User findUserById(Long id);
    List<User> findAllUsers();
    User saveUser(User user);
}
