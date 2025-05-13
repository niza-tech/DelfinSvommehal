package Controllers;

import File.IDisplay;
import Medlem.Member;
import Medlem.Medlemskab;

import java.io.*;
import java.time.LocalDate;
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
                    LocalDate birthDate = LocalDate.parse(dele[2]);
                    boolean konkurrence = Boolean.parseBoolean(dele[3]);
                    boolean active = Boolean.parseBoolean(dele[4]);
                    boolean restance = Boolean.parseBoolean(dele[5]);

                    ArrayList<String> discipliner = new ArrayList<>();
                    for (String d : dele[6].split(",")) {
                        discipliner.add(d.trim());
                    }

                    Medlem.Medlemskab medlemskab = Medlem.Medlemskab.valueOf(dele[7].toUpperCase());

                    if (konkurrence) {
                        Member m = new Member(memberId, navn, birthDate, konkurrence, active, restance, discipliner, medlemskab);
                        konkurrenceSvømmer.add(m);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved læsning af medlemsfil: " + e.getMessage());
        }
        return konkurrenceSvømmer;
    }

    public static void registrerTræning(int memberId, String dato, String varighed, String disciplin){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAENINGS_FIL, true))) {
            writer.write(memberId + ";" + dato + ";" + varighed + ";" + disciplin);
            writer.newLine();
            System.out.println("Træning registreret for: " + memberId);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til træningsfil: " + e.getMessage());
        }
    }

    public static void registrerStævne(int memberId, String dato, String staevneNavn, String tid){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STAEVNE_FIL, true))) {
            writer.write(memberId + ";" + dato + ";" + staevneNavn + ";" + tid);
            writer.newLine();
            System.out.println("Stævne registreret for " + memberId);
        } catch (IOException e) {
            System.out.println("Fejl ved skrivning til stævnefil: " + e.getMessage());
        }
    }

    public static void showMembers() {
    }

    @Override
    public void display() {

    }
}