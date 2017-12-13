
package inventory;

import java.io.*;
import java.util.Scanner;


public class newNumVerifier {
    
    public static void verify(int newNum) {

        

        try {
            // FileReader reads text files in the default encoding.
            File fn = new File ("inventory.txt");

            Scanner searchFile = new Scanner(fn);
            
            String[] inventoryAry = new String[3];

            while(searchFile.hasNext())  {
                inventoryAry = searchFile.nextLine().split("-");
                String itemNum = (inventoryAry[0]);
                int test = Integer.parseInt(itemNum);
                
                if (newNum == test){
                    System.out.println("Must enter a unique product number ");
                    Writer.textWrite();         
                }else{
                    return;
                }
                
            }   

            // Always close files.
            searchFile.close();
            

        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
    }

    
}
