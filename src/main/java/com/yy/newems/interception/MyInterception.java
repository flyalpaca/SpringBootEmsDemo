package com.yy.newems.interception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterception implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //获取当前的请求路径

        String path = request.getServletPath();
        //放行静态路径
        if (path.startsWith("/css/") || path.startsWith("/img/") || path.startsWith("/js/")) {
            return true;
        }
        //放行登陆请求
        if (path.equals("/user/toLogin") || path.equals("/user/login") ||
                path.equals("/user/toreg") || path.equals("/user/reg") || path.equals("/")|| path.equals("/user/check") || path.equals("/user")) {
            return true;
        }
        //获取session中的username值
        Object name = request.getSession().getAttribute("name");
        if (name == null) {
            //未登陆，返回登陆页面
            request.setAttribute("msg", "请先登陆");
            request.getRequestDispatcher("/user").forward(request, response);
            return false;
        } else {
            //直接放行
            return true;
        }

    }

}
