package cr.ac.ulead.UI;

import cr.ac.ulead.Data.Files;
import cr.ac.ulead.Tree.Person;
import cr.ac.ulead.Tree.PersonFunctions;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {

    public void menu(){
        PersonFunctions personFunctions = new PersonFunctions();
        Files files = new Files();

        while (true){
            System.out.println( "-----------------------------------\n" +
                                "---Sistema de arboles de personas---" +
                                "\n---------------------------------\nOpciones" +
                                "\n-> 1.Insertar una persona" +
                                "\n-> 2.Cargar el CSV" +
                                "\n-> 3.Pre orden" +
                                "\n-> 4.En orden" +
                                "\n-> 5.Post orden" +
                                "\n-> 6.Datos para prueba" +
                                "\n-> 0.Salir");
            int option = getOption();
            if(option==1){
                personForm(personFunctions);
                files.saveData(personFunctions.getRoot());
            }
            else if(option == 2){
                files.loadData(personFunctions);
            }
            else if(option == 3){
                System.out.println("Pre orden\n");
                personFunctions.preOrder(personFunctions.getRoot());
            }
            else if(option == 4){
                System.out.println("En orden\n");
                personFunctions.inOrder(personFunctions.getRoot());
            }
            else if(option == 5){
                System.out.println("Post orden\n");
                personFunctions.postOrder(personFunctions.getRoot());
            }
            else if(option == 6){
                personFunctions.addPerson("Juan","Rojas","203330999",LocalDate.parse("2019-03-30"),personFunctions.getRoot());
                personFunctions.addPerson("Pedro","Lopez","106550899",LocalDate.parse("2000-05-15"),personFunctions.getRoot());
                personFunctions.addPerson("Maria","Perez","506990312",LocalDate.parse("1998-01-23"),personFunctions.getRoot());
                personFunctions.addPerson("Karla","Morera","301450698",LocalDate.parse("1987-03-04"),personFunctions.getRoot());
            }
            else {
                files.saveData(personFunctions.getRoot());
                break;
            }



        }
    }

    public int getOption(){
        Scanner input = new Scanner(System.in);
        try{
            return input.nextInt();
        }catch (NumberFormatException e){
            System.out.println("Error en el mecanismo de entrada, por favor verifique su eleccion.");
            return -1;
        }
    }

    public void personForm(PersonFunctions personFunctions){
        Scanner input = new Scanner(System.in);
        System.out.print("\nIngrese el nombre de la persona:\n ");
        String name = input.next();
        System.out.println("\nIngrese los apellidos de la persona: ");
        String lastName = input.next();
        System.out.println("\nIngrese la cedula de la persona: ");
        String id = input.next(".0...0...");
        System.out.println("\nIngrese la fecha de nacimiento formato (AAAA-MM-DD) : ");
        LocalDate date = LocalDate.parse(input.next("....-..-.."));
        personFunctions.addPerson(name,lastName,id,date,personFunctions.getRoot());
    }

}
