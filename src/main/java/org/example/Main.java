package org.example;

import file_system_212515965_SanchezGuerrero.filesystem_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.file_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_212515965_SanchezGuerrero;
import folder_file_212515965_SanchezGuerrero.folder_file_father_212515965_SanchezGuerrero;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Clase Main en la cual se interactua con el usuario
 */
public class Main {
    public static void main(String[] args){

        filesystem_212515965_SanchezGuerrero file_system = new filesystem_212515965_SanchezGuerrero("");

        Scanner input = new Scanner(System.in);
        final int MENU_EXIT_OPTION = 4;

        int choice, security_choice,second_choice;

        do {
            show_menu();
            choice = input.nextInt();


                switch(choice) {
                    case 1:
                        System.out.println("Escriba el nombre del sistema");
                        String system_name = input.next();

                        file_system = new filesystem_212515965_SanchezGuerrero(system_name);
                        break;

                    case 2:
                        if(Objects.equals(file_system.getName_system(), "")){
                            System.out.println("Primero cree un sistema por favor");

                        }
                        else{
                            show_second_menu();
                            second_choice = input.nextInt();

                            switch(second_choice){

                                case 1:
                                    System.out.println("Escriba la letra");
                                    String drive_letter = input.next();

                                    System.out.println("Escriba el nombre");
                                    String drive_name = input.next();

                                    System.out.println("Indique la capacidad");
                                    int drive_capacity = input.nextInt();

                                    file_system.add_drive(drive_letter.toUpperCase() , drive_name, drive_capacity);
                                    break;

                                case 2:
                                    System.out.println("Escriba el nombre del usuario");
                                    String user_name = input.next();

                                    file_system.register(user_name);
                                    break;

                                case 3:
                                    System.out.println("Escriba el nombre del usuario");
                                    String user = input.next();

                                    file_system.login(user);
                                    break;

                                case 4:
                                    file_system.logout();
                                    break;

                                case 5:
                                    System.out.println("Escriba la letra");
                                    String letter = input.next();

                                    file_system.switch_drive(letter);
                                    break;

                                case 6:
                                    System.out.println("Escriba el nombre de la carpeta");
                                    String folder_name = input.next();
                                    System.out.println("Desea agregar atributos de seguridad?\n1.Si\n2.No\nIngrese la opcion:");
                                    security_choice = input.nextInt();
                                    if(security_choice == 1){
                                        System.out.println("Escriba true o false si desea agregar el atributo");
                                        System.out.println("Oculto");
                                        boolean hide = input.nextBoolean();
                                        System.out.println("Solo lectura");
                                        boolean read = input.nextBoolean();
                                        file_system.make_directory(folder_name, hide, read);
                                    }
                                    else{
                                        file_system.make_directory(folder_name, false, false);
                                    }

                                    break;

                                case 7:
                                    System.out.println("Escriba el directorio al que desea cambiar");
                                    String add_path = input.next();
                                    file_system.cd(add_path);

                                    break;

                                case 8:
                                    System.out.println("Escriba el archivo (name.extension)");
                                    String file_name = input.next();
                                    System.out.println("Escriba el contenido");
                                    input.nextLine();
                                    String file_content = input.nextLine();

                                    System.out.println("Desea agregar atributos de seguridad?\n1.Si\n2.No\nIngrese la opcion");
                                    security_choice = input.nextInt();

                                    if(security_choice == 1){
                                        System.out.println("Escriba true o false si desea agregar el atributo");

                                        System.out.println("Oculto");
                                        boolean hide = input.nextBoolean();

                                        System.out.println("Solo lectura");
                                        boolean read = input.nextBoolean();

                                        List<String> name_type_file = List.of(file_name.split("\\."));

                                        folder_file_father_212515965_SanchezGuerrero new_file = new file_212515965_SanchezGuerrero(name_type_file.get(0), name_type_file.get(1), file_content, file_system.getLogged_in(), hide, read);

                                        file_system.add_file(new_file);
                                    }
                                    else{
                                        List<String> name_type_file = List.of(file_name.split("\\."));
                                        folder_file_father_212515965_SanchezGuerrero new_file = new file_212515965_SanchezGuerrero(name_type_file.get(0), name_type_file.get(1), file_content, file_system.getLogged_in(), false, false);

                                        file_system.add_file(new_file);
                                    }
                                    break;

                                case 9:
                                    System.out.println("Escriba el nombre del archivo (name.extension) o carpeta que desea borrar ");
                                    String del_file = input.next();

                                    file_system.del(del_file);
                                    break;

                                case 10:
                                    System.out.println("Escriba el nombre del archivo o carpeta que desea copiar");
                                    String copy_name = input.next();
                                    System.out.println("Escriba la ruta a la que desea copiar el archivo o carpeta");
                                    String target_path = input.next();

                                    file_system.copy(copy_name, target_path);
                                    break;

                                case 11:
                                    System.out.println("Escriba el nombre del archivo o carpeta que desea mover");
                                    String move_name = input.next();
                                    System.out.println("Escriba la ruta a la que desea mover el archivo o carpeta");
                                    String move_target_path = input.next();

                                    file_system.move(move_name, move_target_path);
                                    break;

                                case 12:
                                    System.out.println("Escriba el archivo (name.extension) o carpeta");
                                    String file_folder_name = input.next();
                                    System.out.println("Escriba el nuevo nombre");
                                    String new_name = input.next();

                                    file_system.ren(file_folder_name, new_name);
                                    break;

                                case 13:
                                    System.out.println("Escriba las instrucciones que desee separas por un ; (arg1;arg2;...)");
                                    input.nextLine();
                                    String arguments = input.nextLine();
                                    List<String> parameters = List.of(arguments.split(";"));

                                    file_system.dir(parameters);
                                    break;

                                case 14:
                                    System.out.println("Escriba la letra de la unidad");
                                    String format_letter = input.next();
                                    System.out.println("Escriba el nuevo nombre");
                                    String format_name = input.next();

                                    file_system.format(format_letter, format_name);
                                    break;

                                default:
                                    System.out.println(choice + " no es una opcion valida, por favor seleccionar una opcion valida.");

                            }
                        }
                        break;

                    case 3:
                        if(Objects.equals(file_system.getName_system(), "")){
                            System.out.println("No hay sistema, primero cree uno por favor");

                        }else{
                            System.out.println(file_system);
                        }
                        break;

                    case 4:

                        System.out.println("Adios..");
                        System.exit(0);
                        break;

                    default:
                        System.out.println(choice + " no es una opcion valida, por favor seleccionar una opcion valida.");

                }
            } while (choice != MENU_EXIT_OPTION);
    }

    private static void show_menu() {
        System.out.println("\nMenu principal\n");
        System.out.print("1. Crear un sistema \n");
        System.out.print("2. Modificar el sistema.\n");
        System.out.print("3. Mirar el estado del sistema.\n");
        System.out.print("4. Salir\n");
        System.out.print("\nIngrese su opcion: ");
    }

    private static void show_second_menu() {
        System.out.println("Menu de modificacion del sistema\n");
        System.out.print("1. Add drive \n");
        System.out.print("2. Register\n");
        System.out.print("3. Login\n");
        System.out.print("4. Logout\n");
        System.out.print("5. Switch drive\n");
        System.out.print("6. Mkdir\n");
        System.out.print("7. Cd\n");
        System.out.print("8. Add file\n");
        System.out.print("9. Del\n");
        System.out.print("10. Copy\n");
        System.out.print("11. Move\n");
        System.out.print("12. Ren\n");
        System.out.print("13. Dir\n");
        System.out.print("14. Format\n");
        System.out.print("\nIngrese su opcion: ");
    }
    //POner el rut y nombre en las clases
}