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
    private Path path;
    private List<Folder_File_Father> adds;
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
            System.out.println("Este drive ya existe, pruebe con otro drive");
        }
    }

    public void register(String new_user){
        if(!list_users.contains(new_user)){
            list_users.add(new_user);
        }
        else{
            System.out.println("Este usuario ya existe, pruebe con otro nombre");
        }

    }

    public void login(String user){
        if(list_users.contains(user)){
            this.logged_in = user;
        }
        else{
            System.out.println("Este usuario no existe");
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
                path.setCurrent_path(new_path);
                path.setOrigin_path(letter);
            }
            else{
                System.out.println("No hay un usuario logeado");
            }
        }
        else{
            System.out.println("Este drive no existe, pruebe con otro drive");
        }
    }
    public void make_directory(String folder_name, boolean hide, boolean read) {
        if (path.size() > 0) {
            List<Folder_File_Father> Content = find_content(path.getOrigin_path(), path.getRest_path());
            if (!path_exist(folder_name)) {
                String login_user = getLogged_in();
                Content.add(new Folder(folder_name, "folder", login_user));
            }
        }else{
            System.out.println("No hay una ruta de origen donde agregar");
        }
    }

    public void cd(String add_path){ // arreglar por enunciado
        if(someone_login() && path.size() >= 1) {
            switch(add_path){
                case "..":
                    (path.getCurrent_path()).remove(path.size() - 1);
                    (path.getRest_path()).remove(path.size() - 1);

                    break;

                case "/":
                    (path.getCurrent_path()).subList(1, path.size()).clear();
                    path.setRest_path(new ArrayList<>());

                    break;

                default:
                    if(path_exist(add_path)){
                        (path.getCurrent_path()).add(add_path);
                        (path.getRest_path()).add(add_path);
                    }else{
                        System.out.println("Ese directorio no existe dentro de la ruta actual, ingrese uno valido por favor");
                    }
                    break;
            }
        }
        else{
            System.out.println("no se puede realizar esta accion");
        }
    }
    public List<Folder_File_Father> find_content(String origin_path, List<String> rest_path){
        List<Folder_File_Father> content = new ArrayList<>();

        for(Drive drive : list_drive){
            if(Objects.equals(drive.getLetter(), origin_path)){
                content = drive.getContent();
            }
        }

        for(String path : rest_path) {
            for(Folder_File_Father folders : content){
                if(Objects.equals(path, folders.getName())){
                    content = folders.getContent();
                }
            }
        }
        return content;
    }
    public boolean path_exist(String add_path){
        List<Folder_File_Father> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> names = new ArrayList<>();

        for(Folder_File_Father elements : content){
            names.add(elements.getName());
        }

        return names.contains(add_path);
    }
    public String getLogged_in() {
        return logged_in;
    }
}
