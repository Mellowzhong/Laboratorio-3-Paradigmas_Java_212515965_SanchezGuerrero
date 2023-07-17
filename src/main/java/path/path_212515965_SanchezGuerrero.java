package path;

import java.util.List;

public class path_212515965_SanchezGuerrero implements path_interface_212515965_SanchezGuerrero {
    /**
     * Es la ruta general por donde nos moveremos en el filesystem
     */
    private List<String> current_path;
    /**
     * Es el drive por donde nos moveremos
     */
    private String origin_path;
    /**
     * Son los directorios por donde nos moveremos
     */
    private List<String> rest_path;

    /**
     * Constructor de la clase path
     * @param path Es el current_path
     * @param origin_path Es el drive por donde nos moveremos
     * @param rest_path Son los directorios por donde nos moveremos
     */
    public path_212515965_SanchezGuerrero(List<String> path, String origin_path, List<String> rest_path) {
        this.current_path = path;
        this.origin_path = origin_path;
        this.rest_path = rest_path;
    }
    /**
     * Funcion que cambia el drive por el que nos moveremos
     * @param origin_path Es el nuevo drive por el cual nos moveremos
     */
    public void setOrigin_path(String origin_path) {
        this.origin_path = origin_path;
    }
    /**
     * Funcion que cambia los directorios por donde nos moveremos
     * @param rest_path Es los directorios por donde nos moveremoes
     */
    public void setRest_path(List<String> rest_path) {
        this.rest_path = rest_path;
    }
    /**
     * Funcion que obtiene el drive por donde nos movemos
     * @return Retorna el string del drive por donde nos movemos
     */
    public String getOrigin_path() {
        return origin_path;
    }
    /**
     * Funcion que obtiene los directorios por donde nos movemos
     * @return Retorna una lista con los directorios por donde nos movemos
     */
    public List<String> getRest_path() {
        return rest_path;
    }
    /**
     * Funcion que obtiene el current_path
     * @return Retorna al lista del path completo
     */
    public List<String> getCurrent_path() {
        return current_path;
    }
    /**
     * Funcion que modifoca el current_path
     * @param current_path Retorna el current_path modificado
     */
    public void setCurrent_path(List<String> current_path) {
        this.current_path = current_path;
    }
    /**
     * Funcion que obtiene el largo del current_path
     * @return Retorna el largo del current_path
     */
    public int path_size(){return (this.current_path).size();}
    /**
     * Funcion que permite mostrar la informacion de la clase
     * @return Mostrara los atributos del drive
     */
    @Override
    public String toString() {
        return "current_path=" + current_path +
                '}';
    }
}
