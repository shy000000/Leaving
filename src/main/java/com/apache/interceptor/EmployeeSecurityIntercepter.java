package com.apache.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by shy on 2016/9/5.
 */
public class EmployeeSecurityIntercepter implements HandlerInterceptor {
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
        if (session.getAttribute("EmployId") == null) {
            System.out.println(arg0.getContextPath());
            //     arg1.sendRedirect(arg0.getContextPath() + "/login-admin");
            return false;
        }else {
            return true;}

    }
}
