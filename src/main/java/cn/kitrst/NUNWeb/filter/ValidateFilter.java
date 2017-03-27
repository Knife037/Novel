package cn.kitrst.NUNWeb.filter;

/**
 * Created by Administrator on 2017/3/25.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidateFilter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("username");

        if (user != null && user != "") {
            return true;
        }
        resp.sendRedirect("/login");
        return false;
    }

}
