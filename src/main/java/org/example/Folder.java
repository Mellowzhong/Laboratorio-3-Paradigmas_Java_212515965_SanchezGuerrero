package org.example;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Elements{
    List<Elements> content;

    public Folder(String name, String type) {
        super(name, type);
        this.content = new ArrayList<>();
    }

    public List<Elements> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                ", content=" + content +
                '}';
    }
}
