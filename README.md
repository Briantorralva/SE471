# VolleyballApplication
This is a project meant for CS 370 at CSUSM. 

* VolleyBook
VolleyBook, the modern, digital version of the traditional volleyball score sheet. Designed to simplify and accurately maintain records, VolleyBook offers a comprehensive solution for scorekeeping in volleyball games. With features like precise score recording, real-time lineup and position updates, and the ability to generate a PDF of game statistics and scores, VolleyBook ensures accuracy and ease of use. Traditional paper score sheets often lead to inaccuracies, especially during crucial moments like challenging calls, points, and substitutions. VolleyBook addresses and resolves these issues with its intuitive and accessible interface, making it the perfect solution for modernizing your game management and ensuring precise, reliable scorekeeping.  

* Purpose
      * VolleyBook is designed to be an interface to replace the current pen and paper method of recording Volleyball games. It will be developed as an android mobile application for greater accessibility. The app will take in all data points necessary for officiating a volleyball match from the user, including players and score, and once the game concludes, a pdf will be created with the game summary. Volleybook looks to be a reliable and efficient way to simplify and automate refereeing.
     
* Android Native with Android Jetpack:
    * Android Jetpack provides a set of libraries and tools that can help you efficiently build and manage your Android app.
    * You can create separate fragments for the home team and opponent team pages, each containing the necessary UI components for the active lineup, benched players, and player stats.
    * Jetpack's ViewModel can help manage and retain UI-related data, ensuring that the data is available even during configuration changes (e.g., screen rotations).
    * You can use Room (part of Android Jetpack) to manage the database for player data and stats.
      
* Flutter:
    * Flutter is a cross-platform framework that allows you to create natively compiled applications for mobile, web, and desktop from a single codebase.
    * You can create separate screens for the home team and opponent team, each containing the UI components and logic for displaying the active lineup, benched players, and player stats.
    * Flutter's hot reload feature makes it easy to see the changes in real-time as you develop and refine the UI.
    * You can use packages like sqflite or Firebase for database management to handle player data and stats.
      

implementation "androidx.lifecycle:lifecycle-viewmodel:2.3.1"
implementation "androidx.lifecycle:lifecycle-livedata:2.3.1"


Useful Git Commands:
to connect to repo, do git cline "https link"
to commit changes use git commit -m "Message"
to push changes to the repo, use git push
to change/create new branch use git checkout -b newbranch
to just change into different branch use git checkout
to add all changes, like a new file, use git add . 

Lucid Chart for our project, this is widely open to changes: 
https://lucid.app/lucidchart/5c931c40-f9d5-49d5-b083-d130e838ee2e/edit?viewport_loc=878%2C-863%2C4103%2C2091%2C0_0&invitationId=inv_a06efd05-8e3a-4cde-ae68-5c8b82fcc216

