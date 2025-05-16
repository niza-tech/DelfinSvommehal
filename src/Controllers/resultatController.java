package Controllers;

import File.IDisplay;
import Medlem.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class resultatController implements IDisplay {

    private static final String MEDLEMS_FIL = "medlemsListe.txt";
    private static final String TRAENINGS_FIL = "traening.txt";
    private static final String STAEVNE_FIL = "staevner.txt";


    public static ArrayList<Member> erKonkurrenceSvømmer() {
        ArrayList<Member> konkurrenceSvømmer = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEDLEMS_FIL))) {
            String linje;
            while ((linje = reader.readLine()) != null) {

                String[] dele = linje.split(";");
                if (dele.length >= 7) {
                    int memberId = Integer.parseInt(dele[0]);
                    String navn = dele[1];
                    int age = Integer.parseInt(dele[2]);
                    boolean konkurrence = Boolean.parseBoolean(dele[3]);
                    boolean active = Boolean.parseBoolean(dele[4]);
                    boolean restance = Boolean.parseBoolean(dele[5]);

                    ArrayList<String> discipliner = new ArrayList<>();
                    for (String d : dele[6].split(",")) {
                        discipliner.add(d.trim());
                    }

                    Medlem.Medlemskab medlemskab = Medlem.Medlemskab.valueOf(dele[7].toUpperCase());

                    if (konkurrence) {
                        Member m = new Member(memberId, navn, age, konkurrence, active, restance, discipliner, medlemskab);
                        konkurrenceSvømmer.add(m);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af medlemsfil: " + e.getMessage());
        }
        return konkurrenceSvømmer;
    }

    public static void registrerTræning() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Member> medlemmer = erKonkurrenceSvømmer();
        if (medlemmer.isEmpty()) {
            System.out.println("Ingen konkurrencesvømmere fundet.");
            return;
        }
        System.out.println("Vælg medlem (ID):");
        for (Member m : medlemmer) {
            System.out.println("ID: " + m.getMemberId() + " | Navn: " + m.getName());
        }

        System.out.print("Indtast ID på medlem: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        Member valgtMedlem = null;
        for (Member m : medlemmer) {
            if (m.getMemberId() == memberId) {
                valgtMedlem = m;
                break;
            }
        }
        if (valgtMedlem == null) {
            System.out.println("Medlem ikke fundet!");
            return;
        }

        ArrayList<String> discipliner = valgtMedlem.getSvømmeDisciplin();
        if (discipliner == null || discipliner.isEmpty()) {
            System.out.println("Medlemmet har ingen registrerede discipliner.");
            return;
        }
        System.out.println("Vælg disciplin:");
        for (int i = 0; i < discipliner.size(); i++) {
            System.out.println((i + 1) + ". " + discipliner.get(i));
        }
        int disciplinValg;
        while (true) {
            System.out.print("Indtast disciplinens nummer: ");
            disciplinValg = scanner.nextInt();
            scanner.nextLine(); // spis newline
            if (disciplinValg >= 1 && disciplinValg <= discipliner.size()) break;
            System.out.println("Ugyldigt valg, prøv igen.");
        }
        String disciplin = discipliner.get(disciplinValg - 1);

        System.out.print("Indtast tid (sekunder): ");
        String tid = scanner.nextLine();

        System.out.print("Indtast dato (fx 16-05-2025): ");
        String dato = scanner.nextLine();

        gemTræning(memberId, dato, tid, disciplin);
    }

    public static void gemTræning(int memberId, String dato, String varighed, String disciplin){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAENINGS_FIL, true))) {
            writer.write(memberId + ";" + dato + ";" + varighed + ";" + disciplin);
            writer.newLine();
            System.out.println("Træning registreret for: " + memberId);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til træningsfil: " + e.getMessage());
        }
    }

    public void registrerStævne() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Member> medlemmer = erKonkurrenceSvømmer();
        if (medlemmer.isEmpty()) {
            System.out.println("Ingen konkurrencesvømmere fundet.");
            return;
        }
        System.out.println("Vælg medlem (ID):");
        for (Member m : medlemmer) {
            System.out.println("ID: " + m.getMemberId() + " | Navn: " + m.getName());
        }

        System.out.print("Indtast ID på medlem: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // spis newline

        Member valgtMedlem = null;
        for (Member m : medlemmer) {
            if (m.getMemberId() == memberId) {
                valgtMedlem = m;
                break;
            }
        }
        if (valgtMedlem == null) {
            System.out.println("Medlem ikke fundet!");
            return;
        }

        System.out.print("Indtast navn på stævne: ");
        String staevneNavn = scanner.nextLine();

        System.out.print("Indtast placering (f.eks. 1 for 1. plads): ");
        String placering = scanner.nextLine();

        System.out.print("Indtast tid i sekunder: ");
        String tid = scanner.nextLine();

        System.out.print("Indtast dato for stævnet (fx 16-05-2025): ");
        String dato = scanner.nextLine();

        gemStævne(memberId, dato, staevneNavn, placering, tid);
    }

    public static void gemStævne(int memberId, String dato, String staevneNavn, String placering, String tid) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STAEVNE_FIL, true))) {
            writer.write(memberId + ";" + dato + ";" + staevneNavn + ";" + placering + ";" + tid);
            writer.newLine();
            System.out.println("Stævne registreret for medlem: " + memberId);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til stævnefil: " + e.getMessage());
        }
    }

    public static void showMembers() {
    }

    @Override
    public void display() {
        String[] discipliner = {"Butterfly", "Crawl", "Rygcrawl", "Brystsvømning"};
        ArrayList<Member> medlemmer = erKonkurrenceSvømmer();

        ArrayList<Resultat> alleResultater = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRAENINGS_FIL))) {
            String linje;
            while ((linje = reader.readLine()) != null) {
                String[] dele = linje.split(";");
                if (dele.length != 4) continue;
                int memberId = Integer.parseInt(dele[0]);
                String dato = dele[1];
                double tid = Double.parseDouble(dele[2]);
                String disciplin = dele[3].trim();
                String navn = "Ukendt";
                for (Member m : medlemmer) {
                    if (m.getMemberId() == memberId) {
                        navn = m.getName();
                        break;
                    }
                }
                alleResultater.add(new Resultat(memberId, navn, tid, dato, disciplin));
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af træningsfil: " + e.getMessage());
            return;
        }

        for (String disciplin : discipliner) {
            ArrayList<Resultat> disciplinerResultater = new ArrayList<>();
            for (Resultat resul : alleResultater) {
                if (resul.disciplin.equalsIgnoreCase(disciplin)) {
                    disciplinerResultater.add(resul);
                }
            }
            for (int i = 0; i < disciplinerResultater.size() - 1; i++) {
                for (int h = 0; h < disciplinerResultater.size() - 1 - i; h++) {
                    if (disciplinerResultater.get(h).tid > disciplinerResultater.get(h + 1).tid) {
                        Resultat temp = disciplinerResultater.get(h);
                        disciplinerResultater.set(h, disciplinerResultater.get(h + 1));
                        disciplinerResultater.set(h + 1, temp);
                    }
                }
            }
            System.out.println("\nTop 5 i disciplinen: " + disciplin);
            if (disciplinerResultater.isEmpty()) {
                System.out.println("Ingen resultater registreret endnu.");
            } else {
                for (int i = 0; i < disciplinerResultater.size() && i < 5; i++) {
                    Resultat resul = disciplinerResultater.get(i);
                    System.out.printf("%d. %s (ID: %d) Tid: %.2f sekunder, Dato: %s\n", i + 1, resul.navn, resul.memberId, resul.tid, resul.dato);
                }
            }
        }
    }

    private static class Resultat {
        int memberId;
        String navn;
        double tid;
        String dato;
        String disciplin;
        Resultat(int memberId, String navn, double tid, String dato, String disciplin) {
            this.memberId = memberId;
            this.navn = navn;
            this.tid = tid;
            this.dato = dato;
            this.disciplin = disciplin;
        }
    }
}