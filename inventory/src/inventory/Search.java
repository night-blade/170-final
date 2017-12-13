package inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Search {
    static Scanner input = new Scanner(System.in);
    
    public static void invenSearcher() {
        int menuChoice = 0;
        
        System.out.println("\n\n***********Search Menu**********");
        System.out.println("1, Search via keyword");
        System.out.println("2. Search via id number");
        System.out.println("Enter the menu option of your choice");
        menuChoice = input.nextInt();
        
        if (menuChoice == 1){
            Search.textSearch();
        }
        if (menuChoice == 2){
            Search.idSearch();
        }else{
            Search.invenSearcher();
        }
        
        
        
        
    }
    
    
    
    
    
    public static void textSearch() {

        String fileName = "inventory.txt";
        String userSearch = null;
        System.out.println("Enter the menu option of your choice");
        userSearch = input.nextLine();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            Scanner searchFile = new Scanner(fileReader);
            
            String[] inventoryAry = new String[3];

            while(searchFile.hasNext())  {
                inventoryAry = searchFile.nextLine().split("-");
                int itemNum = Integer.parseInt (inventoryAry[0]);
                String itemName = inventoryAry[1];
                int quantity = Integer.parseInt (inventoryAry[2]);
                
                if (userSearch == itemName)
                    System.out.printf("%f %s  %f", itemNum, itemName, quantity);            
                
                
            }   

            // Always close files.
            searchFile.close();
            

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    public static void idSearch() {

        String fileName = "inventory.txt";
        int userSearch = 0;
        System.out.println("Enter the menu option of your choice");
        userSearch = input.nextInt();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            Scanner searchFile = new Scanner(fileReader);
            
            String[] inventoryAry = new String[3];

            while(searchFile.hasNext())  {
                inventoryAry = searchFile.nextLine().split("*");
                int itemNum = Integer.parseInt (inventoryAry[0]);
                String itemName = inventoryAry[1];
                int quantity = Integer.parseInt (inventoryAry[2]);
                
                if (userSearch == itemNum)
                    System.out.printf("%f %s  %f", itemNum, itemName, quantity);            
                
                
            }   

            // Always close files.
            searchFile.close();
            

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        System.out.println("Return to Main Menu?");            
                    String toMain = input.next();
                
                
        if (toMain.charAt(0) == 'y'){
            MainMenu.Menu();
        }else{
            System.exit(0);
        }
    }


        
}


