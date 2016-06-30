package com.security;

import com.security.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MainController {
    @Autowired
    private UserDao userDao;


    @PreAuthorize("hasRole('PERMISSION_ADMIN')")
    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
