package folder_file_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class folder_212515965_SanchezGuerrero extends folder_file_father_212515965_SanchezGuerrero { // plantear lo de los atributos
    private List<folder_file_father_212515965_SanchezGuerrero> content = new ArrayList<>();;
    private Date creation_date = new Date();
    private Date last_modification = new Date();
    private String creation_user;
    private boolean read;
    private boolean hide;
    public folder_212515965_SanchezGuerrero(String name, String type, String login_user, boolean read, boolean hide) {
        super(name, type, read, hide);
        this.read = read;
        this.hide = hide;
        this.creation_user = login_user;
    }

    public List<folder_file_father_212515965_SanchezGuerrero> getContent() {
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
                ", read=" + read +
                ", hide=" + hide +
                '}';
    }
}
