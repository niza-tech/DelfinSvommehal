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
1. medlemController, aktiv/passiv når du bliver registreret eller som man kan redigerer. DONE
2. medlemController, Svømmedisciplin når du bliver registreret og når du skal redigerer. DONE
3. kontController, pris ud fra Medlemskab.
4. tildele Medlemskab ud fra alder.
if (age >= 18 )
else if (age > 60)
else (age < 18)
5. resultController display, sorter efter bedste i disciplin.
6. Hvordan gemmer vi tider?
7.
8.
 */