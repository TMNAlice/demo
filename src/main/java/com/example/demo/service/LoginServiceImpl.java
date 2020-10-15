package com.example.demo.service;

import com.example.demo.db.dao.UserRepository;
import com.example.demo.db.model.User;
import com.example.demo.service.Logining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername (String string) throws UsernameNotFoundException{
        User login = userRepository.findByLogin(string);
        if(login == null){
            throw new UsernameNotFoundException("user not found");
        }
        return new Logining (login);
    }
}
