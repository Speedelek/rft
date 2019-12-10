package com.buffet.buffet.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Autowired
    private UserDetailsService userService;

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

               // .regexMatchers(".*\\.css$").permitAll()
               // .regexMatchers(".*\\.png$").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers(HttpMethod.GET,"/","/buffet/**/","/products/**").permitAll()
                .antMatchers(HttpMethod.GET,"/","/products/**").permitAll()
                .antMatchers("/buffet").permitAll()
                .antMatchers("/buffet/1").permitAll()
                .antMatchers("/buffet/2").permitAll()
                .antMatchers("/buffet/3").permitAll()
                .antMatchers("/buffet/4").permitAll()
                .antMatchers("/buffet/5").permitAll()
                .antMatchers("/buffet/6").permitAll()
                .antMatchers("/buffet/7").permitAll()
                .antMatchers("/buffet/8").permitAll()
                .antMatchers("/buffet/9").permitAll()
                .antMatchers("/buffet/10").permitAll()
                .antMatchers("/buffet/11").permitAll()
                .antMatchers("/buffet/12").permitAll()
                .antMatchers("/buffet/13").permitAll()
                .antMatchers("/buffet/14").permitAll()
                .antMatchers("/buffet/15").permitAll()
                .antMatchers("/buffet/16").permitAll()
                .antMatchers("/buffet/17").permitAll()
                .antMatchers("/buffet/18").permitAll()
                .antMatchers("/buffet/19").permitAll()
                .antMatchers("/buffet/20").permitAll()
                .antMatchers("/buffet/21").permitAll()
                .antMatchers("/buffet/22").permitAll()
                .antMatchers("/buffet/23").permitAll()
                .antMatchers("/buffet/24").permitAll()
                .antMatchers("/buffet/25").permitAll()
                .antMatchers("/buffet/26").permitAll()
                .antMatchers("/buffet/27").permitAll()
                .antMatchers("/buffet/28").permitAll()
                .antMatchers("/buffet/29").permitAll()
                .antMatchers("/buffet/30").permitAll()
                .antMatchers("/buffet/31").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/reg").permitAll()
                .antMatchers("/activation/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/delete")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

}
