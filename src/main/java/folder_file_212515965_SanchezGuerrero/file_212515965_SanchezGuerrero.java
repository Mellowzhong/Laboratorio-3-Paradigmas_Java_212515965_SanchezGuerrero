package folder_file_212515965_SanchezGuerrero;

import java.util.Date;

public class file_212515965_SanchezGuerrero extends folder_file_father_212515965_SanchezGuerrero {
    String content;
    private Date creation_date = new Date();
    private Date last_modification = new Date();
    private String creation_user;
    private boolean read;
    private boolean hide;

    public file_212515965_SanchezGuerrero(String name, String type, String content, String login_user, boolean read, boolean hide) {
        super(name, type, read, hide);
        this.content = content;
        this.read = read;
        this.hide = hide;
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
                ", read=" + read +
                ", hide=" + hide +
                '}';
    }
}
