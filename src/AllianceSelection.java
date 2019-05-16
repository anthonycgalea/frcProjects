import java.util.ArrayList;
import java.util.HashMap;


public class AllianceSelection {
    private ArrayList<Integer> teamsAvailable;
    private HashMap<Integer, int[]> alliances;
    public AllianceSelection(ArrayList<Integer> teamList, int alliances, int teamsPerAlliance) {
        this.teamsAvailable = teamList;
        this.alliances = new HashMap<Integer, int[]>();
        for (int i = 0; i < alliances; i++) {
            int[] alliance = new int[teamsPerAlliance];
            this.alliances.put(i, alliance);
        }

        System.out.println("Alliance block generated!");

    }

    public static void main(String[] args) {

        System.out.println("compiled");
    }




}