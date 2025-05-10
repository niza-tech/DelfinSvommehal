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
3. kontController, pris ud fra Medlemskab. DONE
4. Display kontingent for året. DONE
5. tildele Medlemskab ud fra alder. DONE
if (age >= 18 )
else if (age > 60)
else (age < 18)
6. resultController display, sorter efter bedste i disciplin.
7. Hvordan gemmer vi tider?
8.
9.
 */