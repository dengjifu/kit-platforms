package com.kit.platforms.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

/**
 * Created by Jelly on 2016/8/18.
 * 读取配置文件属性类
 */
@Order(-10)
@Configuration
public class BootstrapProperties implements EnvironmentAware {

    public static String securityUrl;
    @Override
    public void setEnvironment(Environment environment) {
        getPropertiesValue(environment);
    }
    public void getPropertiesValue(Environment environment){
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "csgcustom.");
        securityUrl=propertyResolver.getProperty("security.url");
    }

}
