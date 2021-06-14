package com.example.FinalProject.db.entity;

import java.io.Serializable;

public class Worker implements Serializable {
    private int id;
    private String name;
    private int rate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Worker" + "id=" + id + ", name=" + name + ", rate=" + rate ;
    }
}
