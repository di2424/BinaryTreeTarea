package cr.ac.ulead.Data;

import cr.ac.ulead.Tree.Person;
import cr.ac.ulead.Tree.PersonFunctions;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Files {

    ArrayList<Person> personList = new ArrayList<>();

    public boolean loadData(PersonFunctions personFunctions) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("PersonDataBase.csv"));
            String line = bufferedReader.readLine();
            while (line!=null) {
                String[] fields = line.split(",");
                System.out.println(Arrays.toString(fields));
                personFunctions.addPerson(fields[0] , fields[1],fields[2], LocalDate.parse(fields[3]),personFunctions.getRoot() );
                line = bufferedReader.readLine();

            }
            bufferedReader.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

   public void saveData(Person person){
        convertData(person);
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("PersonDataBase.csv"));
            for(Person data : personList){
                bufferedWriter.write(String.format("%s,%s,%s,%s",data.getName(),data.getLastName(),data.getId(),data.getDateOfBirth()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){

        }
    }



    public void convertData(Person root){
        if( root!= null ) {
            convertData(root.getLeftChild());
            Person newPerson = new Person(root.getName(),root.getLastName(),root.getId(),root.getDateOfBirth());
            personList.add(newPerson);
            convertData(root.getRigthChild());
        }
    }

}
