package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Elements {
    String name;
    String type;
    List<Elements> content;
    String creator_user;
    Date creation_date;

    public Elements(String name, String type) {
        this.name = name;
        this.type = type;
        this.content = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Elements{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content=" + content +
                '}';
    }
}