package com.java.sky.service;

import com.java.sky.entity.User;

import java.util.List;

/**
 * @author Sky
 * @date 2020/05/12
 */
public interface IUserOperation {

    public User selectUserByID(int id);

    public List<User> selectUsersByName(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}
