package com.nanos.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        http.csrf().disable()
                .authorizeRequests().antMatchers("/**")
                .permitAll();
        http.headers().frameOptions().disable();
    }
}
