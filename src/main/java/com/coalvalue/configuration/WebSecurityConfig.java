package com.coalvalue.configuration;/*
package com.coalvalue.configuration;

*/
/**
 * Created by zohu on 3/9/2015.
 *//*


//import com.coalvalue.configuration.filter.AuthenticationFilter;
//import com.coalvalue.security.*;
//import com.coalvalue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true,proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //private static PasswordEncoder encoder;


   // @Autowired
    //public FakeUserDetailsService fakeUserDetailsService;

 //   @Autowired
  //  public UserService userService;


    @Autowired
    public DataSource dataSource;

 //   @Autowired
  //  public DomainUsernamePasswordAuthenticationProvider domainUsernamePasswordAuthenticationProvider;

*/
/*    @Bean(name="youAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*//*


*/
/*    @Bean(name = "youAuthenticationManager")
    public AuthenticationManager youAuthenticationManager()  {

        try {
            return authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*//*



*/
/*    @Bean
    public MethodSecurityService methodSecurityService() {
        return new MethodSecurityServiceImpl();
    }*//*


*/
/*    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new MySecurityConfigurer();
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public static class MySecurityConfigurer extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder builder)throws Exception {
            builder.inMemoryAuthentication()
                    .withUser("zhuanyuan11@qq.com").password("123456").roles(CommonConstant.USER_ROLE_DRIVER)
                    .and().withUser("admin").password("admin").roles("ADMIN");
        }
    }*//*


*/
/*    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
   @Override
    protected void configure ( AuthenticationManagerBuilder builder ) throws Exception {

        builder . inMemoryAuthentication ( ) . withUser ( "user" ) . password ( "user" ) . roles ( "USER" ) . and ( ) . withUser ( "admin" )

                . password ( "admin" ) . roles ( "ADMIN" ) ;

    }
    *//*

  */
/*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(domainUsernamePasswordAuthenticationProvider).

           //     auth.authenticationProvider(domainUsernamePasswordAuthenticationProvider()).
                //   authenticationProvider(backendAdminUsernamePasswordAuthenticationProvider()).
                 //      authenticationProvider(tokenAuthenticationProvider());
              authenticationProvider(wxTokenAuthenticationProvider());

        //auth.userDetailsService(fakeUserDetailsService());
       //         .passwordEncoder(passwordEncoder());
    }*//*

  */
/*  @Bean
    public PasswordEncoder passwordEncoder() {
        if(encoder == null) {
            encoder = new BCryptPasswordEncoder();
        }
        return encoder;
    }*//*





  */
/*  @Bean
           public AuthenticationProvider tokenAuthenticationProvider() {
               return new TokenAuthenticationProvider(tokenService());
    }
    @Bean
    public AuthenticationProvider wxTokenAuthenticationProvider() {
        return new WxTokenAuthenticationProvider(wxTokenService(),null);
    }
    //@Bean(name = "fakeUserDetailsService")
    public UserDetailsService fakeUserDetailsService() {
        return fakeUserDetailsService;
    }*//*

 */
/*   @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable();
http . authorizeRequests ( ) . anyRequest ( ) . authenticated ( ) . and ( ) . httpBasic ( ) ;
        http.authorizeRequests().antMatchers("/", "/home").permitAll();
    }
*//*


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources*/
/**"); // #3
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // securityPrequisite = new
        //       org.springframework.boot.autoconfigure.security.SecurityPrerequisite H = new
       // http . authorizeRequests ( ) . antMatchers ( "/rest*/
/**" ) . authenticated ( ) ;


        http.
                csrf().disable();
        http //.requestMatchers().antMatchers("/wx/register-scene")
               // .and()
                . authorizeRequests ( ).//.authorizeUrls()
              //  .antMatchers("/usercenter*/
/**").authenticated()//.exceptionHandling().accessDeniedPage("/error/403");
        antMatchers("/wx/register-scene").permitAll()

        .antMatchers("/wx*/
/**").permitAll().
                antMatchers("/wx/signin").permitAll()


                .antMatchers("/wx*/
/**", "/homepage").permitAll()
                .antMatchers("/usercenter*/
/**").permitAll()

                .antMatchers("/").permitAll()


                .antMatchers("/api/v1/verificationcode").permitAll()

                .antMatchers("/api/v1/capacities*/
/**").permitAll()
                .antMatchers("/api/v1//area/coalType/supplies").permitAll()

                .antMatchers("/api/v1/companies*/
/**").permitAll()
                .antMatchers("/api/v1/supplies*/
/**").permitAll()
                .antMatchers("/api/v1/capacities*/
/**").permitAll()

                .antMatchers("/api/v1/search*/
/*").permitAll()
              //  .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .antMatchers("/api/v1/user").permitAll()



                .        //        anyRequest ( ) . authenticated ( ) . and ( ) . httpBasic ( );//.authenticationEntryPoint(restAuthenticationEntryPoint)
        antMatchers("/api/v1*/
/**").authenticated()//.antMatchers("/wx*/
/**").authenticated()
            //    .antMatchers("*/
/**").permitAll()
        .antMatchers("/mobile/usercenter*/
/**").authenticated()
                .and().formLogin().loginPage("/mobile/user/login")
             //   .successHandler(successHandler())
                .and().httpBasic().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/mobile/user/logout")).logoutSuccessUrl("/mobile/index");
        ;
            //    .and()
              //  .rememberMe().tokenRepository(persistentTokenRepository())
           //     .tokenValiditySeconds(1209600);//.and().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());
        //.and()
              //  .exceptionHandling().accessDeniedPage("/error/403").
        //and()
        // exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());;
        //  http.authorizeRequests().antMatchers("/", "/home").permitAll();
        //   .formLogin()    //指定登录页是”/login”   .loginPage("/login")
        //    .permitAll()    //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
        //     .successHandler(loginSuccessHandler());//code3
     // http.addFilterBefore(new AuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
        ;


    }
        public AuthenticationEntryPoint unauthorizedEntryPoint() {
            return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

*/
/*
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        //MyCustomLoginSuccessHandler


     //   String storageSpaceRejectOperationsUrl =   linkTo(methodOn(MobileUserCenterController.class).dashboard( null,null, null)).withSelfRel().getHref();

        return new MyCustomLoginSuccessHandler("/mobile/dashboard");
*//*

*/
/*        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;*//*
*/
/*

    }
*//*


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

}
*/
/*
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        //  entryPoint.realmName = "Spring Boot";
        http.exceptionHandling().authenticationEntryPoint(entryPoint);
        http.requestMatchers().antMatchers("*/
/**").anyRequest()
                .and().httpBasic().and().anonymous().disable().csrf().disable();
      http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/v1.0*/
/**").hasRole("USER")
                .anyRequest().authenticated();
        http.httpBasic().realmName("My API");
  //  @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("username")
                .password("password")
                .roles("USER");
    }
}
        */
