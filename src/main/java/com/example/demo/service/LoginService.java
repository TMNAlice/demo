package com.example.demo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {

    public UserDetails loadUserByUsername (String string) throws UsernameNotFoundException;

}
