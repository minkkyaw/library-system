package com.minkhantkyaw;

public class Patron {
    private int ID;
    private String name;

    public Patron(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
