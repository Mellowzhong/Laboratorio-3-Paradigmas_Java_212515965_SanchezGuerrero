package org.example;

import java.util.Date;

public class File extends Folder_File_Father {
    String content;
    private Date creation_date = new Date();
    private Date last_modification = new Date();
    private String creation_user;

    public File(String name, String type, String content, String login_user) {
        super(name, type);
        this.content = content;
        this.creation_user = login_user;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content=" + content +
                ", creation_date=" + creation_date +
                ", creation_user=" + creation_user +
                ", last_modification=" + last_modification +
                '}';
    }
}
