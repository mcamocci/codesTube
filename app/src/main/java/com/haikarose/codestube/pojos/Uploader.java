package com.haikarose.codestube.pojos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collection;

public class Uploader {

    private Long id;
    private String name;
    private String password;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Post> getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post.add(post);
    }

    private Collection<Post> post=new ArrayList();


    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return this.email;
    }
}
