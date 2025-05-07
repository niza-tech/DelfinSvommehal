import java.util.ArrayList;
import java.util.List;

public class medlemController {
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Medlem tilføjet: " + member.getName());
    }

    public void showAllMembers() {
        for (Member member : members) {
            System.out.println(member.getName() + " | ID: " + member.getMemberId() + " | Kontingent: " + member.getSubscription());
        }
    }

    public void showRestanceMembers() {
        for (Member member: members) {
            if (member.isRestance()) {
                System.out.println(member.getName() + " er i restance.");
            }
        }
    }



}