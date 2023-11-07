package edu.csusm.volleybook;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class PlayerLinkedList {

    public class Player {
        private String playerName;
        private Player next;
        private Player prev;

        public Player(String playerName) {
            this.playerName = playerName;
            this.next = null;
            this.prev = null;
        }

        public String getPlayerName() {
            return playerName;
        }
    }

    private Player head;
    private Player tail;

    public PlayerLinkedList() {
        head = null;
        tail = null;
    }

    public void addPlayer(String playerName) {
        Player newNode = new Player(playerName);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void displayPlayers() {
        Player current = head;
        while (current != null) {
            System.out.println("Player Name: " + current.getPlayerName());
            current = current.next;
        }
    }

    public String toJson() {
        List<String> playerNames = new LinkedList<>();
        Player current = head;
        while (current != null) {
            playerNames.add(current.getPlayerName());
            current = current.next;
        }
        Gson gson = new Gson();
        return gson.toJson(playerNames);
    }

    // Deserialize player data from JSON
    public void fromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>() {}.getType();
        List<String> playerNames = gson.fromJson(json, type);
        for (String playerName : playerNames) {
            addPlayer(playerName);
        }
    }
}
