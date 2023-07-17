package folder_file_212515965_SanchezGuerrero;

import java.util.List;

/**
 * Interface de folder_file_father que tiene las funciones que implementara la misma
 */
public interface folder_file_interface_212515965_SanchezGuerrero {
    /**
     * Obtiene el nombre del folder_file_father
     * @return Retorna el nombre del folder_file_father
     */
    String getName();

    /**
     * Obtiene el tipo del folder_file_father
     * @return retorna el tipo del folder_file_father
     */
    String getType();

    /**
     * Cambia el nombre del folder_file_father
     * @param name Es el nuevo nombre de folder_file_father
     */
    void setName(String name);

    /**
     * Cambia el tipo del folder_file_father
     * @param type  Es el nuevo tipo de folder_file_father
     */
    void setType(String type);

    /**
     * Comprueba el atributo hide del folder_file_father
     * @return  Retorna el atributo hide de folder_file_father
     */
    boolean isHide();

    /**
     * Comprueba el atributo read del folder_file_father
     * @return  Retorna el atributo read de folder_file_father
     */
    boolean isRead();

    /**
     * Obtiene el contenio del folder_file_father
     * @return Retorna el contenido de folder_file_father
     */
    List<folder_file_father_212515965_SanchezGuerrero> getContent();

}
