package me.saro.example.oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import me.saro.commons.Converter;
import me.saro.commons.converter.HashAlgorithm;
import me.saro.service.LoginUserDetailsService;


@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter
{
    @Autowired LoginUserDetailsService loginUserDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new PasswordEncoder() {
            
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(encode(rawPassword));
            }
            
            @Override
            public String encode(CharSequence rawPassword) {
                return Converter.toHashHex(HashAlgorithm.SHA3_512, rawPassword.toString());
            }
        };
    }
}