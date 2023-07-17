package folder_file_212515965_SanchezGuerrero;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase folder la cual hereda a folder_file_father, obteniendo sus metodos y sus atributos correspondientes
 */
public class folder_212515965_SanchezGuerrero extends folder_file_father_212515965_SanchezGuerrero {
    /**
     * Es la fecha de creacion del folder
     */
    private Date creation_date = new Date();
    /**
     * Es la fecha de ultima modificacion del folder
     */
    private Date last_modification = new Date();
    /**
     * Es el ususario que creo la carpeta
     */
    private String creation_user;

    /**
     * Constructor de la clase folder
     * @param name Es el nombre que tendra el folder
     * @param type Es el tipo que tendra folder
     * @param login_user Es el ususario que creo el folder
     * @param hide Es el atributo de seguridad hide dado
     * @param read ES el atributo de seguridad read dado
     */
    public folder_212515965_SanchezGuerrero(String name, String type, String login_user, boolean hide, boolean read) {
        super(name, type, hide, read);
        this.creation_user = login_user;
    }

    /**
     * Funcion que permite mostrar la informacion de la clase
     * @return Mostrara los atributos del drive
     */
    @Override
    public String toString() {
        return  "name='" + name + '\'' + "\n" +
                ", content=" + content + "\n" +
                ", creation user=" + creation_user + "\n" +
                ", creation_date=" + creation_date + "\n" +
                ", last_modification=" + last_modification + "\n" +
                ", read=" + read + "\n" +
                ", hide=" + hide + "\n" +
                '}';
    }
}
