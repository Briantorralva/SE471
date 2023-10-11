package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TeamA extends AppCompatActivity {
    private PlayerLinkedList playerLinkedList; // Declare PlayerLinkedList
    private static final String PREFS_NAME = "PlayerData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_a);

        // Initialize PlayerLinkedList only if it's null
        if (playerLinkedList == null) {
            playerLinkedList = new PlayerLinkedList();
        }

        // Load previously saved player names
        loadPlayerNames();
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
    }

    private void savePlayerNames(String[] playerNames) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        for (int i = 0; i < playerNames.length; i++) {
            editor.putString("player" + i, playerNames[i]);
        }
        editor.apply();
    }

    private void loadPlayerNames() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        for (int i = 0; i < 6; i++) {
            String playerName = prefs.getString("player" + i, "");
            int resourceId = getResources().getIdentifier("Box" + (i + 1), "id", getPackageName());
            EditText editText = findViewById(resourceId);
            editText.setText(playerName);
        }
    }
}
