package com.security.controller;

import com.security.model.User;
import com.security.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@Configurable
public class UserController {

    @Resource
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
            return userDao.findByUsername(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
