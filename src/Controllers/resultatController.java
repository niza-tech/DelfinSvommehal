package Controllers;

import File.IFileReader;

import java.util.ArrayList;
import java.util.Scanner;

import static File.FileHandling.gemResultat;

public class resultatController implements IFileReader {


    public static void Competition() {
        ArrayList<String> konkurrence = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        System.out.println("Stævne: ");
        String input1 = sc.nextLine();

        System.out.println("Placering: ");
        String input2 = sc.nextLine();

        System.out.println("Tid: ");
        int input3 = sc.nextInt();

        String registrering = "Stævne: " + input1 + ". Placering: " + input2 + ". Tid: " + input3 + "\n";

        konkurrence.add(registrering);

        System.out.println("Registrering gennemført!\n");

        menuController.statistikMenu();


    }

    public static void registerTraining() {
        Scanner sc = new Scanner(System.in);



        gemResultat(registrering);
    }

    public static void showMembers() {
    }

    @Override
    public void fileReader() {

    }
}
