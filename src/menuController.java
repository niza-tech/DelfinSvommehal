import java.util.Scanner;

public class menuController {
    public static void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean y = true;

        while (y) {
            System.out.println("Welcome message");
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
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }

    public static String mainMenuTekst() {
        return "\nMain Menu:" + "\n" +
                """
                        1. Medlemmer
                        2. Kontingent
                        3. Vis træningsstatistik
                        4. Afslut program
                        """;
    }

    public static void medlemMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("1. Registrer nyt medlem ");
            System.out.println("2. Fjern medlem ");
            System.out.println("3. Vis alle medlemmer ");
            System.out.println("4. Rediger medlem ");
            System.out.println("5. Tilbage ");

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    running = false;
                    break;
            }
        }
    }
}
