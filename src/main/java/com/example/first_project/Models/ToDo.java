package com.example.first_project.Models;

public class ToDo {
    private int id;
    private String content;

    public ToDo(int id, String content){
        this.id = id;
        this.content = content;
    }

    public ToDo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
   

}
