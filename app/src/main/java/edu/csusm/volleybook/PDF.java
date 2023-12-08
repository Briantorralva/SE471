package edu.csusm.volleybook;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PDF {
    public static void createPDF(Context context, boolean gameEnded) {
        Document document = new Document();

        try {
            // Creates a folder to store the pdf
            String path = context.getFilesDir().getAbsolutePath() + "/volleybook/";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Filename
            String fileName = "volleybook_game_summary.pdf";
            File file = new File(dir, fileName);

            // Writes into the pdf
            PdfWriter.getInstance(document, new FileOutputStream(file));

            // Opens the document
            document.open();

            // Contents
            if (!gameEnded) {
                // Display player grids when the game is ongoing
                addTeamDataToPDF(document, "Team A", GlobalClass.getActivePlayers_Blue(), GlobalClass.getScoreTeamA());
                addTeamDataToPDF(document, "Team B", GlobalClass.getActivePlayers_Red(), GlobalClass.getScoreTeamB());
            } else {
                // Display initial player grids (0-0 score) and final player grids when the game ends
                addTeamDataToPDF(document, "Team A", GlobalClass.getActivePlayers_Blue(), 0);
                addTeamDataToPDF(document, "Team B", GlobalClass.getActivePlayers_Red(), 0);

                //separator
                document.add(new Paragraph("\n"));

                // Display final player grids with the end-game score
                addTeamDataToPDF(document, "Team A (End Game)", GlobalClass.getActivePlayers_Blue(), GlobalClass.getScoreTeamA());
                addTeamDataToPDF(document, "Team B (End Game)", GlobalClass.getActivePlayers_Red(), GlobalClass.getScoreTeamB());
            }

            // Close the document
            document.close();

            // Message to prove pdf was created and saved to
            Toast.makeText(context, "PDF saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            // If it does not work, it will throw an error
        }

    }

    private static void addTeamDataToPDF(Document document, String teamName, LinkedList<String> playerNames,int currentScore) throws IOException, DocumentException {
        // Add team name to the PDF
        document.add(new Paragraph("Team: " + teamName));

        // Create a table with 3 columns
        PdfPTable table = new PdfPTable(3);

        // Add players to the table
        for (String playerName : playerNames) {
            PdfPCell cell = new PdfPCell(new Paragraph(playerName));
            cell.setBorderWidth(1f);  // Set cell border width
            cell.setPadding(8);  // Set cell padding
            table.addCell(cell);
        }

        // Add the table to the document
        document.add(table);

        // Add a blank line to separate teams
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Current Score: " + currentScore + "\n\n"));





    }
}
