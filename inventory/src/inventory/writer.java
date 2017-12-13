package inventory;

 import java.io.*;
import java.util.Scanner;


 class Writer {
     static Scanner input = new Scanner(System.in); 
    


    public static void textWrite(){

        // The name of the file to open.
        String fileName = "inventory.txt";
        String newName;
        int newQuantity = 0;
        int newNum = 0;
        
        System.out.print("Enter new item unique product number: ");    
            newNum = input.nextInt();     
            newNumVerifier.verify(newNum);
            
        System.out.print("Enter new item name: ");    
            newName = input.next();
            
        System.out.print("Enter new quantity: ");    
            newQuantity = input.nextInt();

        try {
            // Assume default encoding.
            FileWriter addToFile = new FileWriter(fileName, true);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(addToFile);

//             Note that write() does not automatically
//             append a newline character.
            bufferedWriter.write("\n" + newNum +" - "+ newName+" - "+ newQuantity);
            

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
    

