package folder_file_212515965_SanchezGuerrero;

import java.util.Date;
/**
 * Clase file la cual hereda a folder_file_father, obteniendo sus metodos y sus atributos correspondientes
 */
public class file_212515965_SanchezGuerrero extends folder_file_father_212515965_SanchezGuerrero {
    /**
     * Es el contenido de file
     */
    private String content;
    /**
     * Es la fecha de creacion de file
     */
    private Date creation_date = new Date();
    /**
     * Es la ultima modificacion de file
     */
    private Date last_modification = new Date();
    /**
     * Es el usuario que creo file
     */
    private String creation_user;
    public file_212515965_SanchezGuerrero(String name, String type, String content, String login_user, boolean hide, boolean read) {
        super(name, type, hide, read);
        this.content = content;
        this.creation_user = login_user;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' + "\n" +
                ", type='" + type + '\'' + "\n" +
                ", content=" + content + "\n" +
                ", creation_date=" + creation_date + "\n" +
                ", creation_user=" + creation_user + "\n" +
                ", last_modification=" + last_modification + "\n" +
                ", read=" + read + "\n" +
                ", hide=" + hide + "\n" +
                '}';
    }
}
