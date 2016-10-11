package com.kit.platforms.config;


import com.kit.platforms.servlet.FilterLocalLogin;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Jelly on 2016/7/28.
 */
@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean filterLocalLoginRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        System.out.println("---------filterLocalLoginRegistrationBean--------");
        FilterLocalLogin llFilter = new FilterLocalLogin();
        filterRegistrationBean.setFilter(llFilter);
        filterRegistrationBean.setEnabled(true);

        filterRegistrationBean.addUrlPatterns("*.html");
        return filterRegistrationBean;
    }

}
