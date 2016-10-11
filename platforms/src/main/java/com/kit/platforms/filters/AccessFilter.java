//package com.kit.platforms.filters;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by hadoop on 2016/8/18/018.
// */
//@WebFilter(filterName="AccessFilter",urlPatterns="/*")
//public class AccessFilter extends HttpServlet implements Filter {
//
//    private  static  final Logger logger = LoggerFactory.getLogger(AccessFilter.class);
//    private static final long serialVersionUID = 1L;
//
//    @Value("${csgcustom.workbenchRequest.Port}")
//    private String requestPort;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        HttpServletRequest httprequest = (HttpServletRequest) request;
//
//        String [] ports = requestPort.split(",");
//        String origin=httprequest.getHeader("Origin");
//        logger.info("请求头Origin="+origin+"=访问IP："+request.getRemoteHost());
//        if (origin!=null){
//            for(String port : ports){
//                if(origin.indexOf(port)!=-1){
//                    httpResponse.setHeader("Access-Control-Allow-Origin", origin);
//                    httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
//                    httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
//                    chain.doFilter(request, httpResponse);
//                }
//            }
//        }else {
//            chain.doFilter(request, httpResponse);
//        }
//
//    }
//}
