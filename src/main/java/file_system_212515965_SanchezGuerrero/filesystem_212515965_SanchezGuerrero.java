package file_system_212515965_SanchezGuerrero;

import drive_212515965_SanchezGuerrero.drive_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;
import path.path_212515965_SanchezGuerrero;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * Clase filesystem la cual tendra un nombre, fecha, lista de drives, lista de usuarios, el usuario logeado, el path y
 * la papelera de reciclaje
 */
public class filesystem_212515965_SanchezGuerrero implements filesystem_interface_212515965_SanchezGuerrero {
    /**
     * Es el nombre del filesystem
     */
    private String name_system;
    /**
     * Es la fecha de creacion del filesystem
     */
    private Date date_now;
    /**
     * Es la lista de drives que almacena filesystem
     */
    private List<drive_212515965_SanchezGuerrero> list_drive;
    /**
     * Es la lista de ususarios registrados en el filesystem
     */
    private List<String> list_users;
    /**
     * Es el usuario que esta "logeado" en el filesystem
     */
    private String logged_in;
    /**
     * Es la ruta por la cual recorreremos filesystem
     */
    private path_212515965_SanchezGuerrero path;
    /**
     * Es donde se alcanera los archivos borrados
     */
    private List<folder_file_father_212515965_SanchezGuerrero> recicle_bin;

    /**
     * Canstructor de la clase filesystem
     * @param name_system Sera el nombre del filesystem
     */
    public filesystem_212515965_SanchezGuerrero(String name_system) {
        this.name_system = name_system;
        this.date_now = new Date();
        this.list_drive = new ArrayList<>();
        this.list_users= new ArrayList<>();
        this.logged_in = "";
        this.path = new path_212515965_SanchezGuerrero(new ArrayList<>(), "", new ArrayList<>());
        this.recicle_bin = new ArrayList<>();
    }

    /**
     * Funcion que agrega un drive al filesystem
     * @param letter Es la letra que tendra el drive
     * @param name Es el nombre que tendra el drive
     * @param capacity Es la capacidad que tendra el drive
     */
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

    /**
     * Funcion que registra un nuevo usuario en el filesystem
     * @param new_user Es el nuevo usuario que se registrara al filesystem
     */
   public void register(String new_user){
        if(!list_users.contains(new_user)){
            list_users.add(new_user);
        }
        else{
            System.out.println("Este usuario ya existe, pruebe con otro nombre");
        }

   }

    /**
     * Funcion que logea al usuario dado
     * @param user Es el usuario que se "logeara"
     */
   public void login(String user){
        if(list_users.contains(user)){
            this.logged_in = user;
        }
        else{
            System.out.println("Este usuario no existe");
        }
   }
    /**
     * Funcion que desloguea al ususario actual
     */
   public void logout(){
        this.logged_in = "";
   }
    /**
     * Funcion que indicara por que drive nos moveremos en el filesystem
     * @param letter Es la letra por la cual nos queremos mover
     */
   public void switch_drive(String letter){
       List<String> list_letter_drives = new ArrayList<>();
       for(drive_212515965_SanchezGuerrero drive : list_drive) {
           list_letter_drives.add(drive.getLetter());
       }

       if(list_letter_drives.contains(letter.toUpperCase())) {
           if(someone_login()){
               List<String> new_path = new ArrayList<>();
               new_path.add(letter.toUpperCase());
               path.setCurrent_path(new_path);
               path.setOrigin_path(letter.toUpperCase());
           }
           else{
               System.out.println("No hay un usuario logeado");
           }
       }
       else{
           System.out.println("Este drive no existe, pruebe con otro drive");
       }
   }

    /**
     * Funcion que agrega una carpeta al directorio actual
     * @param folder_name Es el nombre del folder
     * @param hide Es el atributo hide, corresponde a que si estara oculto o no
     * @param read Es el atributo read, corresponde a que si estara en solo lectura o no
     */
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

    /**
     * Funcion que permite cambiar entre directorios
     * @param add_path Es el nuevo directorio por el cual nos vamos a querer mover
     */
   public void cd(String add_path) {
       List<String> list_path = List.of(add_path.split("/"));
       if (someone_login() && path.path_size() > 0) {
           if(list_path.isEmpty()){
               (path.getCurrent_path()).subList(1, path.path_size()).clear();
               path.setRest_path(new ArrayList<>());
           }
           for(String action_path : list_path){
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

    /**
     * Funcion que agrega un archivo al directorio actual
     * @param new_file Es el nuevo archivo que se agregara al directorio actual
     */
    public void add_file(folder_file_father_212515965_SanchezGuerrero new_file){
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        if(path.path_size() > 0){

            if (!path_exist(new_file.getName())){
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

    /**
     * Funcion que elimina un archivo o carpeta a travez de su nombre
     * @param del_file Es el nombre del archivo o carpeta que querremos eliminar
     */
    public void del(String del_file){
        List<String> name_type = List.of(del_file.split("\\."));
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());

        if (name_type.size() < 2) {
            for(folder_file_father_212515965_SanchezGuerrero folder_file : content){
                if((folder_file.getName()).equals(name_type.get(0))){
                    recicle_bin.add(folder_file);
                }
            }
            content.removeIf(folder_file -> (folder_file.getName()).equals(name_type.get(0)));

        }else{

            for(folder_file_father_212515965_SanchezGuerrero folder_file : content){
                if((folder_file.getName()).equals(name_type.get(0))){
                    recicle_bin.add(folder_file);
                }
            }
            content.removeIf(file_folder -> ((file_folder.getName()).equals(name_type.get(0))) && ((file_folder.getType()).equals(name_type.get(1))));
        }
    }

    /**
     * Funcion que copia un archivo a una ruta especifica dado el nombre y la ruta correspondiente
     * @param copy_name Es el nombre del archivo o carpeta que querremos copiar
     * @param target_path Es la ruta a donde se copiara
     */
    public void copy (String copy_name, String target_path){
        List<String> new_path = List.of(target_path.split("/"));
        folder_file_father_212515965_SanchezGuerrero copy = new folder_file_father_212515965_SanchezGuerrero("", "", false, false);
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());

        String new_origin_path = (new_path.get(0)).toUpperCase();
        List<String> new_rest_path = new_path.subList(1, new_path.size());

        for(folder_file_father_212515965_SanchezGuerrero file_folder : content){
            if(file_folder.getName().equals(copy_name)){
                copy = file_folder;
            }
        }

        if(copy.getName().equals("")){
            System.out.println("Ese archivo o carpeta no se encuentra en el directorio actual");

        }else{
            List<folder_file_father_212515965_SanchezGuerrero> new_content = find_content(new_origin_path, new_rest_path);

            new_content.add(copy);
        }
    }

    /**
     * Funcion que mueve un archivo o carpeta a una ruta especifica dado el nombre y la ruta correspondiente
     * @param move_name Es el nombre del archivo o carpeta que se movera
     * @param move_target_path Es la ruta a donde se movera el archivo o carpeta
     */
    public void move (String move_name, String move_target_path){
        List<String> move_new_path = List.of(move_target_path.split("/"));
        folder_file_father_212515965_SanchezGuerrero copy = new folder_file_father_212515965_SanchezGuerrero("", "", false, false);
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());

        String new_origin_path = (move_new_path.get(0)).toUpperCase();
        List<String> new_rest_path = move_new_path.subList(1, move_new_path.size());

        for(folder_file_father_212515965_SanchezGuerrero file_folder : content){
            if(file_folder.getName().equals(move_name)){
                copy = file_folder;
            }
        }
        content.remove(copy);

        if(copy.getName().equals("")){
            System.out.println("Ese archivo o carpeta no se encuentra en el directorio actual");

        }else{
            List<folder_file_father_212515965_SanchezGuerrero> new_content = find_content(new_origin_path, new_rest_path);

            new_content.add(copy);
        }
    }

    /**
     * Funcion que renonmbra una carpeta o archivo
     * @param file_folder_name Es la carpeta o archivo que se querra modificar
     * @param new_name Es el nuevo nombre que se dara a la carpeta o archivo modificado
     */
    public void ren (String file_folder_name, String new_name){ // agregar que cambie la fecha de ultima modificacion
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> name_type = List.of(new_name.split("\\."));

        for (folder_file_father_212515965_SanchezGuerrero file_folder : content) {
            if (file_folder.getName().equals(file_folder_name) && name_type.size() > 2 && !file_folder.isRead()) {
                file_folder.setName(name_type.get(0));
                file_folder.setType(name_type.get(1));
            }
            if (file_folder.getName().equals(file_folder_name) && !file_folder.isRead()) {
                file_folder.setName(name_type.get(0));
            }
            else{
                System.out.println("Esta carpeta o archivo esta con el atributo de sguridad de solo lectura, no se puede modioficar");
            }
        }
    }

    /**
     * Funcion que muestra informacion, dependiendo de los parametros dados
     * @param params Es la lista que indicara que cosas mostraremos
     */
    public void dir(List<String> params){
        List<folder_file_father_212515965_SanchezGuerrero> actual_directory = get_actual_directory(this.path.getOrigin_path(), this.path.getRest_path());
        if(params.isEmpty()){
            for(folder_file_father_212515965_SanchezGuerrero folders : actual_directory){
                System.out.println("Name:" + folders.getName());
            }
        }else {
            for (String element : params) {

                if (element.equals("/s")) {
                    for(folder_file_father_212515965_SanchezGuerrero folders : actual_directory){
                        System.out.println("Name:" + folders.getName() + " Content:" + folders.getContent());
                    }
                }

                if (Objects.equals(element, "/?")) {
                    System.out.println("Se pueden usar los parametros:");
                    System.out.println("; : sirve para mostrar el directorio actual");
                    System.out.println("/s: sirve para mostrar el directorio actual y todos los subdirectorios");
                }
            }
        }
    }

    /**
     * Funcion que formatea un drive, dandole un nuevo nombre
     * @param letter Es la letra del drive que queremnos formatear
     * @param name Es el nuevo nombre que le daremos al drive
     */
    public void format(String letter, String name){
        for(drive_212515965_SanchezGuerrero drives : list_drive){
            if(Objects.equals(drives.getLetter(), letter.toUpperCase())){
                drives.setName(name);
                drives.setContent(new ArrayList<>());
            }
        }
    }

    /**
     * Funcion que obtiene el nombre del sistema
     * @return Retorna el nombre del sistema
     */
    public String getName_system() {
        return name_system;
    }

    /**
     * Funcion que obtiene al usuario logeado
     * @return Retorna al usuario "logeado"
     */
    public String getLogged_in() {
        return logged_in;
    }

    /**
     * Funcion que verifica si alguien esta "logeado"
     * @return Retorna true o false
     */
    public boolean someone_login (){
        return !Objects.equals(this.logged_in, "");
    }

    /**
     * Funcion que encuentra el contenido dado un path
     * @param origin_path Es el drive por el que nos moveremos
     * @param rest_path Son los directorios por donde nos moveremos
     * @return Retorna una lista con el contenido del directorio
     */
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

    /**
     * Funcion que obtiene el directorio actual teniendo en cuentra los atributos de seguridad
     * @param origin_path Es el drive por el que nos moveremos
     * @param rest_path Son los directorios por donde nos moveremos
     * @return Retorna una lista con el contenido del directorio, pero solo teniendo en cuenta si el atributo hide es false
     */
    public List<folder_file_father_212515965_SanchezGuerrero> get_actual_directory(String origin_path, List<String> rest_path){
        List<folder_file_father_212515965_SanchezGuerrero> file_folder_names = new ArrayList<>();
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(origin_path, rest_path);

        for(folder_file_father_212515965_SanchezGuerrero folder_file : content){
            if(!folder_file.isHide()){
                file_folder_names.add(folder_file);
            }
        }
        return file_folder_names;
    }

    /**
     * Funcion que verifica si el directorio dado existe en el directorio actual
     * @param add_path Es el nombre del directorio que verificaremos
     * @return Retorna true o false
     */
    public boolean path_exist(String add_path){
        List<folder_file_father_212515965_SanchezGuerrero> content = find_content(this.path.getOrigin_path(), this.path.getRest_path());
        List<String> names = new ArrayList<>();

        for(folder_file_father_212515965_SanchezGuerrero elements : content){
            names.add(elements.getName());
        }

        return names.contains(add_path);
    }

    /**
     * Funcion que permite mostrar la informacion de la clase
     * @return Mostrara los atributos del drive
     */
    @Override
    public String toString() {
        return "name_system='" + name_system + '\'' + "\n" +
                "creation_date=" + date_now + "\n" +
                "list_drive=" + list_drive + "\n" +
                "list_users=" + list_users + "\n" +
                "logged_in=" + logged_in + '\'' + "\n" +
                path + "\n" +
                "recible bin=" + recicle_bin + "\n" +
                '}';
    }
}