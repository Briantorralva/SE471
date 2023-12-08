package edu.csusm.volleybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PDF_Viewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
    }

    public void ReturnToMain(View view) {
        // Intent to start a new activity or launch a PDF viewer
        // You need to replace YourPdfActivity.class with the actual class you create to display the PDF
        Intent intent = new Intent(this, StartUpPage.class);
        startActivity(intent);
    }
}
