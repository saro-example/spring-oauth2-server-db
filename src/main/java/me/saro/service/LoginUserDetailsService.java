package me.saro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import db.oauth.entity.Account;
import db.oauth.repository.AccountRepository;
import me.saro.example.oauth.configuration.UserDetails;

@Service
public class LoginUserDetailsService implements UserDetailsService
{
    @Autowired AccountRepository accountRepository;
    
    @Override
    public UserDetails loadUserByUsername(String ac) throws UsernameNotFoundException
    {        
        Account account = accountRepository.findByAc(ac).orElseThrow(() -> new UsernameNotFoundException("login fail"));
        
        return new UserDetails(account);
    }
}