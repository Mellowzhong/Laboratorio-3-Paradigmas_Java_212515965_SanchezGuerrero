package drive_212515965_SanchezGuerrero;

import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;

import java.util.List;

/**
 * Interface de la clase drive, la cual tiene las funciones a implementar en la misma
 */
public interface drive_interface_212515965_SanchezGuerrero {
    /**
     * Funcion que obtiene la letra del drive
     * @return Retorna la letra del drive
     */
    public String getLetter();
    /**
     * Funcion que obtiene el contenido del drive
     * @return Retorna el contenido del drive
     */
    public List<folder_file_father_212515965_SanchezGuerrero> getContent();
    /**
     * Funcion que permite modificar el nombre del drive
     * @param name Es el nuevo nombre que tendra el drive
     */
    public void setName(String name);
    /**
     * Funcion que permite modificar el contenido del drive
     * @param content Es el nuevo contenido que tendra el drive
     */
    public void setContent(List<folder_file_father_212515965_SanchezGuerrero> content);
}
