package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Filesystem_Sanchez_212515965 {
    String name_system;
    Date date_now;
    List<Drive> list_drive;
    List<String> list_users;
    String logged_in;
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
}
