package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filesystem_Sanchez_212515965 {
    String name_system;
    Date date_now;
    List<Drive> list_drive;
    List<String> list_users;
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
}
