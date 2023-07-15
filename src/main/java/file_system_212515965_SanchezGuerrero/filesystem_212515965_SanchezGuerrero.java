package file_system_212515965_SanchezGuerrero;

import drive_212515965_SanchezGuerrero.drive_212515965_SanchezGuerrero;

import folder_file_212515965_SanchezGuerrero.file_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;
import path.path_212515965_SanchexGuerrero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class filesystem_212515965_SanchezGuerrero implements filesystem_interface_212515965_SanchezGuerrero {
    private String name_system;
    private Date date_now;
    private List<drive_212515965_SanchezGuerrero> list_drive;
    private List<String> list_users;
    private String logged_in;
    private path_212515965_SanchexGuerrero path;
    private List<folder_file_father_212515965_SanchezGuerrero> Recicle_bin;
    public filesystem_212515965_SanchezGuerrero(String name_system) {
        this.name_system = name_system;
        this.date_now = new Date();
        this.list_drive = new ArrayList<>();
        this.list_users= new ArrayList<>();
        this.logged_in = "";
        this.path = new path_212515965_SanchexGuerrero(new ArrayList<>(), "", new ArrayList<>());
    }

    public void add_drive(String letter, String name, int capacity) {
        drive_212515965_SanchezGuerrero new_drive = new drive_212515965_SanchezGuerrero(letter, name, capacity);
        List<String> list_letter_drives = new ArrayList<>();

        for(drive_212515965_SanchezGuerrero drive : list_drive) {
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
       for(drive_212515965_SanchezGuerrero drive : list_drive) {
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
       if (path.path_size() > 0) {
           List<folder_file_father_212515965_SanchezGuerrero> Content = find_content(path.getOrigin_path(), path.getRest_path());
           if (!path_exist(folder_name)) {
               String login_user = getLogged_in();
               Content.add(new folder_212515965_SanchezGuerrero(folder_name, "folder", login_user,hide, read));
           }else{
               System.out.println("Esa carpeta ya existe");
           }
       }else{
           System.out.println("No hay una ruta de origen donde agregar");
       }
   }
   public void cd(List<String> add_path) {
       if (someone_login() && path.path_size() > 0) {

           if(add_path.isEmpty()){
               (path.getCurrent_path()).subList(1, path.path_size()).clear();
               path.setRest_path(new ArrayList<>());
           }
           for(String action_path : add_path){
               if(action_path.equals("..")){
                   (path.getCurrent_path()).remove(path.path_size() - 1);
                   (path.getRest_path()).remove(path.path_size() - 1);
               }
               else{
                   if(path_exist(action_path)){
                       (path.getCurrent_path()).add(action_path);
                       (path.getRest_path()).add(action_path);
                   }
               }
           }
       }else{
           System.out.println("no se puede realizar esta accion");
       }
   }
    public void add_file(String file_name, String file_content, boolean hide, boolean read){
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        if(path.path_size() > 0){
            List<String> name_type_file = List.of(file_name.split("\\."));
            String login_user = getLogged_in();
            folder_file_father_212515965_SanchezGuerrero new_file = new file_212515965_SanchezGuerrero(name_type_file.get(0), name_type_file.get(1), file_content, login_user, hide, read);

            if (!path_exist(name_type_file.get(0))){
                content.add(new_file);
            }else {
                for(folder_file_father_212515965_SanchezGuerrero elements : content){
                    content.remove(elements);
                    content.add(new_file);
                }
            }
        }else{
            System.out.println("No hay una ruta de origen donde agregar");
        }
    }

    public void del(String del_element){ // solo esta el caso en que sea algo especifico
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> name_type = List.of(del_element.split("\\."));

        if (name_type.size() < 2) {
            if(Objects.equals(name_type.get(0), "*")){
                content = new ArrayList<>();


            }else {
                for(folder_file_father_212515965_SanchezGuerrero file_folder : content){
                    if(Objects.equals(file_folder.getName(), name_type.get(0))){

                    }
                }
                content.removeIf(file_folder -> Objects.equals(file_folder.getName(), name_type.get(0)));
            }
        }
        if (Objects.equals(name_type.get(0), "*") && Objects.equals(name_type.get(1), "*")) {

            content = new ArrayList<>();
        }
        if (Objects.equals(name_type.get(0), "*")) {

            content.removeIf(file_folder -> Objects.equals(file_folder.getName(), name_type.get(1)));
        }
        else{

            content.removeIf(file_folder -> (Objects.equals(file_folder.getName(), name_type.get(0))) && (Objects.equals(file_folder.getType(), name_type.get(1))));
        }
    }
    //NO se implemento los comodines con el *
    // copia solo los archivos terminados en .jpg que hay en el directorio actual
    public void copy (String copy_name, String target_path){ // probar que esto funcione
        folder_file_father_212515965_SanchezGuerrero copy = new folder_file_father_212515965_SanchezGuerrero("", "", false, false);
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> new_path = List.of(target_path.split("/"));
        String new_origin_path = (new_path.get(0)).toUpperCase();
        List<String> new_rest_path = new_path.subList(1, new_path.size() - 1);

        for(folder_file_father_212515965_SanchezGuerrero file_folder : content){
            if(Objects.equals(file_folder.getName(), copy_name)){
                copy = file_folder;
            }
        }

        if(Objects.equals(copy.getName(), "")){
            System.out.println("Ese archivo o carpeta no se encuentra en el directorio actual");

        }else{
            List<folder_file_father_212515965_SanchezGuerrero> new_content = find_content(new_origin_path, new_rest_path);

            new_content.add(copy);
        }
    }
    //NO se implemento los comodines con el *
    //En caso de que exista debe ser reemplazado
    public void move (String move_name, String target_path){ //tambien probar que funcione
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> new_path = List.of(target_path.split("/"));
        List<String> new_rest_path = new_path.subList(1, new_path.size() - 1);
        String new_origin_path = (new_path.get(0)).toUpperCase();
        folder_file_father_212515965_SanchezGuerrero copy = new folder_file_father_212515965_SanchezGuerrero("", "", false, false);

        for(folder_file_father_212515965_SanchezGuerrero file_folder : content){
            if(Objects.equals(file_folder.getName(), move_name)){
                copy = file_folder;
                content.remove(file_folder);
            }
        }

        if(Objects.equals(copy.getName(), "")){
            System.out.println("Ese archivo o carpeta no se encuentra en el directorio actual");

        }else{
            List<folder_file_father_212515965_SanchezGuerrero> new_content = find_content(new_origin_path, new_rest_path);

            new_content.add(copy);
        }
    }
    public void ren (String file_folder_name, String new_name){ // haer que compruebe si el archivo es de solo lectura
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> name_type = List.of(new_name.split("\\."));
        for (folder_file_father_212515965_SanchezGuerrero file_folder : content) {
            if (Objects.equals(file_folder.getName(), file_folder_name) && name_type.size() > 2 && !file_folder.isRead()) {
                file_folder.setName(name_type.get(0));
                file_folder.setType(name_type.get(1));
            }
            if (Objects.equals(file_folder.getName(), file_folder_name) && !file_folder.isRead()) {
                file_folder.setName(name_type.get(0));
            }
            else{
                System.out.println("Esta carpeta o archivo esta con el atributo de sguridad de solo lectura, no se puede modioficar");
            }
        }
    }
    public void dir(List<String> params){
        List<String> file_folder_names = new ArrayList<>();
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());

        for(String element : params){
            if(Objects.equals(element, "/s")){
                for(folder_file_father_212515965_SanchezGuerrero folder_file : content){

                }

            }
            if(element == "/a"){
                //mostrar directorio actual incluyendo lo oculto
            }
            if(element == "/o N"){
                //mostrar el contenido del directorio actual en orden alfabetico (ascendente)
            }
            if(element == "/o -D"){
                //directorio actual segun fecha de creacion (orden decendente)
            }
            if(element == "/o D"){
                //lista del contenido del directorio actual segun la fecha de creacion
            }
            if(Objects.equals(element, "/?")){
                System.out.println("Se pueden usar los parametros:");
                System.out.println("/s: sirve para mostrar el directorio actual y todos los subdirectorios");
                System.out.println("/a: sirve para mostrar el directorio actual incluyendo lo oculto");
                System.out.println("/o N: sirve para mostrar el contenido del directorio actual en orden alfabetico");
                System.out.println("/o -D: sirve para mostrar el directorio actual segun fecha de cracion (orden decendente)");
                System.out.println("/o D: sirve para mostrar el directorio actual segun fecha de creacion");
            }
        }
    }
    //Metodos auxiliares
    public String getName_system() {
        return name_system;
    }
    public String getLogged_in() {
        return logged_in;
    }
    public boolean someone_login (){
        return !Objects.equals(this.logged_in, "");
    }
    public List<folder_file_father_212515965_SanchezGuerrero> find_content(String origin_path, List<String> rest_path){
        List<folder_file_father_212515965_SanchezGuerrero> content = new ArrayList<>();

        for(drive_212515965_SanchezGuerrero drive : list_drive){
            if(Objects.equals(drive.getLetter(), origin_path)){
                content = drive.getContent();
            }
        }

        for(String path : rest_path) {
            for(folder_file_father_212515965_SanchezGuerrero folders : content){
                if(Objects.equals(path, folders.getName())){
                    content = folders.getContent();
                }
            }
        }
        return content;
    }
    public boolean path_exist(String add_path){
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> names = new ArrayList<>();

        for(folder_file_father_212515965_SanchezGuerrero elements : content){
            names.add(elements.getName());
        }

        return names.contains(add_path);
    }
    @Override
    public String toString() {
        return "name_system='" + name_system + '\'' + "\n" +
                "creation_date=" + date_now + "\n" +
                "list_drive=" + list_drive + "\n" +
                "list_users=" + list_users + "\n" +
                "logged_in='" + logged_in + '\'' + "\n" +
                path + "\n" +
                '}';
    }
}