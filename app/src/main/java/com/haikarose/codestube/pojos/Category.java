package com.haikarose.codestube.pojos;

/**
 * Created by root on 12/21/16.
 */

public class Category {

    private String title;
    private String description;
    private String time;

    public Category(){

    }
    public Category(String title,String description,String time){
        this.title=title;
        this.time=time;
        this.description=description;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return this.time;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return this.description;
    }
}
