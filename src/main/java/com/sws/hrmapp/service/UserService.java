package com.sws.hrmapp.service;

import com.sws.hrmapp.entity.User;


public interface UserService {
    User login(String loginname, String password);
    User findUserById(Integer id);
//    List<User> findUser(User user, PageModel pageModel);
    void removeUserById(Integer id);
    void modifyUser(User user);
    void addUser(User user);
}
