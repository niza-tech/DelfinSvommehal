package Run;

import Controllers.MenuController;
import Controllers.medlemController;
import File.FileHandling;

public class Main {
    public static void main(String[] args) {
        FileHandling.createFile("medlemsListe.txt");
        MenuController menuController = new MenuController();
        medlemController.loadMemberFromFile();
        menuController.mainMenu();
    }
}


/*TODO
Alt der har med resultatControlleren at gøre.
1. resultController display, sorter efter bedste i disciplin.
2. Hvordan gemmer vi tider, træningsresultater, stævner osv?
 */