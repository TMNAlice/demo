package com.example.demo.db.model;

import javax.persistence.*;

@Entity
@Table (name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "users_id", nullable = false, updatable = false)
    private Long id;

    @Column (nullable = false)
    private String login;

    @Column (nullable = false)
    private String pass_hash;

    public String getLogin (){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getHash (){
        return pass_hash;
    }

    public void setHash(String hash){
        this.pass_hash = hash;
    }
}
