import java.time.LocalDate;
import java.time.Period;

public class Member {

        public class Member {
            private String name;
            private LocalDate birthDate;
            private int memberId;
            private double subscription;
            private boolean active;
            private boolean restance;
            private boolean konkurrenceSvømmer;

            public Member(String name, LocalDate birthDate, int memberId, boolean active) {
                this.name = name;
                this.birthDate = birthDate;
                this.memberId = memberId;
                this.active = active;
            }

            public Member(String name, LocalDate birthDate, int memberId, boolean active,
                          boolean restance, boolean konkurrenceSvømmer) {
                this.name = name;
                this.birthDate = birthDate;
                this.memberId = memberId;
                this.subscription = calculatePrice();
                this.active = active;
                this.restance = restance;
                this.konkurrenceSvømmer = konkurrenceSvømmer;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public LocalDate getBirthDate() {
                return birthDate;
            }

            public int getAge() {
                return Period.between(birthDate, LocalDate.now()).getYears();
            }
            public boolean konkurrenceSvømmer() {
                return konkurrenceSvømmer;
            }
            public int getMemberId() {
                return memberId;
            }

            public void setMmeberId(int memberId) {
                this.memberId = memberId;
            }

            public boolean getActive() {
                return active;
            }

            public void setActive(boolean active) {
                this.active = active;
            }
            public boolean getRestance() {
                return restance;
            }

            public void setRestance(boolean restance) {
                this.restance = restance;
            }


            public double calculatePrice() {
                return 0;
            }


        }
    }


