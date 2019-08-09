package com.neuedu.interceptors;


import com.neuedu.consts.Consts;
import com.neuedu.dao.UserInfoMapper;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    IUserService userService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session=request.getSession();

        UserInfo userInfo= (UserInfo) session.getAttribute(Consts.CURRENT_USER);
        String usernamecookie=null;
        String passwordcookie=null;
        if (userInfo!=null){
            return true;
        }
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("username")){
                        usernamecookie=c.getValue();
                    }
                    if(c.getName().equals("password")){
                        passwordcookie=c.getValue();
                    }
                }
            }
            if (usernamecookie!=null&&passwordcookie!=null){
                UserInfo userInfo1=userService.login(usernamecookie,passwordcookie);
                session.setAttribute(Consts.CURRENT_USER,userInfo1);
            }
            UserInfo userInfo1= (UserInfo) session.getAttribute(Consts.CURRENT_USER);
            if(userInfo1!=null){
               return true;
            }
            return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
