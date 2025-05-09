package Medlem;

import java.util.ArrayList;
import Medlem.Medlemskab;

public class Member {
    private String name;
    private ArrayList<String> svømmeDisciplin;
    private int age;
    private int memberId;
    private boolean active;
    private boolean restance;
    private boolean konkurrenceSvømmer;
    private Medlem.Medlemskab medlemskab; // Added membership type

    public Member(int memberId, String name, int age, boolean konkurrenceSvømmer, boolean active, ArrayList<String> svømmeDisciplin, Medlem.Medlemskab medlemskab) {
        this.name = name;
        this.age = age;
        this.memberId = memberId;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.active = active;
        this.svømmeDisciplin = svømmeDisciplin;
        this.medlemskab = medlemskab; // Assign membership
    }

            public String getName(){
                return name;
            }

            public ArrayList<String> getSvømmeDisciplin() {
                return svømmeDisciplin;
            }

            public int getAge(){
                return age;
            }

            public int getMemberId(){
                return memberId;
            }

            public boolean getIsActive(){
                return active;
            }

            public boolean getIsRestance(){
                return restance;
            }

            public boolean getIsKonkurrenceSvømmer(){
                return konkurrenceSvømmer;
            }

    public Medlem.Medlemskab getMedlemskab() {
        return medlemskab;
    }

    public void setName(String name){
                this.name = name;
            }

            public void setSvømmeDisciplin(ArrayList <String> Svømmediscipliner) {
                this.svømmeDisciplin = Svømmediscipliner;
            }

            public void setAge(int age){
                this.age = age;
            }

            public void setMemberId(int memberId){
                this.memberId = memberId;
            }

            public void setIsActive(boolean active) {
                this.active = active;
            }

            public void setIsRestance(boolean restance){
                this.restance = restance;
            }

            public void setIsKonkurrenceSvømmer(boolean konkurrenceSvømmer){
                this.konkurrenceSvømmer = konkurrenceSvømmer;
            }

            public void setMedlemskab(Medlem.Medlemskab medlemskab) {
        this.medlemskab = medlemskab;
            }

            @Override
    public String toString() {
                return "ID: " + memberId +
                        ", Navn: " + name +
                        ", Alder: " + age +
                        ", KonkurrenceSvømmer: " + (konkurrenceSvømmer ? "Ja" : "Nej") +
                        ", Medlemskab: " + medlemskab;
            }
}