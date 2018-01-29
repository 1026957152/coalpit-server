package com.coalvalue.configuration;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * freemaker spring.tld 加载路径
 */
public class ClassPathTldsLoader  {

    /**
     * 指定路径
     */
    private static final String SECURITY_TLD = "/META-INF/security.tld";

    final private List<String> classPathTlds;

    public ClassPathTldsLoader(String... classPathTlds) {
        super();
        if(ArrayUtils.isEmpty(classPathTlds)){
            this.classPathTlds = Arrays.asList(SECURITY_TLD);
        }else{
            this.classPathTlds = Arrays.asList(classPathTlds);
        }
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @PostConstruct
    public void loadClassPathTlds() {
        freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(classPathTlds);
    }
}
