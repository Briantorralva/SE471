package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.LinkedList;


public class GamePage extends AppCompatActivity {

    private TextView valueTextViewA;
    private TextView valueTextViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        valueTextViewA = findViewById(R.id.scoreA);
        valueTextViewB = findViewById(R.id.scoreB);

        updateScoreDisplay(); // Update the initial score display
    }

    private void updateScoreDisplay() {
        valueTextViewA.setText(String.valueOf(GlobalClass.getScoreTeamA()));
        valueTextViewB.setText(String.valueOf(GlobalClass.getScoreTeamB()));
    }

    public void incrementScoreA(View v) {
        GlobalClass.setScoreTeamA(GlobalClass.getScoreTeamA() + 1);
        updateScoreDisplay();
        if(GlobalClass.getScoreTeamA() >= 21)
            GameOver(v);
    }

    public void decrementScoreA(View v) {
        if (GlobalClass.getScoreTeamA() > 0) {
            GlobalClass.setScoreTeamA(GlobalClass.getScoreTeamA() - 1);
            updateScoreDisplay();
        }
    }

    public void incrementScoreB(View v) {
        GlobalClass.setScoreTeamB(GlobalClass.getScoreTeamB() + 1);
        updateScoreDisplay();
        if(GlobalClass.getScoreTeamB() >= 21)
            GameOver(v);
    }

    public void decrementScoreB(View v) {
        if (GlobalClass.getScoreTeamB() > 0) {
            GlobalClass.setScoreTeamB(GlobalClass.getScoreTeamB() - 1);
            updateScoreDisplay();
        }
    }

    public void GameOver(View v) {
        if (GlobalClass.getScoreTeamB() >= 21 || GlobalClass.getScoreTeamA() >= 21) {
            String winningTeam = (GlobalClass.getScoreTeamA() > GlobalClass.getScoreTeamB()) ? "TeamA" : "TeamB";
            String message = winningTeam + " has won!";

            // Create an AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(message)
                    .setTitle("Game Over")
                    .setPositiveButton("End Game", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Redirect to the main page or perform any other action
                            Intent intent = new Intent(GamePage.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Close the current activity
                        }
                    })
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Show the "End Game" button at the bottom of the page
                            Button endGameButton = findViewById(R.id.endGameButton);
                            endGameButton.setVisibility(View.VISIBLE);
                            // Dismiss the dialog
                            dialog.dismiss();
                        }
                    });
            // Show the AlertDialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    public void endGame(View v) {
        // Implement the logic for the "End Game" button
        // For example, redirect to the main page or perform any other action
        Intent intent = new Intent(GamePage.this, StartUpPage.class);
        startActivity(intent);
        finish(); // Close the current activity
    }

    public void TeamA(View v)
    {
        Intent i = new Intent(this, TeamA.class);
        startActivity(i);
    }

    public void TeamB(View v)
    {
        Intent i = new Intent(this, TeamB.class);
        startActivity(i);
    }


    public void CreatePDFButton(View v) {
        // Create PDF using iText
        PDF.createPDF(this, true);
        Toast.makeText(this, "Game Saved. PDF created", Toast.LENGTH_SHORT).show();

    }




}
