package Controllers;

import java.util.Scanner;

public class menuController {
    public static void mainMenu() {

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
                    menuController.medlemMenu();
                    break;
                case 2:
                    menuController.kontingentMenu();
                    break;
                case 3:
                    menuController.statistikMenu();
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

    public static void medlemMenu() {
        Scanner scanner = new Scanner(System.in);
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
                    medlemController.fjernMedlem();
                    break;
                case 3:
                    medlemController.displayMembers();
                    break;
                case 4:
                    medlemController.redigerMedlem();
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }
    public static void kontingentMenu(){
        Scanner scanner = new Scanner(System.in);
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
        kontController.showRestance();
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
            System.out.println("1. Trænin ");
            System.out.println("2. Stævne ");
            System.out.println("3. Tilbage ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ugyldigt input!");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuController.trainingMenu();
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
