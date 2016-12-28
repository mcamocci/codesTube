package com.haikarose.codestube.pojos;

/**
 * Created by root on 12/28/16.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

/**
 *
 * @author meena
 */
public class CategoryItem implements Serializable {

    private Long id;
    private String description;
    private String name;

    private Category category;


    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }

    public void setId(Long id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setCategory(Category category){
        this.category=category;
    }

}
