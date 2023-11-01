package edu.csusm.volleybook;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class GlobalClass {
    private static LinkedList<String> ActivePlayers_Blue = new LinkedList<>();
    private static LinkedList<String> BenchPlayer_Blue = new LinkedList<>();
    private static LinkedList<String> ActivePlayers_Red = new LinkedList<>();
    private static LinkedList<String> BenchPlayer_Red = new LinkedList<>();
    private static String referee;
    private static String Team1Name;
    private static String Team2Name;
    private static int libero;
    private static String firstServeTeam;  // Name of the team serving first
    private static String firstServePlayer;  // Name of the player making the first serve
    // Static list to keep track of the first point served at the beginning of a new rally
    private static List<String> firstPointsServed = new ArrayList<>();
    // Static list to keep track of rally points scored
    private static List<String> rallyPoints = new ArrayList<>();


    // Getter and Setter for Team 1
    public static LinkedList<String> getActivePlayers_Blue() {
        return ActivePlayers_Blue;
    }
    public static void setActivePlayers_Blue(LinkedList<String> team1) {
        GlobalClass.ActivePlayers_Blue = team1;
    }
    public static LinkedList<String> getBenchPlayer_Blue() {
        return BenchPlayer_Blue;
    }

    public static void setBenchPlayer_Blue(LinkedList<String> team1) {
        GlobalClass.BenchPlayer_Blue = team1;
    }
    public static LinkedList<String> getActivePlayers_Red() {
        return ActivePlayers_Red;
    }

    public static void setActivePlayers_Red(LinkedList<String> team1) {
        GlobalClass.ActivePlayers_Red = team1;
    }
    public static LinkedList<String> getBenchPlayer_Red() {
        return BenchPlayer_Red;
    }

    public static void setBenchPlayer_Red(LinkedList<String> team1) {
        GlobalClass.BenchPlayer_Red = team1;
    }

    // Getter and Setter for Referee
    public static String getReferee() {
        return referee;
    }
    public static void setReferee(String referee) {
        GlobalClass.referee = referee;
    }

    // Getter and Setter for Libero
    public static int getLibero() {
        return libero;
    }

    public static void setLibero(int libero) {
        GlobalClass.libero = libero;
    }

    public static void setTeam1Name(String team1name) {GlobalClass.Team1Name = team1name; }
    public static void setTeam2Name(String team2name) {GlobalClass.Team2Name = team2name; }

    public static String getTeam1Name() { return Team1Name; }
    public static String getTeam2Name() { return Team2Name; }
    // Getter and setter methods for the first serve tuple
    public static String getFirstServeTeam() {return firstServeTeam;}

    public static void setFirstServeTeam(String team) {firstServeTeam = team;}

    public static String getFirstServePlayer() {return firstServePlayer;}

    public static void setFirstServePlayer(String player) {firstServePlayer = player;}
    // Method to add the first point served at the beginning of a new rally to the list
    public static void addFirstPointServed(String team) {
        firstPointsServed.add(team);
    }

    // Method to retrieve the list of first points served
    public static List<String> getFirstPointsServed() {
        return firstPointsServed;
    }
    // Method to add a point scored in a rally to the list
    public static void addRallyPoint(String team) {
        rallyPoints.add(team);
    }

    // Method to retrieve the list of rally points scored
    public static List<String> getRallyPoints() {
        return rallyPoints;
    }


    // Method to swap a player from active to bench (Blue team)
    public static void swapPlayerFromActiveToBench_Blue(String playerName) {
        if (ActivePlayers_Blue.contains(playerName)) {
            ActivePlayers_Blue.remove(playerName);
            BenchPlayer_Blue.add(playerName);
        }
    }

    public static void swapPlayer(LinkedList<String> activePlayers, LinkedList<String> benchPlayers, String ActiveplayerName, String BenchPlayerName) {
        if (activePlayers.contains(ActiveplayerName)) {
            if(benchPlayers.contains(BenchPlayerName))
            {
                activePlayers.remove(ActiveplayerName);
                benchPlayers.remove(benchPlayers);
                benchPlayers.add(ActiveplayerName);
                activePlayers.add(BenchPlayerName);
            }
        }
    }

}
