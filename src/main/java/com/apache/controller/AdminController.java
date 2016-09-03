package com.apache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by shy on 2016/9/3.
 */
@Controller
public class AdminController {
    /**
     * 修改员工信息跳转
     * @return
     */
    @RequestMapping(value = "/admin-modify",method = RequestMethod.GET)
    public String adminModify(){
        return "admin-modify";
    }

    /**
     * 查看请加日志跳转
     * @return
     */
    @RequestMapping(value = "/admin-search",method = RequestMethod.GET)
    public String adminsearch(){
        return "admin-search";
    }
}
