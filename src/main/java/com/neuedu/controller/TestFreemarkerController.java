package com.neuedu.controller;

import com.neuedu.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestFreemarkerController {

    @RequestMapping("/ftl")
    public String testftl(HttpSession session){

        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("zs");
        session.setAttribute("user",userInfo);
        return "home";
    }
}
