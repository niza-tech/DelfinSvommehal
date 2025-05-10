package Controllers;

import File.IDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class resultatController implements IDisplay {


    public static void Competition() {
        ArrayList<String> konkurrence = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Navn på svømmer: ");
        String input1 = sc.nextLine();

        System.out.println("Stævne: ");
        String input2 = sc.nextLine();

        System.out.println("Placering: ");
        String input3 = sc.nextLine();

        System.out.println("Tid i sekunder: ");
        int input4 = sc.nextInt();

        String registrering = "Navn på svømmer: " + input1 + "Stævne: " + input2 +
                ". Placering: " + input3 + ". Tid: " + input4 + "\n";

        konkurrence.add(registrering);

        System.out.println("Registrering gennemført!\n");

        MenuController.statistikMenu();


    }

    public static void registerTraining() {
        ArrayList<String> traening = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Navn på svømmer: ");
        String input5 = sc.nextLine();

        System.out.print("Disciplin: ");
        String input6 = sc.nextLine();

        System.out.println("Tid i sekunder: ");
        int input7 = sc.nextInt();

        String registrering = "Navn på svømmer: " + input5 +
                "Disciplin: " + input6 + ". Tid: " + input7 + "\n";

        traening.add(registrering);

        System.out.println("Registrering gennemført!\n");

        MenuController.statistikMenu();

    }

    public static void showMembers() {
    }

    @Override
    public void display() {

    }
}