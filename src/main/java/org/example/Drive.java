package org.example;

import java.util.List;

public class Drive {
    String letter;
    String name;
    int capacity;
    List<Folder_File_Father> content;
    public String getLetter() {
        return letter;
    }
    public Drive(String letter, String name, int capacity) {
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
    }

    public List<Folder_File_Father> getContent() {
        return content;
    }
}
