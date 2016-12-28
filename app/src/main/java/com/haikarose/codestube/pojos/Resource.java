package com.haikarose.codestube.pojos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 12/28/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Resource implements Serializable {

    private Long id;
    private String url;
    private Date date;
    private String type;

    private Post post;

    public Post getPost(){
        return this.post;
    }

    public void setPost(Post post){
        this.post=post;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public void setType(String type){
        this.type=type;
    }

    public Date getDate(){
        return this.date;
    }

    public String getType(){
        return this.type;
    }

}
