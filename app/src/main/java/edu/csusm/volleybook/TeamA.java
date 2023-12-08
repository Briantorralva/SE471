package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import android.widget.Toast;


public class TeamA extends AppCompatActivity {
    private static PlayerLinkedList playerLinkedList; // Declare PlayerLinkedList
    private static final String PREFS_NAME = "TeamAData";
    private static final String JSON_FILE_NAME_A = "team_a_players.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_a);

        // Initialize PlayerLinkedList only if it's null
        if (playerLinkedList == null) {
            playerLinkedList = new PlayerLinkedList();
        }

        // Load previously saved player names
        //loadPlayerNames();

        // Display the players from ActivePlayers_Blue in the EditText fields
        displayPlayersFromActivePlayersBlue();

        //SharedPreferences prefs = getSharedPreferences("TeamAData", MODE_PRIVATE);
        boolean isTimeoutButton1Enabled = true;//prefs.getBoolean("timeoutButton1Enabled", true);
        boolean isTimeoutButton2Enabled = true;//prefs.getBoolean("timeoutButton2Enabled", true);

        findViewById(R.id.TeamATimeOut1).setEnabled(isTimeoutButton1Enabled);
        findViewById(R.id.TeamATimeOut2).setEnabled(isTimeoutButton2Enabled);


}

    private void displayPlayersFromActivePlayersBlue() {
        LinkedList<String> activePlayersBlue = GlobalClass.getActivePlayers_Blue();

        // Assuming you have 6 EditText fields with IDs Box1, Box2, ..., Box6
        for (int i = 0; i < Math.min(activePlayersBlue.size(), 6); i++) {
            int resourceId = getResources().getIdentifier("Box" + (i + 1), "id", getPackageName());
            EditText editText = findViewById(resourceId);

            // Set the text from ActivePlayers_Blue into the EditText
            editText.setText(activePlayersBlue.get(i));
        }
    }

    public void TeamAReturnButton(View v) {
        // Return to the game_page
        Intent i = new Intent(this, GamePage.class);
        startActivity(i);
    }

    public void savePlayers(View view) {
        // Retrieve player names from EditText fields
        String[] playerNames = new String[6];
        for (int i = 1; i <= 6; i++) {
            int resourceId = getResources().getIdentifier("Box" + i, "id", getPackageName());
            EditText editText = findViewById(resourceId);
            playerNames[i - 1] = editText.getText().toString();
        }

        // Add players to existing PlayerLinkedList
        for (String playerName : playerNames) {
            if (!playerName.isEmpty()) {
                playerLinkedList.addPlayer(playerName);
            }
        }

        // Save player names
        savePlayerNames(playerNames);

        // Display the players (optional)
        playerLinkedList.displayPlayers();

        String json = playerLinkedList.toJson();
        saveJsonToFile(json, JSON_FILE_NAME_A);

        //TeamAReturnButton(view);
    }

    private void saveJsonToFile(String json, String fileName) {
        try {
            File file = new File(getFilesDir(), fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerNames(String[] playerNames) {
        SharedPreferences.Editor editor = getSharedPreferences("TeamAData", MODE_PRIVATE).edit();

        for (int i = 0; i < playerNames.length; i++) {
            editor.putString("player" + i, playerNames[i]);
        }
        editor.apply();
    }

    private void loadPlayerNames() {
        SharedPreferences prefs = getSharedPreferences("TeamAData", MODE_PRIVATE);
        String json = loadJsonFromFile(JSON_FILE_NAME_A);
        if (json != null) {
            playerLinkedList.fromJson(json);
        }
        for (int i = 0; i < 6; i++) {
            String playerName = prefs.getString("player" + i, "");
            int resourceId = getResources().getIdentifier("Box" + (i + 1), "id", getPackageName());
            EditText editText = findViewById(resourceId);
            editText.setText(playerName);
        }
    }

    private String loadJsonFromFile(String fileName) {
        try {
            File file = new File(getFilesDir(), fileName);
            StringBuilder json = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                json.append(scanner.nextLine());
            }
            scanner.close();
            return json.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    private int timeoutsUsed = 0;
    public void TeamATimeOut1(View v) {
        if (timeoutsUsed < 2) { // Check if there are timeouts left
            v.setEnabled(false); // Disable the button
            timeoutsUsed++; // Increment the timeouts used
            saveTimeoutButtonsState();

        } else {
            // Display a message using a Toast
            Toast.makeText(this, "No more timeouts available for Team A", Toast.LENGTH_SHORT).show();
        }
        checkBothTimeoutsUsed();

        v.setEnabled(false);
    }

    public void TeamATimeOut2(View v) {
        if (timeoutsUsed < 2) { // Check if there are timeouts left
            v.setEnabled(false); // Disable the button
            timeoutsUsed++; // Increment the timeouts used
            saveTimeoutButtonsState();

        } else {
            // Display a message using a Toast
            Toast.makeText(this, "No more timeouts available for Team A", Toast.LENGTH_SHORT).show();
        }
        checkBothTimeoutsUsed();

    }

    private void checkBothTimeoutsUsed() {
        if (timeoutsUsed == 2) {
            // Team A has used both timeouts, display a message
            Toast.makeText(this, "Team A has used all timeouts", Toast.LENGTH_SHORT).show();
        }
    }


    private void saveTimeoutButtonsState() {
        SharedPreferences.Editor editor = getSharedPreferences("TeamAData", MODE_PRIVATE).edit();
        editor.putBoolean("timeoutButton1Enabled", findViewById(R.id.TeamATimeOut1).isEnabled());
        editor.putBoolean("timeoutButton2Enabled", findViewById(R.id.TeamATimeOut2).isEnabled());
        editor.apply();
    }

    static PlayerLinkedList getPlayerLinkedList() {
        return playerLinkedList;
    }


}


