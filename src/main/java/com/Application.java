package com;

import com.coalvalue.repository.base.BaseJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
//@EnableJpaRepositories(repositoryBaseClass = BaseJpaRepositoryImpl.class)
/*@EnableJpaRepositories(basePackages = {"com.coalvalue.domain.entity"},
        repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class//指定自己的工厂类
)*/

//@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "jpaAuditorConfiguration")
public class Application extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


      String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

/*        ClassGenerationBean cgb = (ClassGenerationBean) ctx.getBean("classGenerationBean");
        try {
            cgb.generateDomainClass();
            cgb.generateRepositoryClass();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
