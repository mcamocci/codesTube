package com.haikarose.codestube.pojos;

/**
 * Created by root on 12/21/16.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meena
 */

public class Category implements Serializable,Comparable{

    private String type;
    private String name;

    public String getCat_descr() {
        return cat_descr;
    }

    public void setCat_descr(String cat_descr) {
        this.cat_descr = cat_descr;
    }

    public String getSub_cat_descr() {
        return sub_cat_descr;
    }

    public void setSub_cat_descr(String sub_cat_descr) {
        this.sub_cat_descr = sub_cat_descr;
    }
    private String cat_descr;
    private String sub_cat_descr;
    private Long id;
    private List<Post> post=new ArrayList<>();

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

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type=type;
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
}
