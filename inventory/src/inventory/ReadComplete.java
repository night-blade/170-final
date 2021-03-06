
package inventory;
import java.io.*;
import java.util.Scanner;

public class ReadComplete {
    static Scanner input = new Scanner(System.in); 


    public static void textReader() {
        
        // The name of the file to open.
        String fileName = "inventory.txt";

        
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
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
    
 
    



