package Medlem;

public class Member {
            private String name;
            private int age;
            private int memberId;
            private boolean active;
            private boolean restance;
            private boolean konkurrenceSvømmer;

            public Member( int memberId, String name, int age, boolean konkurrenceSvømmer) {
                this.name = name;
                this.age = age;
                this.memberId = memberId;

                this.konkurrenceSvømmer = konkurrenceSvømmer;
            }

            public String getName(){
                return name;
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





