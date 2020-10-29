package com.casestudy.config;

import com.casestudy.service.IAppUserService;
import org.graalvm.compiler.lir.StandardOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class AppSecConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    IAppUserService appUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/khongcoquyen").permitAll()
                .and()
                .authorizeRequests().antMatchers("/categories/**").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/songs/**").hasAnyRole("USER","ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST,"/songs/**").hasAnyRole("USER","ADMIN")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedHandler("/khongcoquyen");
                http.csrf().disable();


    }
}
