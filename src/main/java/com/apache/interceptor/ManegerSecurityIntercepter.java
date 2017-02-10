package com.apache.interceptor;

import com.apache.model.EmployeeEntity;
import com.apache.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by shy on 2016/9/5.
 */
public class ManegerSecurityIntercepter implements HandlerInterceptor {
    @Autowired
    private EmployeeRepository employeeRepository;

    private List<String> excludedUrls;
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }
    public List<String> getExcludedUrls() {
        return excludedUrls;
    }
    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {

        String requestUri = arg0.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        HttpSession session = arg0.getSession();
        String EmployeeId = session.getAttribute("EmployId").toString();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        try {
            employeeEntity = employeeRepository.findByEmployId(EmployeeId);
        }catch (Exception e){
            System.out.println(e);
        }

        if (employeeEntity.getLevel().equals("0")) {
            System.out.println(arg0.getContextPath());
            //     arg1.sendRedirect(arg0.getContextPath() + "/login-admin");
            return false;
        }else {
            return true;}

    }
}
