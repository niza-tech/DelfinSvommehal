package Run;

import Controllers.menuController;
import File.FileHandling;

public class Main {
    public static void main(String[] args) {
        FileHandling.createFile("medlemsListe.txt");
        menuController.mainMenu();
    }
}
