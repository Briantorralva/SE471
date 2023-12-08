package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_page);
    }

    public void NewGame (View v){
        //Goes to GamePage
        Intent i = new Intent(this, DataEntryPage.class);
        startActivity(i);
    }

    public void showRules(View view) {

        Intent intent = new Intent(this, PDF_Viewer.class);
        startActivity(intent);
    }

    public void CloseApplication(View view)
    {
        finish();
    }
}