package com.example.demo.service;

import com.example.demo.db.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class Logining extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public Logining (User user){
        super(user.getLogin(), user.getHash(), AuthorityUtils.createAuthorityList("Fake"));
        this.user = user;
    }
}
