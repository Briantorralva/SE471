package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeamB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_b);
    }
    public void TeamBReturnButton (View v){
        //Return to Game page
        Intent i = new Intent(this,GamePage.class);
        startActivity(i);


    }
}