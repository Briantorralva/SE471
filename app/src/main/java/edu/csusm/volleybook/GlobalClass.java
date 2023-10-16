package edu.csusm.volleybook;
import java.util.LinkedList;
public class GlobalClass {
    private static LinkedList<String> ActivePlayers_Blue = new LinkedList<>();
    private static LinkedList<String> BenchPlayer_Blue = new LinkedList<>();
    private static LinkedList<String> ActivePlayers_Red = new LinkedList<>();
    private static LinkedList<String> BenchPlayer_Red = new LinkedList<>();
    private static String referee;
    private static int libero;

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

    // Getter and Setter for Team 2
    public static LinkedList<String> getTeam2() {
        return team2;
    }

    public static void setTeam2(LinkedList<String> team2) {
        GlobalClass.team2 = team2;
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
}
