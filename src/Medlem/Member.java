package Medlem;

import java.util.ArrayList;

public class Member {
    private String name;
    private ArrayList<String> svømmeDisciplin;
    //private LocalDate birthDate;
    private int age;
    private int memberId;
    private boolean active;
    private boolean restance;
    private boolean konkurrenceSvømmer;
    private Medlem.Medlemskab medlemskab; // Added membership type

    public Member(int memberId, String name, int age, boolean konkurrenceSvømmer, boolean active, boolean restance, ArrayList<String> svømmeDisciplin, Medlem.Medlemskab medlemskab) {
        this.name = name;
        //this.birthDate = birthDate;
        this.age = age;
        this.memberId = memberId;
        this.konkurrenceSvømmer = konkurrenceSvømmer;
        this.active = active;
        this.restance = restance;
        this.svømmeDisciplin = svømmeDisciplin;
        this.medlemskab = medlemskab; // Assign membership
    }


            public String getName(){
                return name;
            }

            public int getAge() {
        return age;
            }

            public ArrayList<String> getSvømmeDisciplin() {
                return svømmeDisciplin;
            }

           // public int getAge(){
          //      return Period.between(birthDate, LocalDate.now()).getYears();
           // }

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
            public void setAge(int age){
        this.age = age;
            }

            public void setSvømmeDisciplin(ArrayList <String> Svømmediscipliner) {
                this.svømmeDisciplin = Svømmediscipliner;
            }

          //  public void setBirthDate(LocalDate birthDate) {
            //    this.birthDate = birthDate;
            //}

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
                        ", Alder: " + getAge() +
                        ", KonkurrenceSvømmer: " + (konkurrenceSvømmer ? "Ja" : "Nej") +
                        ", Medlemskab: " + medlemskab;
            }

}