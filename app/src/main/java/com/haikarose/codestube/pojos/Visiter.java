package com.haikarose.codestube.pojos;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by root on 12/28/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Visiter implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String email;

    private Collection<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return this.email;
    }

}
