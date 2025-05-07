package Medlem;

public class Member {
            private String name;
            private int age;
            private int memberId;
            private boolean active;
            private boolean restance;
            private boolean konkurrenceSvømmer;

            public Member(String name, int age, int memberId, boolean active,
                          boolean restance, boolean konkurrenceSvømmer) {
                this.name = name;
                this.age = age;
                this.memberId = memberId;
                this.active = active;
                this.restance = restance;
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
}





