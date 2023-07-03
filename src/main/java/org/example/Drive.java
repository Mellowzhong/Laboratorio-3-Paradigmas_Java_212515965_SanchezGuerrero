package org.example;

public class Drive {
    String letter;
    String name;
    int capacity;
    public String getLetter() {
        return letter;
    }
    public Drive(String letter, String name, int capacity) {
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }
}
