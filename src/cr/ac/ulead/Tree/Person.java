package cr.ac.ulead.Tree;

import java.time.LocalDate;

public class Person {
    private String name;
    private String lastName;
    private String id;
    private LocalDate dateOfBirth;
    private Person rigthChild;
    private Person leftChild;

    public Person(String name,String lastName, String id,LocalDate dateOfBirth){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.rigthChild = null;
        this.leftChild = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRigthChild(Person rigthChild){
        this.rigthChild = rigthChild;
    }

    public Person getRigthChild(){
        return rigthChild;
    }

    public void setLeftChild(Person leftChild){
        this.leftChild = leftChild;
    }

    public Person getLeftChild(){
        return leftChild;
    }


}
