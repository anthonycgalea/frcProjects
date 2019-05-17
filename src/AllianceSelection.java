import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class AllianceSelection {
    private ArrayList<Integer> teamsAvailable;
    private HashMap<Integer, int[]> alliances;
    private Scanner scanner;
    private int pick;
    public AllianceSelection(ArrayList<Integer> teamList, int alliances, int teamsPerAlliance) {
        this.scanner = new Scanner(System.in);
        this.teamsAvailable = teamList;
        this.alliances = new HashMap<Integer, int[]>();
        for (int i = 1; i <= alliances; i++) {
            int[] alliance = new int[teamsPerAlliance];
            this.alliances.put(i, alliance);
        }

        System.out.println("Alliance block generated!");
        this.pick = 1;
    }

    public boolean isFinished() {
        int[] allOne = this.alliances.get(1);
        int[] allBot = this.alliances.get(this.alliances.size());
        int allSize = allOne.length - 1;
        if ((allOne[allSize] != 0)) {
            if ((allBot[allSize] != 0)) {
                return false;
            }
        }
        return true;
    }

    public int select(int round) {

        //TODO: FIX ROUNDS 2+
        int i;
        if (round%2 == 1) {
            i = 1;
        }
        else {
            i = this.alliances.size();
        }
        while(true) {
            //System.out.println("here");
            if (!this.alliances.containsKey(i)) {
                return round++;
            }
            int[] allCheck = this.alliances.get(i);
            //Check for captain first
            if (allCheck[0] == 0) {
                while(true) {
                    System.out.println("Teams Available:");
                    System.out.println(this.teamsAvailable);
                    System.out.println("Who is the #" + i + " seeded alliance captain?");
                    int team = this.scanner.nextInt();
                    if (this.teamsAvailable.contains(team)) {
                        allCheck[0] = team;
                        this.alliances.put(i, allCheck);
                        this.teamsAvailable.remove(this.teamsAvailable.indexOf(team));
                        System.out.println("Congratulations, team #" + team);
                        break;
                    } else {
                        System.out.println("Invalid team.");
                    }
                }
                break;
            }
            else if (allCheck[round] == 0) {
                while(true) {
                    System.out.println("Teams Available:");
                    System.out.println(this.teamsAvailable);
                    System.out.println("Who is the #" + this.pick + " overall pick?");
                    int team = this.scanner.nextInt();
                    if (this.teamsAvailable.contains(team)) {
                        allCheck[1] = team;
                        this.alliances.put(i, allCheck);
                        this.teamsAvailable.remove(this.teamsAvailable.indexOf(team));
                        System.out.println("Congratulations, team #" + team);
                        this.pick++;
                        break;
                    } else {
                        System.out.println("Invalid team.");
                    }
                }
                break;
            } else {

                if (round%2 == 1) {
                    i++;
                } else {
                    i--;
                }
            }
        }

        return round;
    }
/*
    public boolean round1() {
        int i = 1;
        while(true) {
            if (!this.alliances.containsKey(i)) {
                return false;
            }
            int[] allCheck = this.alliances.get(i);
            //Check for captain first
            if (allCheck[0] == 0) {
                while(true) {
                    System.out.println("Teams Available:");
                    System.out.println(this.teamsAvailable);
                    System.out.println("Who is the #" + i + " seeded alliance captain?");
                    int team = this.scanner.nextInt();
                    if (this.teamsAvailable.contains(team)) {
                        allCheck[0] = team;
                        this.alliances.put(i, allCheck);
                        this.teamsAvailable.remove(this.teamsAvailable.indexOf(team));
                        System.out.println("Congratulations, team #" + team);
                        break;
                    } else {
                        System.out.println("Invalid team.");
                    }
                }
                break;
            }
            else if (allCheck[1] == 0) {
                while(true) {
                    System.out.println("Teams Available:");
                    System.out.println(this.teamsAvailable);
                    System.out.println("Who is the #" + i + " overall pick?");
                    int team = this.scanner.nextInt();
                    if (this.teamsAvailable.contains(team)) {
                        allCheck[1] = team;
                        this.alliances.put(i, allCheck);
                        this.teamsAvailable.remove(this.teamsAvailable.indexOf(team));
                        System.out.println("Congratulations, team #" + team);
                        break;
                    } else {
                        System.out.println("Invalid team.");
                    }
                }
                break;
            } else {
            i++;
            }
        }
        return true;
    }

    public boolean round2() {
        int i = this.alliances.size();
        while(true) {
            if (!this.alliances.containsKey(i)) {
                return false;
            }
            int[] allCheck = this.alliances.get(i);
            //Check for if 8th seed has picked
            if (allCheck[2] == 0) {
                while(true) {
                    System.out.println("Teams Available:");
                    System.out.println(this.teamsAvailable);
                    System.out.println("Who is the #" + (17-i) + " overall pick?");
                    int team = this.scanner.nextInt();
                    if (this.teamsAvailable.contains(team)) {
                        allCheck[2] = team;
                        this.alliances.put(i, allCheck);
                        this.teamsAvailable.remove(this.teamsAvailable.indexOf(team));
                        System.out.println("Congratulations, team #" + team);
                        break;
                    } else {
                        System.out.println("Invalid team.");
                    }
                }
                break;
            } else {
            i--;
            }
        }
        return true;
    }
*/
    public void displayAlliances() {
        System.out.println("Alliances are as follows:");
        for (int i = 1; i <= this.alliances.size(); i++) {
            int[] alliance = this.alliances.get(i);
            String allString = "" + alliance[0];
            for (int j = 1; j < alliance.length; j++) {
                allString+= ", " + alliance[j];
            }
            System.out.println("Alliance #" + i + ": " + allString);
        }
        System.out.println("Good luck teams!");
    }

}