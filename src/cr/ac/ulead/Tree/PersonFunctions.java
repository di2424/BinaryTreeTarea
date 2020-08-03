package cr.ac.ulead.Tree;

import java.time.LocalDate;

public class PersonFunctions {

    Person root;

    public void addPerson(String name, String lastName, String id, LocalDate dateOfBirth,Person root){
        Person newPerson = new Person(name,lastName,id,dateOfBirth);
        if(root == null){
            this.root = newPerson;
        }else{
            if( dateOfBirth.isEqual(root.getDateOfBirth()) ){
                if( intConverter(id)>intConverter(root.getId()) ) { //Si el que se va a insertar es mayor que actual
                    if(root.getRigthChild() == null){
                        root.setRigthChild(newPerson);
                    }else{
                        addPerson(name,lastName,id,dateOfBirth,root.getRigthChild());
                    }
                }else{
                    if(root.getLeftChild() == null){
                        root.setLeftChild(newPerson);
                    }else{
                        addPerson(name,lastName,id,dateOfBirth,root.getLeftChild());
                    }
                }
            }else{
                if( intConverter(id)>intConverter(root.getId()) ) {
                    if(root.getRigthChild() == null){
                        root.setRigthChild(newPerson);
                    }else{
                        addPerson(name,lastName,id,dateOfBirth,root.getRigthChild());
                    }
                }else{
                    if(root.getLeftChild() == null){
                        root.setLeftChild(newPerson);
                    }else{
                        addPerson(name,lastName,id,dateOfBirth,root.getLeftChild());
                    }
                }
            }
        }
    }

    public int intConverter(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            System.out.println("Ha ocurrido un error al insertar a el usuario %s");
            return -1;
        }
    }
    public void preOrder(Person root){
        if(root!=null) {
            inOrder(root.getLeftChild());
            inOrder(root.getRigthChild());
            System.out.println("-------------------------------------------------------------");
            System.out.printf("Nombre: %s \nApellidos: %s  \nCedula: %s \nFecha nacimiento: %s%n", root.getName(), root.getLastName(), root.getId(), root.getDateOfBirth());
            System.out.println("-------------------------------------------------------------");

        }
    }

    public void inOrder(Person root){
        if(root!=null) {
            inOrder(root.getLeftChild());
            System.out.println("-------------------------------------------------------------");
            System.out.printf("Nombre: %s \nApellidos: %s  \nCedula: %s \nFecha nacimiento: %s%n", root.getName(), root.getLastName(), root.getId(), root.getDateOfBirth());
            System.out.println("-------------------------------------------------------------");
            inOrder(root.getRigthChild());
        }
    }

    public void postOrder(Person root){
        if(root!=null) {

            System.out.println("-------------------------------------------------------------");
            System.out.printf("Nombre: %s \nApellidos: %s  \nCedula: %s \nFecha nacimiento: %s%n", root.getName(), root.getLastName(), root.getId(), root.getDateOfBirth());
            System.out.println("-------------------------------------------------------------");
            inOrder(root.getLeftChild());
            inOrder(root.getRigthChild());

        }
    }

    public Person getRoot(){
        return root;
    }
}
