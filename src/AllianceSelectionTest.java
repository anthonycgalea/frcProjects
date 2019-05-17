import java.util.ArrayList;

public class AllianceSelectionTest {

    public static void main(String[] args) {
        ArrayList<Integer> teamlist = new ArrayList<>();
        for(int i = 1; i <= 40; i++) {
            teamlist.add(i);
        }

        AllianceSelection test = new AllianceSelection(teamlist, 4, 4, false);
        test.runAllianceSelection();
    }

}
