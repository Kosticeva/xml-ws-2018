package com.xml.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
        .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/register/**").permitAll()
            .antMatchers("/index.html", "/", "/home", "/login/**", "/register/**").permitAll()
            .antMatchers("/service/**").permitAll()
            .antMatchers("/locations", "/search", "/search/advanced").permitAll()
            .antMatchers(HttpMethod.GET, "/accomodation-type", "/accomodation-service", "/accomodation-category","/reviews**").permitAll()
            .antMatchers(HttpMethod.GET, "/accommodation/get/**").permitAll()
            .antMatchers("/**").permitAll() //jbg
            .anyRequest().authenticated()
        .and()
            .rememberMe()
        .and()
            .csrf().disable().exceptionHandling()
        .and()
            .headers().xssProtection().disable()
        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            .maximumSessions(1);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
