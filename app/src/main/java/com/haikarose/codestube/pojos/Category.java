/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haikarose.codestube.pojos;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meena
 */
public class Category implements Serializable,Comparable{

    public static final String NAME="name";

    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    private String description;

    private Long id;
    private List<Post> post=new ArrayList<>();

    private List<CategoryItem> categoryItems=new ArrayList<>();

    public void setPost(Post post){
        this.post.add(post);
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public Long getId(){
        return this.id;
    }



    public String getName(){
        return this.name;
    }

    public List<Post> getPost(){
        return this.post;
    }

    @Override
    public int compareTo(Object o) {
        //To change body of generated methods, choose Tools | Templates.
        Category cat=(Category)o;
        if(cat.getName().equalsIgnoreCase(this.getName())){
            return 0;
        }
        return 1;

    }

    public void addCategoryItem(CategoryItem item){
        this.categoryItems.add(item);
    }

    public List<CategoryItem> getCategoryItems(){
        return this.categoryItems;
    }
}
