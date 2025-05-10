package Controllers;

import Medlem.Member;
import Medlem.Medlemskab;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class kontController {

    public static double calculateYearly() {
        double income = 0;
        File file = new File("medlemsListe.txt");

        if (!file.exists()) {
            System.out.println("Filen blev ikke fundet.");
            return income;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length >=7) {
                    boolean isActive = Boolean.parseBoolean(parts[4]);
                    Medlemskab medlemskab = Medlemskab.valueOf(parts[6]);

                    if (medlemskab == Medlemskab.PASSIV) {
                        income += 500;
                    } else if (isActive) {

                        switch (medlemskab) {
                            case JUNIOR:
                                income += 1000;
                                break;
                            case SENIOR:
                                income += 1600;
                                break;
                            case SENIOR_OVER60:
                                income += 1200;
                                break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke læse medlemsliste.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Ugyldigt medlemskab.");
        }
        return income;
    }

    public static void displayYearly(){
        double yearIncome = calculateYearly();
        System.out.println("Forventet indtægt (årligt): " + yearIncome);
    }

    public static void displayRestance(){
        File file = new File("medlemsListe.txt");

        if (!file.exists()) {
            System.out.println("Filen blev ikke fundet.");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Medlemmer i restance: ");
            boolean found = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length >= 7) {
                    boolean isRestance = Boolean.parseBoolean(parts[5]);

                    if (isRestance) {
                        found = true;
                        System.out.println("ID: " + parts[0] +
                                ", Navn: " + parts[1] +
                                ", Fødselsdato: " + parts[2] +
                                ", Medlemskab: " + parts[6]);
                    }
                }
            }

            if (!found) {
                System.out.println("Ingen medlemmer er i restance.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunne ikke læse medlemsliste.txt");
        }
    }
}
