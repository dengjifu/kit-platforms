package com.kit.platforms.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Jelly on 2016/8/8.
 * 登录状态检测与拦截类
 */
public class FilterLocalLogin implements Filter {

    ServletContext sc = null;
    FilterConfig fc = null;
    private RestTemplate restTemplate =new RestTemplate();

    private  static  final Logger logger = LoggerFactory.getLogger(FilterLocalLogin.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
        sc = filterConfig.getServletContext();
        return;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        servletResponse.setContentType("text/html;charset=UTF-8");
        boolean isExcludedPage = false;

        if ((request).getRequestURI().equals("/index.html")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("==============!!!!!!!!!" + (request).getRequestURI() + "==============");
            HttpSession session = request.getSession();
            if (session != null) {
                BigDecimal userId = (BigDecimal) session.getAttribute("APP_USER");
                if (userId == null) {
                    response.sendRedirect("/index.html");

                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }

            } else {
                response.sendRedirect("/index.html");
            }

        }

    }

    @Override
    public void destroy() {
    }
}
