package Controllers;

import Medlem.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class medlemController {
    private static ArrayList<Member> members = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static Member opretMedlem() {
        scanner.nextLine();
        System.out.print("Navn: ");
        String name = scanner.nextLine();

        System.out.print("Alder: ");
        int age = scanner.nextInt();
        ;

        System.out.print("ID: ");
        int memberId = scanner.nextInt();

        System.out.print("Aktivt medlem? (ja/nej): ");
        boolean active = scanner.nextBoolean();

        System.out.print("Restance? (ja/nej): ");
        boolean restance = scanner.nextBoolean();

        System.out.print("Konkurrencesvømmer? (ja/nej): ");
        boolean konkurrenceSvømmer = scanner.nextBoolean();

        Member member = new Member(name, age, memberId, active, restance,
                konkurrenceSvømmer);
        members.add(member);
        System.out.println("Medlem oprettet: " + member.getName());

    public static void fjernMedlem() {
    }

    public static void displayMembers() {
    }

    public static void redigerMedlem() {
    }
}
