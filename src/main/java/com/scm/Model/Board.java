package com.scm.Model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private static Board INSTANCE;
    private int size;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;

    private Board(int size){
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public static Board getInstance(int size){
        if(INSTANCE==null){
            INSTANCE = new Board(size);
        }
        return INSTANCE;
    }

    public int getSize(){
        return size;
    }

    public Map<Integer,Integer> getSnakes(){
        return snakes;
    }

    public Map<Integer,Integer> getLadders(){
        return ladders;
    }

    public void addSnake(int start,int end){
        snakes.put(start,end);
    }

    public void addLadders(int start,int end){
        ladders.put(start,end);
    }
}
