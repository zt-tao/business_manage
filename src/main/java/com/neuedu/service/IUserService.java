package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

public interface IUserService {

    public UserInfo login(UserInfo userInfo) throws MyException;
    public UserInfo login(String username,String password)throws MyException;
    public List<UserInfo> findAll()throws MyException;
    public int deleteUser(int userId)throws MyException;
    public int addUser(UserInfo userInfo)throws MyException;
    public int updateUser(UserInfo userInfo)throws MyException;
    public UserInfo findUserById(int userid);
}
