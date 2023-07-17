package file_system_212515965_SanchezGuerrero;

import folder_file_212515965_SanchezGuerrero.file_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;

import java.util.List;

public interface filesystem_interface_212515965_SanchezGuerrero {
    /**
     * Funcion que agrega un drive al filesystem
     * @param letter Es la letra que tendra el drive
     * @param name Es el nombre que tendra el drive
     * @param capacity Es la capacidad que tendra el drive
     */
    void add_drive(String letter, String name, int capacity);
    /**
     * Funcion que registra un nuevo usuario en el filesystem
     * @param new_user Es el nuevo usuario que se registrara al filesystem
     */
    void register(String new_user);
    /**
     * Funcion que logea al usuario dado
     * @param user Es el usuario que se "logeara"
     */
    void login(String user);
    /**
     * Funcion que desloguea al ususario actual
     */
    void logout();
    /**
     * Funcion que indicara por que drive nos moveremos en el filesystem
     * @param letter Es la letra por la cual nos queremos mover
     */
    void switch_drive(String letter);
    /**
     * Funcion que agrega una carpeta al directorio actual
     * @param folder_name Es el nombre del folder
     * @param hide Es el atributo hide, corresponde a que si estara oculto o no
     * @param read Es el atributo read, corresponde a que si estara en solo lectura o no
     */
    void make_directory(String folder_name, boolean hide, boolean read);
    /**
     * Funcion que permite cambiar entre directorios
     * @param add_path Es el nuevo directorio por el cual nos vamos a querer mover
     */
    void cd(String add_path);
    /**
     * Funcion que agrega un archivo al directorio actual
     * @param new_file Es el nuevo archivo que se agregara al directorio actual
     */
    void add_file(folder_file_father_212515965_SanchezGuerrero new_file);
    /**
     * Funcion que elimina un archivo o carpeta a travez de su nombre
     * @param del_file Es el nombre del archivo o carpeta que querremos eliminar
     */
    void del(String del_file);
    /**
     * Funcion que copia un archivo a una ruta especifica dado el nombre y la ruta correspondiente
     * @param copy_name Es el nombre del archivo o carpeta que querremos copiar
     * @param target_path Es la ruta a donde se copiara
     */
    void copy (String copy_name, String target_path);
    /**
     * Funcion que mueve un archivo o carpeta a una ruta especifica dado el nombre y la ruta correspondiente
     * @param move_name Es el nombre del archivo o carpeta que se movera
     * @param move_target_path Es la ruta a donde se movera el archivo o carpeta
     */
    void move (String move_name, String move_target_path);
    /**
     * Funcion que renonmbra una carpeta o archivo
     * @param file_folder_name Es la carpeta o archivo que se querra modificar
     * @param new_name Es el nuevo nombre que se dara a la carpeta o archivo modificado
     */
    void ren (String file_folder_name, String new_name);
    /**
     * Funcion que muestra informacion, dependiendo de los parametros dados
     * @param params Es la lista que indicara que cosas mostraremos
     */
    void dir(List<String> params);
    /**
     * Funcion que formatea un drive, dandole un nuevo nombre
     * @param letter Es la letra del drive que queremnos formatear
     * @param name Es el nuevo nombre que le daremos al drive
     */
    void format(String letter, String name);

}
