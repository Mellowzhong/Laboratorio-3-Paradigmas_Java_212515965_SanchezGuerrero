package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Filesystem_Sanchez_212515965 {
    private String name_system;
    private Date date_now;
    private List<Drive> list_drive;
    private List<String> list_users;
    private String logged_in;
    private List<String> path;
    private String origin_path;
    private List<String> rest_path;
    private List<Elements> adds;
    public boolean someone_login (){
        return !Objects.equals(this.logged_in, "");
    }
    public void setName_system(String name_system) {
        this.name_system = name_system;
    }
    public String getName_system() {
        return name_system;
    }
    public Filesystem_Sanchez_212515965(String name_system) {
        this.name_system = name_system;
        this.date_now = new Date();
        this.list_drive = new ArrayList<>();
        this.list_users = new ArrayList<>();
        this.logged_in = "";
    }
    public void add_drive(String letter, String name, int capacity) {
        Drive new_drive = new Drive(letter, name, capacity);
        List<String> list_letter_drives = new ArrayList<>();

        for(Drive drive : list_drive) {
            list_letter_drives.add(drive.getLetter());
        }

        if(!list_letter_drives.contains(letter)){
            list_drive.add(new_drive);
        }
        else{
            System.out.println("This drive exist, try again with other drive");
        }
    }
    public void register(String new_user){
        if(!list_users.contains(new_user)){
            list_users.add(new_user);
        }
        else{
            System.out.println("This user exist, try again with other user");
        }

    }
    public void login(String user){
        if(list_users.contains(user)){
            this.logged_in = user;
        }
        else{
            System.out.println("This user don't exist");
        }
    }

    public void logout(){
        this.logged_in = "";
    }
    public void switch_drive(String letter){
        List<String> list_letter_drives = new ArrayList<>();
        for(Drive drive : list_drive) {
            list_letter_drives.add(drive.getLetter());
        }

        if(list_letter_drives.contains(letter)) {
            if(someone_login()){
                List<String> new_path = new ArrayList<>();
                new_path.add(letter);
                path = new_path;
                origin_path = letter;
                rest_path = new ArrayList<>();
            }
            else{
                System.out.println("First logged in please");
            }
        }
        else{
            System.out.println("This drive don't exist, try again with other drive");
        }
    }
    public List<Elements> find_content(String origin_path, List<String> rest_path){
        List<Elements> content = new ArrayList<>();

        for(Drive drive : list_drive){
            if(Objects.equals(drive.getLetter(), origin_path)){
                content = drive.getContent();
            }
        }

        for(String path : rest_path) {
            for(Elements folders : content){
                if(Objects.equals(path, folders.getName())){
                    content = folders.getContent();
                }
            }
        }
        return content;
    }
    public void make_directory(String folder_name, boolean hide, boolean read) {
        if (path.size() > 0) {
            List<Elements> Content = find_content(this.origin_path, this.rest_path);
            String login_user = logged_in;
            Content.add(new Folder(folder_name, "folder"));

            System.out.println("No hay una ruta de origen donde agregar");
        }
    }
    public void cd(String add_path){
        if(someone_login() && path.size() >= 1) {
            switch(add_path){
                case "..":
                    path.remove(path.size() - 1);

                    break;

                case "/":
                    this.path.subList(1, path.size()).clear();

                    break;

                default:
                    this.path.add(add_path);

                    break;
            }
        }
        else{
            System.out.println("no se puede realizar esta accion");
        }
    }
}
