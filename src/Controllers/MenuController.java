package Controllers;

import java.util.Scanner;

public class MenuController {
    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean y = true;

        while (y) {
            System.out.println("Delfinen Svømmeklub");
            System.out.println(mainMenuTekst());

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    medlemMenu();
                    break;
                case 2:
                    kontingentMenu();
                    break;
                case 3:
                    statistikMenu();
                    break;
                case 4:
                    y = false;
                    break;
            }
        }
    }

    public static String mainMenuTekst() {
        return "\nMain Menu:" + "\n" +
                """
                        1. Medlemmer
                        2. Kontingent
                        3. Vis resultater
                        4. Afslut program
                        """;
    }

    public void medlemMenu() {
        Scanner scanner = new Scanner(System.in);
        medlemController n = new medlemController();
        boolean running = true;


        while (running) {
            System.out.println("1. Registrer nyt medlem ");
            System.out.println("2. Rediger medlem ");
            System.out.println("3. Vis alle medlemmer ");
            System.out.println("4. Fjern medlem ");
            System.out.println("5. Tilbage ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    medlemController.opretMedlem();
                    break;
                case 2:
                    medlemController.redigerMedlem();
                    break;
                case 3:
                    n.display();
                    break;
                case 4:
                    medlemController.fjernMedlem();
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }
    public static void kontingentMenu(){
        Scanner scanner = new Scanner(System.in);
        kontController kont = new kontController();
        boolean u = true;
        while (u) {
System.out.println("1. Vis kontingent ");
System.out.println("2. Vis Vis restance ");
System.out.println("3. Tilbage ");

if (!scanner.hasNextInt()) {
System.out.println("Ugyldigt input!");
scanner.nextLine();
continue;
}

int choice = scanner.nextInt();
switch (choice){
    case 1:
        break;
    case 2:
        break;
    case 3:
        u = false;
        break;
}
        }
    }

    public static void statistikMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean sprint = true;
        while (sprint) {
            System.out.println("1. Træning ");
            System.out.println("2. Registrér konkurrencesvømmer ");
            System.out.println("3. Tilbage ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MenuController.trainingMenu();
                    break;
                case 2:
                    resultatController.Competition();
                    break;
                case 3:
                    sprint = false;
                    break;
            }
        }
    }

    public static void trainingMenu(){
        Scanner scanner = new Scanner(System.in);
        resultatController resultat = new resultatController();
        boolean runs = true;
        while (runs) {
System.out.println("1. Vis top 5 for hver disciplin ");
System.out.println("2. Opret");
System.out.println("3. Vis alle");
System.out.println("4. Tilbage");

if (!scanner.hasNextInt()) {
System.out.println("Ugyldigt input!");
scanner.nextLine();
continue;
}
int choice = scanner.nextInt();
switch (choice) {
    case 1:
        resultat.display();
        break;
    case 2:
        resultatController.registerTraining();
        break;
    case 3:
        resultatController.showMembers();
        break;
    case 4:
        runs = false;
        break;
}

        }

    }
}
