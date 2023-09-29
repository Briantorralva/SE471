package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_a);
    }

    public void TeamAReturnButton (View v){
        //Return to game_page
        Intent i = new Intent(this,GamePage.class);
        startActivity(i);


    }
}