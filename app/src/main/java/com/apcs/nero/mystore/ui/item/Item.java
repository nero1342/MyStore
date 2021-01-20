package com.apcs.nero.mystore.ui.item;

import java.io.Serializable;

public class Item implements Serializable {

    private String id;
    private String title;
    private String description;
    private String thumbnailURL;

    public Item(String id, String title, String description, String thumbnailURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailURL = thumbnailURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
