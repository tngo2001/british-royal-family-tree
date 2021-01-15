// CS211 Team Project #01
// Aidan Hert, Conner Bennett, Moammadzain Hassan, Thompson Ngo, Zaw Htun.
// This is the person class that creates a new person object and 
// gives them there appropriate family members

import java.util.*;
import java.lang.IllegalArgumentException;

public class Person {

    private String name;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;
   
    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
   
    public Person() {
        this("");
    }
    
    public String toString() {
       return name;
    }
   
    // Getters - Zaw

    public Person getMother() {
       return mother;
    }

    public Person getFather() {
       return father;
    }

    public ArrayList<Person> getChildren() {
       return children;
    }
   
    public String getName() {
       return name;
    }
   
    // Mutators - Zaw
   
    public void setMother(Person newMom) {
       this.mother = newMom;
    }

    public void setFather(Person newDad) {
       this.father = newDad;
    }
   
    public void addChild(Person newChild) {
       if (newChild == null) {
          throw new IllegalArgumentException();
       }
       this.children.add(newChild);
    }
}