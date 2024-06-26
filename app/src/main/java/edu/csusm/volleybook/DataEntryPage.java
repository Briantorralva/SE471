package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class DataEntryPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_page);
    }

    public void StartGame (View v){
        //Store the player names in the Global Class
        SetGlobalClassVariables();

        //Goes to GamePage
        Intent i = new Intent(this, GamePage.class);
        startActivity(i);
    }

    public void SetGlobalClassVariables()
    {
        // Retrieve player names from EditText fields
        EditText box1 = findViewById(R.id.Box1);
        EditText box2 = findViewById(R.id.Box2);
        EditText box3 = findViewById(R.id.Box3);
        EditText box4 = findViewById(R.id.Box4);
        EditText box5 = findViewById(R.id.Box5);
        EditText box6 = findViewById(R.id.Box6);

        // Retrieve player names for Team A
        List<String> teamAPlayerNames = new ArrayList<>();
        teamAPlayerNames.add(box1.getText().toString());
        teamAPlayerNames.add(box2.getText().toString());
        teamAPlayerNames.add(box3.getText().toString());
        teamAPlayerNames.add(box4.getText().toString());
        teamAPlayerNames.add(box5.getText().toString());
        teamAPlayerNames.add(box6.getText().toString());

        // Set player names for Team A in GlobalClass
        GlobalClass.setActivePlayers_Red(new LinkedList<>(teamAPlayerNames));

        // Retrieve player names for Team B
        EditText boxB1 = findViewById(R.id.BoxB1);
        EditText boxB2 = findViewById(R.id.BoxB2);
        EditText boxB3 = findViewById(R.id.BoxB3);
        EditText boxB4 = findViewById(R.id.BoxB4);
        EditText boxB5 = findViewById(R.id.BoxB5);
        EditText boxB6 = findViewById(R.id.BoxB6);

        List<String> teamBPlayerNames = new ArrayList<>();
        teamBPlayerNames.add(boxB1.getText().toString());
        teamBPlayerNames.add(boxB2.getText().toString());
        teamBPlayerNames.add(boxB3.getText().toString());
        teamBPlayerNames.add(boxB4.getText().toString());
        teamBPlayerNames.add(boxB5.getText().toString());
        teamBPlayerNames.add(boxB6.getText().toString());

        // Set player names for Team B in GlobalClass
        GlobalClass.setActivePlayers_Blue(new LinkedList<>(teamBPlayerNames));
    }
}