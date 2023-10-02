package com.devstack.healthcare.system.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(List.of("Authorization","Content-Type"));
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        configuration.setExposedHeaders(List.of("Authorization"));

    }
}
