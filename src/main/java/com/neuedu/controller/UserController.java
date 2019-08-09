package com.neuedu.controller;


import com.neuedu.consts.Consts;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;


    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, HttpSession session, HttpServletResponse response){
        UserInfo loginUserInfo=userService.login(userInfo);
        System.out.println(loginUserInfo);
        if(loginUserInfo!=null){

            Cookie username_cookie=new Cookie("username",userInfo.getUsername());
            Cookie password_cookie=new Cookie("password",userInfo.getPassword());
            username_cookie.setMaxAge(60*60*24*7);
            password_cookie.setMaxAge(60*60*24*7);
            response.addCookie(username_cookie);
            response.addCookie(password_cookie);
            session.setAttribute(Consts.CURRENT_USER,loginUserInfo);
            return "redirect:home";
        }
        return "login";
    }

    @RequestMapping(value = "home")
    public String home(){
        return "/home/home";
    }

    @RequestMapping(value = "find")
    public String findAll(HttpSession session){
        List<UserInfo> userInfoList=userService.findAll();
        session.setAttribute("userInfoList",userInfoList);
        return "/user/homelist";
    }
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer userid){
        int count=userService.deleteUser(userid);
        return "redirect:/user/find";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer userId, HttpServletRequest request){
        UserInfo userInfo =userService.findUserById(userId);
        request.setAttribute("userInfo",userInfo);
        return "/user/homeupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String update(UserInfo userInfo,HttpServletRequest request,HttpServletResponse response)throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count=userService.updateUser(userInfo);
        if(count>0){
            return "redirect:/user/find";
        }
        return "/user/homeupdate";
    }
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String insert(){
        return "/user/homeinsert";
    }
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(UserInfo userInfo,HttpServletResponse response,HttpServletRequest request)throws UnsupportedEncodingException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int count=userService.addUser(userInfo);
        if(count>0){
            return "redirect:/user/find";
        }
        return "/user/homeinsert";
    }
}
