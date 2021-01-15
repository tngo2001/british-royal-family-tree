// CS211 Team Project #01
// Aidan Hert, Conner Bennett, Moammadzain Hassan, Thompson Ngo, Zaw Htun.
// This is the File reader that creates a list of all people from "tudor.dat"
// and family tree from the given list

import java.util.*;
import java.io.*;     

public class FileReader {
    private ArrayList<Person> people;

    public FileReader (File file) throws FileNotFoundException {
        //Initialize fields
        this.people = new ArrayList<>();
        Scanner scanner = new Scanner(file);               
        listOfPeople(scanner);  //Reads the list from first part of file
        familyTree(scanner);    //Second part 
    }
    
    public FileReader() {
        this.people = new ArrayList<>();
    }
    
    public ArrayList<Person> getPeople() {
        return people;
    }
    
    private void listOfPeople(Scanner fileScanner) {
        //Precondition: fileScanner is pointing to the start of the input file
        //Postcondition: fileScanner is pointing to the line after the first occurence of End
        String line = fileScanner.nextLine();
     
        while (!line.equals("END")) {
            Person newPerson = new Person(line);
            this.people.add(newPerson);    
            line = fileScanner.nextLine();
        }
    }

    //private method to avoid being called twice - Zain and Aiden 
    private void familyTree(Scanner scan) {
        //Precondition: scan is pointing to the line after the first occurence of End
        //Postcondition: scan.hasNextLine() returns false
        while (scan.hasNextLine()) {
            String next = scan.nextLine();
            
            if(!next.equals("END")) {
                Person p = getPersonString(next);

                if(scan.hasNextLine()) {
                    Person mother = getPersonString(scan.nextLine());
                    if (mother != null) {
                        p.setMother(mother);       
                        mother.addChild(p);   
                    }
                    if(scan.hasNextLine()) {
                        Person father = getPersonString(scan.nextLine());
                        if (father != null) {
                            p.setFather(father);
                            father.addChild(p);
                        }
                    }
                } 
            }
        }
    }

    //If person of given name is not found null well be returned - Conner
    private Person getPersonString(String name) {
        for (int i=0; i < people.size(); i++) {
            if(people.get(i).toString().equals(name)) {
                return people.get(i);
            }
        }
     return null;
   }
}