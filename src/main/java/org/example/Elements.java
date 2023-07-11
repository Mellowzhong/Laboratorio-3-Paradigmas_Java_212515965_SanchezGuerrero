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

    public String getName() {
        return name;
    }

    public List<Elements> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Elements{" +
                "name='" + name + '\'' +
                ", content=" + content +
                ", creator_user='" + creator_user + '\'' +
                ", creation_date=" + creation_date +
                '}';
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
