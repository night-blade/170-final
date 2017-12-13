
package inventory;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Editor {
    static Scanner input = new Scanner(System.in);  
    
        public static void invenEditor() {

        String fileName = "inventory.txt";
        int itemSearch = 0;
        String confirm;
        int newInven = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            Scanner searchFile = new Scanner(fileReader);
            
            String[] inventoryAry = new String[3];
            
            System.out.println("Enter item nember of the inventory item that you want to change the amount of inventory of: ");            
            itemSearch = input.nextInt();

            while(searchFile.hasNext())  {
                inventoryAry = searchFile.nextLine().split("-");
                int itemNum = Integer.parseInt (inventoryAry[0]);
                String itemName = inventoryAry[1];
                int quantity = Integer.parseInt (inventoryAry[2]);
                
                if (itemSearch == itemNum){
                    System.out.printf("Is this the item? enter y/n: %d %s  %d", itemNum, itemName, quantity);            
                    confirm = input.next();
                
                
                    if (confirm.charAt(0) == 'y'){
                        System.out.println("Enter new inventory: ");    
                        newInven = input.nextInt();



                    }
                }
                Editor.invenUpdate(itemNum, itemName, newInven);
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
    public static void invenUpdate(int itemNum, String itemName, int newInven){

        // The name of the file to open.
        String fileName = "inventory.txt";

        try {
            // Assume default encoding.
            FileWriter addToFile = new FileWriter(fileName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(addToFile);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(itemNum +"*"+ itemName+"*"+ newInven + "\n");
            

            // Always close files.
            bufferedWriter.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
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
