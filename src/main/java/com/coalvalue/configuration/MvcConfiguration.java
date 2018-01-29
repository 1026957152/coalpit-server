package com.coalvalue.configuration;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;


/**
 * Created by zhongkw on 1/5/2015.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public Module springDataPageModule() {
        return new SimpleModule().addSerializer(Page.class, new JsonSerializer<Page>() {
            @Override
            public void serialize(Page value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartObject();
                gen.writeNumberField("totalElements",value.getTotalElements());
                gen.writeFieldName("content");
                serializers.defaultSerializeValue(value.getContent(),gen);
                gen.writeEndObject();
            }
        });
    }

@Autowired(required = true)
public void configeJackson(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
    jackson2ObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
}
/*
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*/
/**").addResourceLocations("static/").addResourceLocations("/WEB-INF/")
                .addResourceLocations("/WEB-INF/files*/
/*")
                .addResourceLocations("./files/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("./").addResourceLocations("file:///./m/src/main/");
    }
*/


  // resource 只能在 webapp下面
//    public static final String BASE_DIR = File.separator + "files" + File.separator;
    //  FileUtil 指定 存储位置，  而， 这里 是 容许 该存储位置 ，能 被访问到
    @Bean(name = "taskExecutor")
    TaskExecutor getTaskExecutorBean(){
        ThreadPoolTaskExecutor pooltaskExec = new ThreadPoolTaskExecutor();
        pooltaskExec.setMaxPoolSize(100);
        pooltaskExec.setQueueCapacity(100);
        pooltaskExec.setCorePoolSize(5);
        pooltaskExec.setKeepAliveSeconds(60);
        return pooltaskExec;
    }





    @Bean
    public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {

            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof JettyEmbeddedServletContainerFactory) {
                //    customizeJetty((JettyEmbeddedServletContainerFactory) container);
                }
            }


            /*
            private void customizeJetty(JettyEmbeddedServletContainerFactory factory) {
                factory.addServerCustomizers(new JettyServerCustomizer() {
                    @Override
                    public void customize(Server server) {
                       SslContextFactory sslContextFactory = new SslContextFactory();
                        sslContextFactory.setKeyStorePassword("pwd12345");
                        try {
                            sslContextFactory.setKeyStorePath(ResourceUtils.getFile(
                                    "classpath:coalvalue.keystore").getAbsolutePath());
                        }
                        catch (FileNotFoundException ex) {
                            throw new IllegalStateException("Could not load keystore", ex);
                        }
                        SslSocketConnector sslConnector = new SslSocketConnector(
                                sslContextFactory);
                        sslConnector.setPort(9993);
                        sslConnector.setMaxIdleTime(60000);
                        server.addConnector(sslConnector);
                    }
                });
            }
            */
        };
    }




/*    *//** add by zhaoyuan 2015/07/30
     * 配置拦截器
     * @author lance
     * @param registry
     */


    public void addInterceptors(InterceptorRegistry registry) {

    //    registry.addInterceptor(sessionTrackerInterceptor);
      //  registry.addInterceptor(avoidDuplicateSubmissionInterceptor);
    //    registry.addInterceptor(tokenInterceptor);

       // registry.addInterceptor(new SessionTrackerInterceptor()).addPathPatterns("*//**");
       // registry.addInterceptor(new SessionTrackerInterceptor()).addPathPatterns("/user*//**");

    }
/*
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ActiveUserWebArgumentResolver());
    }
*/

    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader(){
        return new ClassPathTldsLoader();
    }

}

