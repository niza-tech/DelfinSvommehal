package Controllers;

import Medlem.Member;

import java.util.Scanner;

public class medlemController {
    public static Member opretMedlem() {
        Scanner scanner = new Scanner(System.in);

System.out.println("Navn på nyt medlem: ");
String navn = scanner.nextLine();

System.out.println("Alder på nyt medlem: ");
int age = scanner.nextInt();

System.out.println("Er den nye medlem en konkurrenceSvømmer? (true/false): ");
boolean konkurrenceSvømmer = scanner.nextBoolean();
scanner.nextLine();

int newMemberId =

Member newMember = new Member(newMemberId, navn, age, konkurrenceSvømmer);


return newMember;
    }

    public static void fjernMedlem() {
    }

    public static void displayMembers() {
    }

    public static void redigerMedlem() {
    }
}
