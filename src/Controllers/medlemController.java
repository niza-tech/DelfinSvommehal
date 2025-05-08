package Controllers;

import Medlem.Member;

import File.IFileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class medlemController {
    private static ArrayList<Member> members = new ArrayList<>();

    public static List<Member> getMemberList(){
        return members;
    }

    public static Member opretMedlem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Navn og efternavn på nyt medlem: ");
        String navn = scanner.nextLine();

        System.out.print("Alder på nyt medlem: ");
        int age = scanner.nextInt();

        System.out.println("Er den nye medlem en konkurrencesvømmer? (true/false): ");
        boolean konkurrenceSvømmer = scanner.nextBoolean();
        scanner.nextLine();

        int newMedlemId = findLowestAvailableId();

        Member newMember = new Member(newMedlemId, navn, age, konkurrenceSvømmer);

        members.add(newMember);

        saveMemberToFile();

        return newMember;
    }

    public static int findLowestAvailableId() {
        int id = 1;
        while (true) {
            boolean idInUse = false;
            for (Member member : members) {
                if (member.getMemberId() == id) {
                    idInUse = true;
                    break;
                }
            }
            if (!idInUse) {
                return id;
            }
            id++;
        }
    }

    public static void fjernMedlem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hvilket medlem vil gerne slette: \n");

        for (Member m : members) {
            System.out.println(m);
        }

        System.out.println("Indtast medlem der skal slettes: ");
        int choose = scanner.nextInt();
        scanner.nextLine();

        Member memberToRemove = null;
        for (Member m : members) {
            if (m.getMemberId() == choose) {
                memberToRemove = m;
                break;
            }
        }
        if (memberToRemove != null) {
            System.out.println("Er du sikker på at du vil slette " + memberToRemove + " (y/n):");
            String accept = scanner.nextLine();

            if (accept.equalsIgnoreCase("y")) {
                members.remove(memberToRemove);
                saveMemberToFile();
                System.out.println("Medlem er nu slettet: " + memberToRemove);
            } else {
                System.out.println("Sletning annulleret.");
            }
        } else {
            System.out.println("Medlem blev ikke fundet.");
        }
    }

    public static void displayMedlem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hvordan vil du sortere medlemmerne?");
        System.out.println("1: Efter ID");
        System.out.println("2: Efter navn");
        System.out.println("3: Efter alder");
        System.out.println("Indtast valg (1-3)");

        int valg = scanner.nextInt();
        scanner.nextLine();
        switch (valg) {
            case 1:
                members.sort(Comparator.comparingInt(Member::getMemberId));
                break;
            case 2:
                members.sort(Comparator.comparing(Member::getName, String.CASE_INSENSITIVE_ORDER));
                break;
            case 3:
                members.sort(Comparator.comparingInt(Member::getAge));
                break;
                default:
                    System.out.println("Ugyldigt valg. Viser listen uden sortering.");
        }

        if (members.isEmpty()) {
            System.out.println("Der er ingen medlemmer i systemet.");
        } else {
            System.out.println("\nMedlemsliste: ");
            for (Member m : members) {
                System.out.println(m);
            }
        }
    }

    public static void redigerMedlem() {
        Scanner scanner = new Scanner(System.in);

        if (members.isEmpty()) {
            System.out.println("Der er ingen medlemmer i systemet.");
            return;
        }

        System.out.println("Vælg hvilket medlem du vil redigere: ");

        for (Member m : members) {
            System.out.println(m);
        }

        System.out.println("Indtast ID på medlem der skal redigeres: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Member memberToEdit = null;
        for (Member m : members) {
            if (m.getMemberId() == id) {
                memberToEdit = m;
                break;
            }
        }

        if (memberToEdit == null) {
            System.out.println("Medlem med dette ID blev ikke fundet.");
            return;
        }

        System.out.println("Redigerer: " + memberToEdit);

        System.out.println("Nyt navn? (ENTER for at behold \"" + memberToEdit.getName() + "\"): ");
        String nytNavn = scanner.nextLine();
        if (!nytNavn.isBlank()) {
            memberToEdit.setName(nytNavn);
        }

        System.out.println("Ny alder? (ENTER for at behold \"" + memberToEdit.getAge() + "\"): ");
        String newAge = scanner.nextLine();
        if (!newAge.isBlank()) {
            try {
                int nyAlder = Integer.parseInt(newAge);
                memberToEdit.setAge(nyAlder);
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt alder. Beholder eksisterende.");
            }
        }
        System.out.println("Er medlemmeren en konkurrencesvømmer? (true/false, ENTER for at behold \"" + memberToEdit.getName() + "\"): ");
        String konkurrenceInput = scanner.nextLine();
        if (!konkurrenceInput.isBlank()) {
            if (konkurrenceInput.equalsIgnoreCase("true")||konkurrenceInput.equalsIgnoreCase("false")) {
                memberToEdit.setIsKonkurrenceSvømmer(Boolean.parseBoolean(konkurrenceInput));
            } else {
                System.out.println("Ugyldigt input. Beholder eksisterende.");
            }
        }

        saveMemberToFile();
        System.out.println("Medlem er nu redigeret: " + memberToEdit);
    }

    public static void saveMemberToFile() {

        try(PrintWriter writer = new PrintWriter(new File("medlemsListe.txt"))) {
            for (Member member : members) {
                writer.println(member.getMemberId() + ";" + member.getName() + ";" + member.getAge() + ";" + member.getIsKonkurrenceSvømmer());
            }
            System.out.println("Listen er nu opdateret.");
        } catch (FileNotFoundException e) {
            System.out.println("Fejl ved at gemme nyt medlem.");
        }
    }

    public static void loadMemberFromFile() {
        File file = new File("medlemsListe.txt");

        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                if (parts.length <= 4) {
                    int medlemId = Integer.parseInt(parts[0]);
                    String navn = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    boolean konkurrenceSvømmer = Boolean.parseBoolean(parts[3]);
                    members.add(new Member(medlemId, navn, age, konkurrenceSvømmer));
                }
            }
            System.out.println("Medlems liste indlæst fra fil.");
            } catch (FileNotFoundException e) {
                System.out.println("Filen kunne ikke findes.");
            }
        } else {
            System.out.println("Medlems liste kunne ikke findes.");
        }
    }
}
