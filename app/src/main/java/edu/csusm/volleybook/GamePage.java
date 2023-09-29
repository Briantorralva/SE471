package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
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