package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePage extends AppCompatActivity {

    public int count = 0;
    private TextView valueTextView;
    private Button incrementButton;
    private Button decrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        valueTextView = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.plus_button1);

        incrementButton.setOnClickListener(v -> {
            count++;
            valueTextView.setText(String.valueOf(count));
        });

        valueTextView = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.plus_button2);

        incrementButton.setOnClickListener(v -> {
                count++;
            valueTextView.setText(String.valueOf(count));
        });

        valueTextView = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.minus_button1);

        incrementButton.setOnClickListener(v -> {
            if(count > 0)
                count--;
            valueTextView.setText(String.valueOf(count));
        });

        valueTextView = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.minus_button2);

        incrementButton.setOnClickListener(v -> {
            if(count > 0)
                count--;
            valueTextView.setText(String.valueOf(count));
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



}