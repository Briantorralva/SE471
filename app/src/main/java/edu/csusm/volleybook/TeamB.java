package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeamB extends AppCompatActivity {

    private static PlayerLinkedList playerLinkedListB; // Declare PlayerLinkedList
    private static final String PREFS_NAME = "TeamBData";

    private static final String JSON_FILE_NAME_B = "team_b_players.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_b);

        // Initialize PlayerLinkedList only if it's null
        if (playerLinkedListB == null) {
            playerLinkedListB = new PlayerLinkedList();
        }

        // Load previously saved player names
        loadPlayerNames();

        SharedPreferences prefs = getSharedPreferences("TeamBData", MODE_PRIVATE);
        boolean isTimeoutButton1Enabled = prefs.getBoolean("timeoutButton1Enabled", true);
        boolean isTimeoutButton2Enabled = prefs.getBoolean("timeoutButton2Enabled", true);

        findViewById(R.id.TeamBTimeOut1).setEnabled(isTimeoutButton1Enabled);
        findViewById(R.id.TeamBTimeOut2).setEnabled(isTimeoutButton2Enabled);

    }
    public void TeamBReturnButton (View v){
        //Return to Game page
        Intent i = new Intent(this,GamePage.class);
        startActivity(i);

    }
    public void SaveTeamBPlayers (View view){
        // Retrieve player names from EditText fields
        String[] playerNames = new String[6];
        for (int i = 1; i <= 6; i++) {
            int resourceId = getResources().getIdentifier("TeamBBox" + i, "id", getPackageName());
            EditText editText = findViewById(resourceId);
            playerNames[i - 1] = editText.getText().toString();
        }

        // Add players to existing PlayerLinkedList
        for (String playerName : playerNames) {
            if (!playerName.isEmpty()) {
                playerLinkedListB.addPlayer(playerName);
            }
        }

        // Save player names
        savePlayerNames(playerNames);

        // Display the players (optional)
        playerLinkedListB.displayPlayers();

        // Save player names to JSON for TeamB
        String json = playerLinkedListB.toJson();
        saveJsonToFile(json, JSON_FILE_NAME_B);
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
        SharedPreferences.Editor editor = getSharedPreferences("TeamBData", MODE_PRIVATE).edit();
        for (int i = 0; i < playerNames.length; i++) {
            editor.putString("player" + i, playerNames[i]);
        }
        editor.apply();
    }

    private void loadPlayerNames() {
        SharedPreferences prefs = getSharedPreferences("TeamBData", MODE_PRIVATE);

        String json = loadJsonFromFile(JSON_FILE_NAME_B);
        if (json != null) {
            playerLinkedListB.fromJson(json);
        }

        for (int i = 0; i < 6; i++) {
            String playerName = prefs.getString("player" + i, "");
            int resourceId = getResources().getIdentifier("TeamBBox" + (i + 1), "id", getPackageName());
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

    public void TeamBTimeOut1(View v){
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

    public void TeamBTimeOut2(View v){
        if (timeoutsUsed < 2) { // Check if there are timeouts left
            v.setEnabled(false); // Disable the button
            timeoutsUsed++; // Increment the timeouts used
            saveTimeoutButtonsState();

        } else {
            // Display a message using a Toast
            Toast.makeText(this, "No more timeouts available for Team B", Toast.LENGTH_SHORT).show();
        }
        checkBothTimeoutsUsed();
    }

    private void checkBothTimeoutsUsed() {
        if (timeoutsUsed == 2) {
            // Team A has used both timeouts, display a message
            Toast.makeText(this, "Team B has used all timeouts", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveTimeoutButtonsState() {
        SharedPreferences.Editor editor = getSharedPreferences("TeamBData", MODE_PRIVATE).edit();
        editor.putBoolean("timeoutButton1Enabled", findViewById(R.id.TeamBTimeOut1).isEnabled());
        editor.putBoolean("timeoutButton2Enabled", findViewById(R.id.TeamBTimeOut2).isEnabled());
        editor.apply();
    }

    public static PlayerLinkedList getPlayerLinkedListB() {
        return playerLinkedListB;
    }

}