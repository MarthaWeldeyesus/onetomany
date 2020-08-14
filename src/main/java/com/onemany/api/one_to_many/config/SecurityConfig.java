package com.onemany.api.one_to_many.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication().withUser("author").password("{noop}password").roles("AUTHOR")
        .and().withUser("admin").password("{noop}password")
        .roles("AUTHOR", "ADMIN");
    }
    protected void configure(HttpSecurity http) throws Exception {
        
        http.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/api/v1/authors").hasRole("USER")
        .antMatchers(HttpMethod.GET, "/api/v1/authors/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/api/v1/authors").hasRole("ADMIN")
        .and().csrf().disable().formLogin().disable();
      }
  
}