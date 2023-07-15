package file_system_212515965_SanchezGuerrero;

import java.util.List;

public interface filesystem_interface_212515965_SanchezGuerrero {
    void add_drive(String letter, String name, int capacity);
    void register(String new_user);
    void login(String user);
    void logout();
    void switch_drive(String letter);
    void make_directory(String folder_name, boolean hide, boolean read);
    void cd(List<String> add_path);
    void add_file(String file_name, String file_content, boolean hide, boolean read);
    void del(String del_element);
}
