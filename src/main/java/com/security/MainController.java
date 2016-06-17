package com.security;

import com.security.model.User;
import com.security.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class MainController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/home/welcome")
    public ModelAndView home()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(String error,HttpServletRequest request)
    {
        Enumeration<String> enumer=request.getParameterNames();
        while(enumer.hasMoreElements())
        {
            System.out.println(enumer.nextElement());
        }

        System.out.println(error);
//        for(String t:request.getParameterValues("error"))
//        System.out.println(t);

        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("error",error);
//        modelAndView.addObject("msg",logout);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void save(@RequestBody User user)
    {
        try {
            userDao.save(user);
        }catch(Exception e)
        {e.printStackTrace();}
    }

}
