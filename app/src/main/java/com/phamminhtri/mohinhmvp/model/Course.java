package com.phamminhtri.mohinhmvp.model;

import java.io.Serializable;

public class Course implements Serializable {
    private String title;
    private String description;
    private int idimage;

    public Course(String title, String description, int idimage) {
        this.title = title;
        this.description = description;
        this.idimage = idimage;
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

    public int getIdimage() {
        return idimage;
    }

    public void setIdimage(int idimage) {
        this.idimage = idimage;
    }
}
