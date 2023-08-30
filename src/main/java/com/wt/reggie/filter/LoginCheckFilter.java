package com.wt.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.wt.reggie.common.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否完成登录
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    // 路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 无需处理的路径
        String[] urls = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/sendMsg",
                "/common/**",
                "/user/login"
        };

        // 1. 获取本次请求的uri
        String requestURI = request.getRequestURI();
        // 2. 判断本次请求是否需要处理
        if (check(urls, requestURI)) {
            filterChain.doFilter(request,response);
            return ;
        }

        log.info("拦截到请求: {}", requestURI);

        // 3.1 判断员工是否进行登录
        if (request.getSession().getAttribute("employee") != null) {
            log.info("员工已登录，用户id为: {}", request.getSession().getAttribute("employee"));

            // 保存登录用户id
            BaseContext.setCurrentId((Long)request.getSession().getAttribute("employee"));;

            filterChain.doFilter(request,response);
            return ;
        }

        // 3.2 判断用户是否进行登录
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录，用户id为: {}", request.getSession().getAttribute("user"));

            // 保存登录用户id
            BaseContext.setCurrentId((Long)request.getSession().getAttribute("user"));;

            filterChain.doFilter(request,response);
            return ;
        }

        // 4. 未登录，通过输出流的方式向客户端响应数据
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    /**
     * 校验请求路径
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
