package com.reportgenerator.nutrition_report.service;

import com.reportgenerator.nutrition_report.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}
