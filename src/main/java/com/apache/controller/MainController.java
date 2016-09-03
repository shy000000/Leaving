package com.apache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shy on 2016/9/1.
 */
@Controller
public class MainController {
    /**
     * 默认访问登陆界面
     * 跳转至员工登陆界面
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "admin-search";
    }

    /**
     * 跳转至管理员登录界面
     * @return
     */
    @RequestMapping(value = "/login-admin",method = RequestMethod.GET)
    public String adminlogin(){
        return "login-admin";
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/employeeLogin",method = RequestMethod.POST)
    public String employLogin(){
        return "mian";
    }

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(){
        return "admin-main";
    }

}
