package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GamePage extends AppCompatActivity {

    public int countA = 0;
    public int countB = 0;
    private TextView valueTextViewA;
    private TextView valueTextViewB;
    private Button incrementButton;
    private Button decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        valueTextViewA = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.plus_button1);

        incrementButton.setOnClickListener(v -> {
            countA++;
            valueTextViewA.setText(String.valueOf(countA));
        });

        valueTextViewB = findViewById(R.id.scoreB);
        incrementButton = findViewById(R.id.plus_button2);

        incrementButton.setOnClickListener(v -> {
                countB++;
            valueTextViewB.setText(String.valueOf(countB));
        });

        valueTextViewA = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.minus_button1);

        incrementButton.setOnClickListener(v -> {
            if(countA > 0)
                countA--;
            valueTextViewA.setText(String.valueOf(countA));
        });

        valueTextViewB = findViewById(R.id.scoreB);
        incrementButton = findViewById(R.id.minus_button2);

        incrementButton.setOnClickListener(v -> {
            if(countB > 0)
                countB--;
            valueTextViewB.setText(String.valueOf(countB));
        });

    }

    public void TeamA (View v){
        //launch Team A page
        Intent i = new Intent(this,TeamA.class);
        startActivity(i);


    }

    public void TeamB (View V){
        //Launch Team B page
        Intent i = new Intent (this,TeamB.class);
        startActivity(i);
    }

    public void CreatePDFButton (View v){
        //create PDF using iText
        TeamA teamAInstance = new TeamA();
        TeamB teamBInstance = new TeamB();

        //gets the linked list for both teams
        PlayerLinkedList teamAList = TeamA.getPlayerLinkedList();
        PlayerLinkedList teamBList = TeamB.getPlayerLinkedListB();

        // Call the createPDF method to generate the PDF
        PDF.createPDF(teamAList, teamBList, this);
        Toast.makeText(this, "Game Saved. PDF created", Toast.LENGTH_SHORT).show();

    }



}