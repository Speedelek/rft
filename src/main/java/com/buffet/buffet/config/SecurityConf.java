package com.buffet.buffet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
                .authorizeRequests()
                .regexMatchers(".*\\.css$").permitAll()
                //.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers(HttpMethod.GET,"/","/buffet","/products").permitAll()
                //.antMatchers(HttpMethod.GET,"/buffet").permitAll()
                //.antMatchers(HttpMethod.GET,"/products").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/reg").permitAll()
                .antMatchers("/profile").hasAnyRole("USER","ADMIN")
                //.antMatchers("/admin_page").hasRole("ADMIN")
               // .antMatchers("/profile").hasRole("ADMIN")
                .antMatchers("/**").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
