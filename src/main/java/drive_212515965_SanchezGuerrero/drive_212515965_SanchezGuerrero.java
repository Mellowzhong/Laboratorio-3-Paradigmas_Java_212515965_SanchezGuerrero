package drive_212515965_SanchezGuerrero;

import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase drive la cual tendra una letra, nombre, capcidad y almacenara las carpetas y archivos
 */
public class drive_212515965_SanchezGuerrero implements drive_interface_212515965_SanchezGuerrero {
    /**
     * Es la letra del drive
     */
    private String letter;
    /**
     * Es el nombre del drive
     */
    private String name;
    /**
     * Es la capacidad del drive
     */
    private int capacity;
    /**
     * Es el contenido del drive
     */
    private List<folder_file_father_212515965_SanchezGuerrero> content;

    /**
     * Constructor de la clase drive
     * @param letter Es la letra que tendra el drive
     * @param name Es el nombre que tendra el drive
     * @param capacity Es la capacidad que tendra el drive
     */
    public drive_212515965_SanchezGuerrero(String letter, String name, int capacity) {
        this.letter = letter;
        this.name = name;
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }

    /**
     * Funcion que obteiene la letra del drive
     * @return Retorna la letra del drive
     */
    public String getLetter() {
        return letter;
    }

    /**
     * Funcion que obtiene el contenido del drive
     * @return Retorna el contenido del drive
     */
    public List<folder_file_father_212515965_SanchezGuerrero> getContent() {
        return content;
    }

    /**
     * Funcion que permite modificar el nombre del drive
     * @param name Es el nuevo nombre que tendra el drive
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Funcion que permite modificar el contenido del drive
     * @param content Es el nuevo contenido que tendra el drive
     */
    public void setContent(List<folder_file_father_212515965_SanchezGuerrero> content) {
        this.content = content;
    }

    /**
     * Funcion que permite mostrar la informacion de la clase
     * @return Mostrara los atributos del drive
     */
    @Override
    public String toString() {
        return "Drive{" +
                "letter='" + letter + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", content=" + "\n" + content + "\n" +
                '}';
    }
}

