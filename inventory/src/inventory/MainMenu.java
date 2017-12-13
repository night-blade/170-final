
package inventory;

import java.util.Scanner;




public class MainMenu {
    static Scanner input = new Scanner(System.in); 
    
    public static void Menu() {
        int menuChoice = 0;
    
    
        System.out.println("\n\n***********Main Menu**********");
        System.out.println("1, View complete inventory");
        System.out.println("2. Add to inventory");
        System.out.println("3. Search inventory");
        System.out.println("4. Update quantity");
        System.out.println("Enter the menu option of your choice");
        menuChoice = input.nextInt();
        
        if (menuChoice == 1){
            ReadComplete.textReader();
        }
        if (menuChoice == 2){
            Writer.textWrite();
        }
        if (menuChoice == 3){
            Search.invenSearcher();
        }
        if (menuChoice == 4){
            Editor.invenEditor();
        }else{
            System.exit(0);
        }
        
        
        
    }    
}
