package com.apache.controller;

import com.apache.model.EmployeeEntity;
import com.apache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shy on 2016/9/3.
 */
@Controller
public class AdminController {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping(value = "/adminLogin",method = RequestMethod.POST)
    public String adminLogin(ModelMap modelMap ,HttpServletRequest request){
        String UserName = request.getParameter("form-username");
        String PassWord = request.getParameter("form-password");
        //判断是否为管理员
        if(UserName.equals("110")&&PassWord.equals("120")){
            HttpSession session = request.getSession();
            session.setAttribute("admin","admin");
            return "admin-main";
        }else{
            modelMap.addAttribute("result","1");
            return "login-admin";

        }


    }

    /**
     * 修改员工信息跳转
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify",method = RequestMethod.GET)
    public String adminModify(){
        return "admin-modify";
    }

    /**
     * 查看请加日志跳转
     * @return
     */
    @RequestMapping(value = "/admin/admin-search",method = RequestMethod.GET)
    public String adminsearch(){
        return "admin-search";
    }

    /**
     * 跳转至增添新员工界面
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify-addNew",method = RequestMethod.GET)
    public String addNew(){
        return "admin-modify-addNew";
    }

    /**
     * 新增一名员工
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/adminModifyAddNewSure",method = RequestMethod.POST)
    public String adminModifyAddNewSure(ModelMap modelMap,HttpServletRequest request){
        EmployeeEntity employeeEntity = new EmployeeEntity();

        String EmployIdStr = request.getParameter("employ_Id");
        String NameRes = request.getParameter("name");
        String PhoneRes = request.getParameter("phone");
        String SectionIdRes = request.getParameter("section_id");
        String OrderRes = request.getParameter("order");
        String LimitRes = request.getParameter("limit");

        Integer Limit = Integer.parseInt(LimitRes);
        Integer used = 0;
        employeeEntity.setEmployId(EmployIdStr);
        employeeEntity.setName(NameRes);
        employeeEntity.setPhone(PhoneRes);
        employeeEntity.setSectionId(SectionIdRes);
        employeeEntity.setQuota(Limit);
        employeeEntity.setUsed(used);
        employeeEntity.setLevel(OrderRes);
        employeeEntity.setPassword("000000");

        try{
            employeeRepository.saveAndFlush(employeeEntity);
            modelMap.addAttribute("isAdded","0");

        }catch (Exception e){
            modelMap.addAttribute("isAdded","1");
        }

        return "admin-modify";

    }

    /**
     * 名字查询员工
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify-name",method = RequestMethod.POST)
    public String serchName(ModelMap modelMap,HttpServletRequest request){

        String NameStr = request.getParameter("name");
        List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
        try {
            employeeEntities = employeeRepository.findByName(NameStr);
            modelMap.addAttribute("employeeEntities",employeeEntities);
            return "admin-modify";
        }catch (Exception e){
            return "admin-modify";
        }

    }

    /**
     * 级别查询员工
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify-level",method = RequestMethod.GET)
    public String serchLevel(ModelMap modelMap,HttpServletRequest request){

        String level = request.getParameter("level");
        List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
        try {
            employeeEntities = employeeRepository.findByLevel(level);
            modelMap.addAttribute("employeeEntities",employeeEntities);
            return "admin-modify";
        }catch (Exception e){
            return "admin-modify";
        }

    }

    /**
     * 部门查询员工
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify-sectionId",method = RequestMethod.GET)
    public String serchSectionId(ModelMap modelMap,HttpServletRequest request){

        String sectionId = request.getParameter("sectionId");
        List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
        try {
            employeeEntities = employeeRepository.findBySectionId(sectionId);
            modelMap.addAttribute("employeeEntities",employeeEntities);
            return "admin-modify";
        }catch (Exception e){
            return "admin-modify";
        }

    }

    /**
     * 修改用户信息跳转
     * @return
     */
    @RequestMapping(value = "/admin/admin-modify-update",method = RequestMethod.GET)
    public String update(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        try {
            employeeEntity = employeeRepository.findOne(Id);
        }catch (Exception e){
            System.out.println(e);
        }
        modelMap.addAttribute("employeeEntity",employeeEntity);
        return "admin-modify-update";
    }

    /**
     * 删除员工信息跳转
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/deleteEmployeeId",method = RequestMethod.GET)
    public String deleteEmployeeId(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        employeeRepository.delete(Id);
        modelMap.addAttribute("isDelete","0");
        return "admin-modify";
    }

    /**
     * 更新员工信息
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/adminModifyUpdateSure",method = RequestMethod.POST)
    public String adminModifyUpdateSure(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        String EmployeeIdStr = request.getParameter("employ_Id");
        String NameStr = request.getParameter("name");
        String PhoneStr = request.getParameter("phone");
        String SectionStr = request.getParameter("sectionId");
        String LevelStr = request.getParameter("level");
        String LimitStr = request.getParameter("limit");
        String UsedStr = request.getParameter("used");
        Integer Id = Integer.parseInt(IdStr);
        Integer Limit = Integer.parseInt(LimitStr);
        Integer Used = Integer.parseInt(UsedStr);

        EmployeeEntity employeeEntity = new EmployeeEntity();
        try{
            employeeEntity = employeeRepository.findOne(Id);
            employeeEntity.setEmployId(EmployeeIdStr);
            employeeEntity.setSectionId(SectionStr);
            employeeEntity.setLevel(LevelStr);
            employeeEntity.setQuota(Limit);
            employeeEntity.setName(NameStr);
            employeeEntity.setPhone(PhoneStr);
            employeeEntity.setUsed(Used);
            employeeRepository.saveAndFlush(employeeEntity);
            modelMap.addAttribute("IsUpdate","0");
            return "admin-modify";
        }catch (Exception e){
            modelMap.addAttribute("IsUpdate","1");
            return "admin-modify";
        }
    }

}
