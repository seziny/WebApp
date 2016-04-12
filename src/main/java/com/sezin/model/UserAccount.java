package com.sezin.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sezin on 3/23/16.
 * Copyright © 2016 Logitech. All rights reserved.
 */
public class UserAccount {

    @Id
    private String id;
    private String username;
    private String password;


    public UserAccount(){}

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
