package Run;

import Controllers.MenuController;
import Controllers.medlemController;
import File.FileHandling;

public class Main {
    public static void main(String[] args) {
        FileHandling.createFile("medlemsListe.txt");
        FileHandling.createFile("traening.txt");
        FileHandling.createFile("staevner.txt");
        medlemController.loadMemberFromFile();
        MenuController menuController = new MenuController();
        menuController.mainMenu();
    }
}


/*TODO
Alt der har med resultatControlleren at gøre.
1. resultController display, sorter efter bedste i disciplin.
2. Hvordan gemmer vi tider, træningsresultater, stævner osv?
 */