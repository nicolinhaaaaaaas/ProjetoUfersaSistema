package ProjetoPrototipo.src.MENU;

import java.util.Scanner;

public class Menu {
    

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
