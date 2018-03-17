package com.sws.hrmapp.controller;

import com.sws.hrmapp.entity.User;
import com.sws.hrmapp.service.UserService;
import com.sws.hrmapp.util.common.HrmConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestBody User userLogin, HttpSession session){
        User user = userService.login(userLogin.getLoginname(),userLogin.getPassword());
        if(user!=null){
            session.setAttribute(HrmConstants.USER_SESSION,user);
            return "/main";
        }else{
//            mv.addObject("message","登录名或密码错误，请重新输入");
//            mv.setViewName("forward:/loginForm");
        }
        return "/loginForm";
    }
}
