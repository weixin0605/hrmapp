package com.sws.hrmapp.util.interceptor;

import com.sws.hrmapp.entity.User;
import com.sws.hrmapp.util.common.HrmConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizedInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URL = {"/loginForm","/login","/404.html"};

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag = false;
        String servletPath = httpServletRequest.getServletPath();

        for(String s:IGNORE_URL){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            User user = (User)httpServletRequest.getSession().getAttribute(HrmConstants.USER_SESSION);
            if(user == null){
                httpServletRequest.setAttribute("message","请先登录再访问网站");
                httpServletRequest.getRequestDispatcher(HrmConstants.LOGIN).forward(httpServletRequest,httpServletResponse);
                return flag;
            }else{
                flag = true;
            }
        }

        return flag;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
