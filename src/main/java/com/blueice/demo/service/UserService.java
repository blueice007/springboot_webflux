package com.blueice.demo.service;

import java.util.List;

import com.blueice.demo.model.User;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月28日 下午6:20:50
*
*/
public interface UserService
{
    public User findById(int id);
    public List<User> findAll();
    public List<User> findByName(String name);
    public User saveOrUpdate(User user);
    public User delete(User user);
}
