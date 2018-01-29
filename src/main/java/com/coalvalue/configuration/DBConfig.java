
package com.coalvalue.configuration;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by silence yuan on 2015/9/19.
 */

@Configuration
//@ConfigurationProperties(locations = "classpath:application.properties", prefix="spring.datasource")
@Component
public class DBConfig {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



//setter getter不能少！！！，我配置出问题setter没写可能就是这个原因
}