package com.haikarose.codestube.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by root on 12/28/16.
 */

public class Post implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Uploader getPoster() {
        return uploader;
    }

    public void setPoster(Uploader poster) {
        this.uploader= poster;
    }

    private Long id;
    private String content;
    private Date date;

    private Uploader uploader;

    private Collection<Comment> comments=new ArrayList();
    private Category category;

    Collection<Resource> resources=new ArrayList();

    public void addResource(Resource resource){
        this.resources.add(resource);
    }

    public void setCategory(Category category){
        this.category=category;
    }

}
