package folder_file_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.List;

/**
 * Es la clase padre llamada folder_file_father, este clase se heredera a las clases folder y file
 */
public class folder_file_father_212515965_SanchezGuerrero implements folder_file_interface_212515965_SanchezGuerrero {
    /**
     * Es el nombre de folder_file_father
     */
    public String name;
    /**
     * Es el tipo de folder_file_father
     */
    public String type;
    /**
     * Es el contenido de folder_file_father
     */
    public List<folder_file_father_212515965_SanchezGuerrero> content;
    /**
     * Es el atributo de seguridad de solo lectura de folder_file_father
     */
    public boolean read;
    /**
     * Es el atributo de seguridad de oculto de folder_file_father
     */
    public boolean hide;

    /**
     * Constructor de la clase folder_file_father
     * @param name Es el nombre que tendra folder_file_father
     * @param type Es el tipo que tendra folder_file_father
     * @param hide Es el atributo hide que tendra folder_file_father
     * @param read Es el atributo read que tendra folder_file_father
     */
    public folder_file_father_212515965_SanchezGuerrero(String name, String type, boolean hide, boolean read) {
        this.name = name;
        this.type = type;
        this.content = new ArrayList<>();
        this.read = read;
        this.hide = hide;
    }
    /**
     * Obtiene el nombre del folder_file_father
     * @return Retorna el nombre del folder_file_father
     */
    public String getName() {
        return name;
    }
    /**
     * Obtiene el tipo del folder_file_father
     * @return retorna el tipo del folder_file_father
     */
    public String getType() {
        return type;
    }
    /**
     * Cambia el nombre del folder_file_father
     * @param name Es el nuevo nombre de folder_file_father
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Cambia el tipo del folder_file_father
     * @param type  Es el nuevo tipo de folder_file_father
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Comprueba el atributo read del folder_file_father
     * @return  Retorna el atributo read de folder_file_father
     */
    public boolean isRead() {
        return read;
    }
    /**
     * Comprueba el atributo hide del folder_file_father
     * @return  Retorna el atributo hide de folder_file_father
     */
    public boolean isHide() {
        return hide;
    }
    public List<folder_file_father_212515965_SanchezGuerrero> getContent() {
        return content;
    }
}
