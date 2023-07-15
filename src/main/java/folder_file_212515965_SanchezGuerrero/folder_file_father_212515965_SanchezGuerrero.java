package folder_file_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.List;

public class folder_file_father_212515965_SanchezGuerrero implements folder_file_interface_212515965_SanchezGuerrero {
    public String name;
    public String type;
    public List<folder_file_father_212515965_SanchezGuerrero> content;
    public boolean read;
    public boolean hide;

    public folder_file_father_212515965_SanchezGuerrero(String name, String type, boolean read, boolean hide) {
        this.name = name;
        this.type = type;
        this.content = new ArrayList<>();
        this.read = read;
        this.hide = hide;
    }

    public String getName() {
        return name;
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
    public boolean isRead() {
        return read;
    }
    public boolean isHide() {
        return hide;
    }
    public List<folder_file_father_212515965_SanchezGuerrero> getContent() {
        return content;
    }
}
