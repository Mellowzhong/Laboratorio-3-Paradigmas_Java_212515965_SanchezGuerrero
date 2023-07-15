package drive_212515965_SanchezGuerrero;

import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.List;

public class drive_212515965_SanchezGuerrero implements drive_interface_212515965_SanchezGuerrero {
    private String letter;
    private String name;
    int capacity;
    private List<folder_file_father_212515965_SanchezGuerrero> content;

    public drive_212515965_SanchezGuerrero(String letter, String name, int capacity) {
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }

    public String getLetter() {
        return letter;
    }
    public List<folder_file_father_212515965_SanchezGuerrero> getContent() {
        return content;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setContent(List<folder_file_father_212515965_SanchezGuerrero> content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}

