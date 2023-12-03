package edu.csusm.volleybook;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDF {
    public static void createPDF(PlayerLinkedList teamA, PlayerLinkedList teamB, Context context) {
        Document document = new Document();

        try {
            // Creates folder to store the pdf
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
            addTeamDataToPDF(document, "Team A", teamA);
            addTeamDataToPDF(document, "Team B", teamB);

            // Close the document
            document.close();

            // Message to prove pdf was created and saved to
            Toast.makeText(context, "PDF saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            // If it does not work, it will throw error
        }
    }



    private static void addTeamDataToPDF(Document document, String teamName, PlayerLinkedList team) throws IOException, DocumentException {
        // Add team name to the PDF
        document.add(new Paragraph("Team: " + teamName));

        // Add players names to the PDF
        PlayerLinkedList.Player current = team.head;
        while (current != null) {
            document.add(new Paragraph("Player Name: " + current.getPlayerName()));
            current = current.next;
        }

        // Add a blank line to separate teams
        document.add(new Paragraph("\n"));
    }
}
