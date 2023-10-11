package edu.csusm.volleybook;

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
}
