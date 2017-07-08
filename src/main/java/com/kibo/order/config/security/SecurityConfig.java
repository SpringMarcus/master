package com.kibo.order.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@EnableWebMvcSecurity deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    ///////////////
    // AUTOWIRED //
    ///////////////

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /////////////////////
    // Method Override //
    /////////////////////

//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilter(casAuthenticationFilter());
//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(casAuthenticationEntryPoint());
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .authenticationProvider(casAuthenticationProvider());
//    }

    /////////////////////
    // Bean Definition //
    /////////////////////


//    @Bean
//    public CasAuthenticationFilter casAuthenticationFilter() throws Exception {
//        CasAuthenticationFilter casAuthenticationFilter = new CasAuthenticationFilter();
//        casAuthenticationFilter.setAuthenticationManager(authenticationManager());
//        return casAuthenticationFilter;
//    }
//
//    @Bean
//    public CasAuthenticationEntryPoint casAuthenticationEntryPoint() {
//        CasAuthenticationEntryPoint casAuthenticationEntryPoint = new CasAuthenticationEntryPoint();
//        casAuthenticationEntryPoint.setLoginUrl("https://localhost:9443/cas/login");
//        casAuthenticationEntryPoint.setServiceProperties(serviceProperties());
//        return casAuthenticationEntryPoint;
//    }
//
//    @Bean
//    public CasAuthenticationProvider casAuthenticationProvider() {
//        CasAuthenticationProvider casAuthenticationProvider = new CasAuthenticationProvider();
//        casAuthenticationProvider.setAuthenticationUserDetailsService(authenticationUserDetailsService());
//        casAuthenticationProvider.setServiceProperties(serviceProperties());
//        casAuthenticationProvider.setTicketValidator(cas20ServiceTicketValidator());
//        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only");
//        return casAuthenticationProvider;
//    }
//
//    @Bean
//    public ServiceProperties serviceProperties() {
//        ServiceProperties serviceProperties = new ServiceProperties();
//        serviceProperties.setService("https://localhost:8443/cas-sample/j_spring_cas_security_check");
//        serviceProperties.setSendRenew(false);
//        return serviceProperties;
//    }
//
//    @Bean
//    public AuthenticationUserDetailsService authenticationUserDetailsService() {
//        return new TestCasAuthenticationUserDetailsService();
//    }
//
//    @Bean
//    public Cas20ServiceTicketValidator cas20ServiceTicketValidator() {
//        return new Cas20ServiceTicketValidator("https://localhost:9443/cas");
//    }
}
