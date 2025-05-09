package Medlem;

import java.util.ArrayList;

public class Member {
            private String name;
            private ArrayList <String> svømmeDisciplin;
            private int age;
            private int memberId;
            private boolean active;
            private boolean restance;
            private boolean konkurrenceSvømmer;

            public Member( int memberId, String name, int age, boolean konkurrenceSvømmer, boolean active, ArrayList<String> svømmeDisciplin) {
                this.name = name;
                this.age = age;
                this.memberId = memberId;
                this.konkurrenceSvømmer = konkurrenceSvømmer;
                this.active = active;
                this.svømmeDisciplin = svømmeDisciplin;
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

            @Override
    public String toString() {
                return "ID: " + memberId +
                        ", Navn: " + name +
                        ", Alder: " + age +
                        ", KonkurrenceSvømmer: " + (konkurrenceSvømmer ? "Ja" : "Nej");
            }
}