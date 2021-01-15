// CS211 Team Project #01
// Aidan Hert, Conner Bennett, Moammadzain Hassan, Thompson Ngo, Zaw Htun.
// This the main class that prompts the user for a name of the "tudor.dat"
// file and returns the appropriate output

import java.io.*;
import java.util.*;

public class Main {	
   public static void main (String[] args) throws FileNotFoundException {
       	
      File file = new File ("tudor.dat");
      FileReader fr = new FileReader(file);
   
      ArrayList<Person> familyTree = fr.getPeople();
       
   	// While Loop repeats Search menu 
   	// Prompts user to enter name to search, or "quit" to exit - Thompson
      boolean flag = false;
   	
      while(!flag) {
         Scanner console = new Scanner(System.in);
         System.out.println("Type person's name to search, or \"quit\" to exit");
         String choice = console.nextLine();
           
         if(!choice.toLowerCase().equals("quit")) {
            if(familyTree.toString().contains(choice)) {
               for (int i = 0; i < familyTree.size(); i++) {
                  if(familyTree.get(i).toString().equals(choice)) {
                     System.out.println("Maternal Line:");
                     System.out.println("\t" + familyTree.get(i));
                     System.out.println("\t\t" + familyTree.get(i).getMother());
                     System.out.println("Paternal Line:");
                     System.out.println("\t" + familyTree.get(i));
                     System.out.println("\t\t" + familyTree.get(i).getFather());
                     System.out.println("Children:");
                     System.out.println(familyTree.get(i).getChildren().toString().replace("[","").replace("]", ""));
                     System.out.println("-------------------------------");
                  }	
               } 
               
            //If no correct matches
            }else {
               System.out.println("No records found, please try again.");	
            }
         	
         // "quit" exits search
         } else if(choice.toLowerCase().equals("quit")) {
            System.out.println("Search ended.");
            flag = true;
         }
      }
   }
}