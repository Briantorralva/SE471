package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamePage extends AppCompatActivity {

    private int count = 0;
    private TextView valueTextView;
    private Button incrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);


        valueTextView = findViewById(R.id.scoreA);
        incrementButton = findViewById(R.id.plus_button1);

        incrementButton.setOnClickListener(v -> {
            // You can't change the value of 'count' as it's declared as final
            count++; // This will result in a compilation error

            // You can use 'count' in your logic
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