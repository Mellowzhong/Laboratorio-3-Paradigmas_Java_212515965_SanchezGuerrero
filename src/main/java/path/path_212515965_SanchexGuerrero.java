package path;

import java.util.List;

public class path_212515965_SanchexGuerrero implements path_interface_212515965_SanchezGuerrero {
    private List<String> current_path;
    private String origin_path;
    private List<String> rest_path;
    public path_212515965_SanchexGuerrero(List<String> path, String origin_path, List<String> rest_path) {
        this.current_path = path;
        this.origin_path = origin_path;
        this.rest_path = rest_path;
    }

    public void setOrigin_path(String origin_path) {
        this.origin_path = origin_path;
    }

    public void setRest_path(List<String> rest_path) {
        this.rest_path = rest_path;
    }

    public String getOrigin_path() {
        return origin_path;
    }

    public List<String> getRest_path() {
        return rest_path;
    }

    public List<String> getCurrent_path() {
        return current_path;
    }

    public void setCurrent_path(List<String> current_path) {
        this.current_path = current_path;
    }

    public int path_size(){return (this.current_path).size();}
    @Override
    public String toString() {
        return "current_path=" + current_path +
                '}';
    }
}
