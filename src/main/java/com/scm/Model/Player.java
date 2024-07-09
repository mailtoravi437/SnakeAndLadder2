package com.scm.Model;


import lombok.Data;

@Data
public class Player implements Observer{
    private String name;
    private int position;

    public Player(String name){
        this.name = name;
        this.position = 0;
    }
    @Override
    public void update(String message) {
        System.out.println(name+": "+message);
    }
}
