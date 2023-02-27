package com.mustafafindik.aop.Service;

import com.mustafafindik.aop.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    List<User> allUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
