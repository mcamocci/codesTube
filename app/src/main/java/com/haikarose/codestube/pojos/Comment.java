package com.haikarose.codestube.pojos;

import java.util.Date;

/**
 * Created by root on 12/28/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Comment {

    private Long id;

    private String content;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visiter getVisiter() {
        return visiter;
    }

    public void setVisiter(Visiter visiter) {
        this.visiter = visiter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Visiter visiter;

    private Post post;

}
