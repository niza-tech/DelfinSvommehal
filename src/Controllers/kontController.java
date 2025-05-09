package Controllers;

import Medlem.Member;
import Medlem.Medlemskab;

import java.util.List;

public class kontController {

    public static double calculateYearly(List<Member> members) {
        double income = 0;

        for (Member member : members) {
            if (member.getIsActive()) {
                switch (member.getMedlemskab()) {
                    case JUNIOR:
                        income += 1000;
                        break;
                    case SENIOR:
                        income += 1600;
                        break;
                    case SENIOR_OVER60:
                        income += 1200;
                        break;
                    case PASSIV:
                        income += 500;
                        break;
                }
            }
        }
        return income;
    }
}
