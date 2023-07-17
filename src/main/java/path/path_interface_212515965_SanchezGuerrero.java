package path;

import java.util.List;

/**
 * Interface de la clase path que tiene los metodos a aplicar en la misma
 */
public interface path_interface_212515965_SanchezGuerrero {
    /**
     * Funcion que cambia el drive por el que nos moveremos
     * @param origin_path Es el nuevo drive por el cual nos moveremos
     */
    public void setOrigin_path(String origin_path);

    /**
     * Funcion que cambia los directorios por donde nos moveremos
     * @param rest_path Es los directorios por donde nos moveremoes
     */
    public void setRest_path(List<String> rest_path);

    /**
     * Funcion que obtiene el drive por donde nos movemos
     * @return Retorna el string del drive por donde nos movemos
     */
    public String getOrigin_path();

    /**
     * Funcion que obtiene los directorios por donde nos movemos
     * @return Retorna una lista con los directorios por donde nos movemos
     */
    public List<String> getRest_path();

    /**
     * Funcion que obtiene el current_path
     * @return Retorna al lista del path completo
     */
    public List<String> getCurrent_path();

    /**
     * Funcion que modifoca el current_path
     * @param current_path Retorna el current_path modificado
     */
    public void setCurrent_path(List<String> current_path);

    /**
     * Funcion que obtiene el largo del current_path
     * @return Retorna el largo del current_path
     */
    public int path_size();
}
