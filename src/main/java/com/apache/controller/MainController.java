package com.apache.controller;

import com.apache.model.EmployeeEntity;
import com.apache.model.LeaveEntity;
import com.apache.repository.EmployeeRepository;
import com.apache.repository.LeaveRepository;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by shy on 2016/9/1.
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    /**
     * 默认访问登陆界面
     * 跳转至员工登陆界面
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("result","0");
        return "login-employee";
    }

    /**
     * 跳转至管理员登录界面
     * @return
     */
    @RequestMapping(value = "/login-admin",method = RequestMethod.GET)
    public String adminlogin(ModelMap modelMap){
        modelMap.addAttribute("result","0");
        return "login-admin";
    }

    /**
     * 用户登录
     * @return
     */
    @RequestMapping(value = "/employeeLogin",method = RequestMethod.POST)
    public String employLogin(ModelMap modelMap, HttpServletRequest request){
        String EmployId = request.getParameter("form-username");
        String PassWord = request.getParameter("form-password");
        EmployeeEntity employeeEntityRes = new EmployeeEntity();

        try{
            employeeEntityRes = employeeRepository.findByEmployId(EmployId);
        }catch (Exception e){
            System.out.println(e);
        }
        if(null == employeeEntityRes){
            modelMap.addAttribute("result","1");
            return "login-employee";
        }else{
            if (PassWord.equals(employeeEntityRes.getPassword())){
                //密码正确
                modelMap.addAttribute("result","0");
                HttpSession session = request.getSession();
                session.setAttribute("EmployId",EmployId);

                EmployeeEntity employeeEntity = employeeRepository.findByEmployId(EmployId);
                Integer quota = employeeEntity.getQuota();
                Integer used = employeeEntity.getUsed();
                Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
                modelMap.addAttribute("persent",persent);
                return "main";

            }else{
                //密码错误
                modelMap.addAttribute("result","1");
                return "login-employee";
            }
        }
    }

    /**
     * 新增请加记录
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/employee/leavingSure",method = RequestMethod.POST)
    public String addLeaving(ModelMap modelMap ,HttpServletRequest request){
        String StartDateTemp = request.getParameter("startDate");
        String OffDayTemp = request.getParameter("offDay");

        LeaveEntity leaveEntity = new LeaveEntity();
        String Approver = "无";
        String Name;
        Integer Offday,State = 0;
        String Type = request.getParameter("type");
        String Reason = request.getParameter("reason");
        HttpSession session = request.getSession();
        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity = employeeRepository.findByEmployId(EmployId);
        Offday = Integer.parseInt(OffDayTemp);
        if(Offday <=0 ){
            modelMap.addAttribute("isLeaving","1");

            Integer quota = employeeEntity.getQuota();
            Integer used = employeeEntity.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);

            return "main";
        }
        if(Offday+employeeEntity.getUsed()>employeeEntity.getQuota()){
            modelMap.addAttribute("isLeaving","1");

            Integer quota = employeeEntity.getQuota();
            Integer used = employeeEntity.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);
            modelMap.addAttribute("fail","1");
            return "main";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date StartDate = sdf.parse(StartDateTemp);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(StartDate);
            calendar.add(calendar.DATE, Offday);
            Date EndDate = calendar.getTime();
            System.out.println(EndDate);
            java.sql.Date dd = new java.sql.Date(StartDate.getTime());
            java.sql.Date pp = new java.sql.Date(EndDate.getTime());
            leaveEntity.setStartDate(dd);
            leaveEntity.setEndDate(pp);
        }catch (ParseException e){
            e.printStackTrace();
        }
        try{
            employeeEntity = employeeRepository.findByEmployId(EmployId);
        }catch (Exception e){
            System.out.println(e);
        }
        Name = employeeEntity.getName();

        leaveEntity.setEmployId(EmployId);
        leaveEntity.setName(Name);

        leaveEntity.setOffDay(Offday);
        leaveEntity.setType(Type);
        leaveEntity.setReason(Reason);
        leaveEntity.setState(State);
        leaveEntity.setApprover(Approver);


        try{

            leaveRepository.save(leaveEntity);
        }catch (Exception e){
            System.out.println(e);
        }
        modelMap.addAttribute("isLeaving","0");

        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);
        return "main";
    }

    /**
     * 重新填写
     * @return
     */
    @RequestMapping(value = "/employee/reWrite",method = RequestMethod.GET)
    public String reWrite(HttpServletRequest request,ModelMap modelMap){

        HttpSession session = request.getSession();
        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);
        return "main";
    }

    /**
     * 跳转至待审批查询界面
     * @return
     */
    @RequestMapping(value = "/employee/waitExamine",method = RequestMethod.GET)
    public String waitExamine(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
        try{
            leaveEntities = leaveRepository.findByEmployId(EmployeeId);
            for (int i = 0;i<leaveEntities.size();i++){
                if(leaveEntities.get(i).getState()!=0)
                {
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-employ-search-waitExamine";
        }catch (Exception e){
            System.out.println(e);
            return "main-employ-search-waitExamine";
        }
    }

    /**
     * 待审批假条详情
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/employee/waitExaminelookDetails",method = RequestMethod.GET)
    public String waitExaminelookDetails(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        modelMap.addAttribute("leaveEntity",leaveEntity);
        return "main-employ-searchDetails";
    }

    /**
     * 待审批假条删除
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/employee/waitExaminedelete",method = RequestMethod.GET)
    public String waitExaminedelete(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        try {
            leaveRepository.delete(Id);
            modelMap.addAttribute("IsDelete","0");
            HttpSession session = request.getSession();
            String EmployId = session.getAttribute("EmployId").toString();
            EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
            Integer quota = employeeEntity2.getQuota();
            Integer used = employeeEntity2.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);
            return "main";
        }catch (Exception e){
            modelMap.addAttribute("IsDelete","1");
            HttpSession session = request.getSession();
            String EmployId = session.getAttribute("EmployId").toString();
            EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
            Integer quota = employeeEntity2.getQuota();
            Integer used = employeeEntity2.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);
            return "main";

        }
    }

    /**
     * 跳转至已批假查询界面
     * @return
     */
    @RequestMapping(value = "/employee/examined",method = RequestMethod.GET)
    public String examined(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
        try{
            leaveEntities = leaveRepository.findByEmployId(EmployeeId);
            for (int i = 0;i<leaveEntities.size();i++){
                if(leaveEntities.get(i).getState()!=1)
                {
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-employ-search-examined";
        }catch (Exception e){
            System.out.println(e);
            return "main-employ-search-examined";
        }

    }

    /**
     * 跳转至被拒绝查询界面
     * @return
     */
    @RequestMapping(value = "/employee/rejected",method = RequestMethod.GET)
    public String rejected(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
        try{
            leaveEntities = leaveRepository.findByEmployId(EmployeeId);
            for (int i = 0;i<leaveEntities.size();i++){
                if(leaveEntities.get(i).getState()!=2)
                {
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-employ-search-rejected";
        }catch (Exception e){
            System.out.println(e);
            return "main-employ-search-rejected";
        }
    }

    /**
     * 跳转至已销假查询界面
     * @return
     */
    @RequestMapping(value = "/employee/destory",method = RequestMethod.GET)
    public String destory(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
        try{
            leaveEntities = leaveRepository.findByEmployId(EmployeeId);
            for (int i = 0;i<leaveEntities.size();i++){
                if(leaveEntities.get(i).getState()!=3)
                {
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-employ-search-destory";
        }catch (Exception e){
            System.out.println(e);
            return "main-employ-search-destory";
        }
    }

    /**
     * 跳转至经理待审核界面
     * @return
     */
    @RequestMapping(value = "/maneger/waitExamine",method = RequestMethod.GET)
    public String manegerwaitExamine(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity = employeeRepository.findByEmployId(EmployeeId);
        String sectionId = employeeEntity.getSectionId();
        if(employeeEntity.getLevel().equals("0")){

            String EmployId = session.getAttribute("EmployId").toString();
            EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
            Integer quota = employeeEntity2.getQuota();
            Integer used = employeeEntity2.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);
            return "main";
        }else if(employeeEntity.getLevel().equals("1")){
            List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
            leaveEntities = leaveRepository.findByState(0);
            for(int i = 0;i<leaveEntities.size();i++){
                String EmployeeId1 = leaveEntities.get(i).getEmployId();
                EmployeeEntity employeeEntity1 = employeeRepository.findByEmployId(EmployeeId1);
                if(!employeeEntity1.getSectionId().equals(employeeEntity.getSectionId())){
                    leaveEntities.remove(i);
                    i--;
                }else if(EmployeeId.equals(EmployeeId1)){
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-maneger-waitExamine";

        }else{
            List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
            leaveEntities = leaveRepository.findAll();
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-maneger-waitExamine";
        }

    }

    /**
     * 经理查看未批准假条详情
     * @return
     */
    @RequestMapping(value = "/maneger/waitExaminelookDetails",method = RequestMethod.GET)
    public String manwaitExaminelookDetails(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        modelMap.addAttribute("leaveEntity",leaveEntity);
        return "main-maneger-details";
    }

    /**
     * 经理批准未批准假条
     * @return
     */
    @RequestMapping(value = "/maneger/waitExamineapprove",method = RequestMethod.GET)
    public String waitExamineapprove(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);

        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        EmployeeEntity employeeEntity = employeeRepository.findByEmployId(leaveEntity.getEmployId());
        employeeEntity.setUsed(employeeEntity.getUsed()+leaveEntity.getOffDay());
        leaveEntity.setState(1);
        leaveEntity.setApprover(employeeEntity2.getName());
        leaveRepository.saveAndFlush(leaveEntity);
        employeeRepository.saveAndFlush(employeeEntity);


        return "main";
    }

    /**
     * 经理拒绝未批准假条
     * @return
     */
    @RequestMapping(value = "/maneger/waitExaminereject",method = RequestMethod.GET)
    public String waitExaminereject(ModelMap modelMap,HttpServletRequest request){

        HttpSession session = request.getSession();
        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);

        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        leaveEntity.setState(2);
        leaveEntity.setApprover(employeeEntity2.getName());
        leaveRepository.saveAndFlush(leaveEntity);

        return "main";
    }

    /**
     * 跳转至经理已审核界面
     * @return
     */
    @RequestMapping(value = "/maneger/examined",method = RequestMethod.GET)
    public String manegerexamined(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity = employeeRepository.findByEmployId(EmployeeId);
        String sectionId = employeeEntity.getSectionId();
        if(employeeEntity.getLevel().equals("0")){

            String EmployId = session.getAttribute("EmployId").toString();
            EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
            Integer quota = employeeEntity2.getQuota();
            Integer used = employeeEntity2.getUsed();
            Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
            modelMap.addAttribute("persent",persent);
            return "main";
        }else if(employeeEntity.getLevel().equals("1")){
            List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
            leaveEntities = leaveRepository.findByState(1);
            for(int i = 0;i<leaveEntities.size();i++){
                String EmployeeId1 = leaveEntities.get(i).getEmployId();
                EmployeeEntity employeeEntity1 = employeeRepository.findByEmployId(EmployeeId1);
                if(!employeeEntity1.getSectionId().equals(employeeEntity.getSectionId())){
                    leaveEntities.remove(i);
                    i--;
                }else if(EmployeeId.equals(EmployeeId1)){
                    leaveEntities.remove(i);
                    i--;
                }
            }
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-maneger-examined";

        }else{
            List<LeaveEntity> leaveEntities = new ArrayList<LeaveEntity>();
            leaveEntities = leaveRepository.findAll();
            modelMap.addAttribute("leaveEntities",leaveEntities);
            return "main-maneger-examined";
        }

    }
    /**
     * 经理查看已批准假条详情
     * @return
     */
    @RequestMapping(value = "/maneger/examinedlookDetails",method = RequestMethod.GET)
    public String manexaminedlookDetails(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        modelMap.addAttribute("leaveEntity",leaveEntity);
        return "main-maneger-details1";
    }
    /**
     * 经理销假
     * @return
     */
    @RequestMapping(value = "/maneger/examineddestory",method = RequestMethod.GET)
    public String examineddestory(ModelMap modelMap,HttpServletRequest request){
        String IdStr = request.getParameter("id");
        Integer Id = Integer.parseInt(IdStr);
        LeaveEntity leaveEntity = leaveRepository.findOne(Id);
        leaveEntity.setState(3);
        leaveRepository.saveAndFlush(leaveEntity);

        HttpSession session = request.getSession();
        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);
        return "main";
    }




    /**
     * 跳转至用户更新个人信息界面
     * @return
     */
    @RequestMapping(value = "/employee/update",method = RequestMethod.GET)
    public String update(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        Object EmployeeIdObj = session.getAttribute("EmployId");
        String EmployeeId = EmployeeIdObj.toString();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        try {
            employeeEntity = employeeRepository.findByEmployId(EmployeeId);
            modelMap.addAttribute("employeeEntity",employeeEntity);
        }catch (Exception e){
            System.out.println(e);
        }
        return "main-setting-update";
    }

    /**
     * 更新
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(value = "/employee/updateSure",method = RequestMethod.POST)
    public String updateSure(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        String NameStr = request.getParameter("name");
        String PhoneStr = request.getParameter("phone");
        String Password = request.getParameter("password");

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeRepository.findByEmployId(EmployeeId);
        employeeEntity.setName(NameStr);
        employeeEntity.setPhone(PhoneStr);
        employeeEntity.setPassword(Password);


        String EmployId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity2 = employeeRepository.findByEmployId(EmployId);
        Integer quota = employeeEntity2.getQuota();
        Integer used = employeeEntity2.getUsed();
        Double persent = Double.parseDouble(used.toString())*100/Double.parseDouble(quota.toString());
        modelMap.addAttribute("persent",persent);
        try {
            employeeRepository.saveAndFlush(employeeEntity);
            modelMap.addAttribute("IsUpdate","0");
            return "main";
        }catch (Exception e){
            System.out.println(e);
            modelMap.addAttribute("IsUpdate","1");
            return "main";
        }


    }

    /**
     * 跳转至公司请假注意事项界面
     * @return
     */
    @RequestMapping(value = "/employee/notice",method = RequestMethod.GET)
    public String notice(ModelMap modelMap){
        return "main-setting-notice";
    }

    /**
     * 注销用户
     * @return
     */
    @RequestMapping(value = "/employee/logOff",method = RequestMethod.GET)
    public String logOff(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("EmployId");
        return "login-employee";
    }





}
