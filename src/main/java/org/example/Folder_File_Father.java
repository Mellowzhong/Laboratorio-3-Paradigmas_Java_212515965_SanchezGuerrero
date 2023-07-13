package org.example;

import java.util.ArrayList;
import java.util.List;

public class Folder_File_Father {
    String name;
    String type;
    List<Folder_File_Father > content;

    public Folder_File_Father (String name, String type) {
        this.name = name;
        this.type = type;
        this.content = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Folder_File_Father> getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
