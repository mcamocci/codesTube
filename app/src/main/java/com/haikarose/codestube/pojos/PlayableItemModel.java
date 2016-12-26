package com.haikarose.codestube.pojos;

/**
 * Created by root on 12/23/16.
 */

public class PlayableItemModel {

    public static final String KEY="KEY";
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    private String url;
    private Long id;
}
