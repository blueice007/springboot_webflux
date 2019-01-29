package com.blueice.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.blueice.demo.model.User;
import com.blueice.demo.service.UserService;

/**
* @Description: TODO
* @author blueice
* @date 2019年1月29日 上午9:35:38
*
*/
@Service
public class UserServiceImpl implements UserService
{
    private static List<User> data = new ArrayList<User>(); 
    static {
        data.add(new User(1, "李涌泉", 22, "深圳福田"));
        data.add(new User(2, "胡栋予", 22, "深圳福田"));
        data.add(new User(3, "陈文博", 21, "深圳福田"));
        data.add(new User(4, "吴垂松", 23, "深圳福田"));
    }
    @Override
    public User findById(final int id)
    {
        return data.stream().filter(user->user.getId()==id).findFirst().orElse(null);
    }
    
    @Override
    public List<User> findAll()
    {
        return data;
    }
    
    @Override
    public List<User> findByName(final String name)
    {
        return data.stream().filter(user->user.getName()==name).collect(Collectors.toList());
    }
    
    @Override
    public User saveOrUpdate(final User user)
    {
        Optional<User> target = data.stream().filter(u->u.getId()==user.getId()).findFirst();
        if(target.isPresent()) {
            BeanUtils.copyProperties(user, target.get());
            return target.get();
        }else {
            data.add(user);
            return user;
        }
    }
    
    @Override
    public User delete(final User user)
    {
        boolean success = data.removeIf(u->u.getId()==user.getId());
        if(success) {
            return user;
        }else {
            return null;
        }
    }
    
}
