package com.security.controller;

import com.security.model.User;
import com.security.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody User user) {
        try {
            user.getUserRole().forEach(p->p.setUser(user));
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public User get(String name) {
        try {
            return userDao.findByusername(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
