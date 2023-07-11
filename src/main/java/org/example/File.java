package org.example;

public class File extends Elements{
    String content;
    public File(String name, String type, String content) {
        super(name, type);
        this.content = content;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content=" + content +
                '}';
    }
}
