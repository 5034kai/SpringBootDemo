package com.example.demo.entity;

public class Member {
    private int id;
    private String name;
    private String email;

    public Member(){}

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //getter
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }
}
