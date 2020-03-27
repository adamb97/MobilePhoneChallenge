package com.adam;

import java.sql.SQLOutput;

public class Contacts {


    public Contacts(String name, int number){
        this.name = name;
        if(number >= 0){
            this.number = number;
        } else {
            System.out.println("Error, invalid number input");
        }
    }
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

