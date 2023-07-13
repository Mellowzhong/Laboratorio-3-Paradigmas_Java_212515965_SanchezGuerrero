package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder extends Folder_File_Father { // plantear lo de los atributos
    private List<Folder_File_Father> content = new ArrayList<>();;
    private Date creation_date = new Date();
    private Date last_modification = new Date();
    private String creation_user;
    public Folder(String name, String type, String login_user) {
        super(name, type);
        this.creation_user = login_user;
    }

    public List<Folder_File_Father> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content=" + content +
                ", creation user=" + creation_user +
                ", creation_date=" + creation_date +
                ", last_modification=" + last_modification +
                '}';
    }
}
