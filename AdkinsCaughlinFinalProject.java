/* This class loads the FXML file "Tabs" in which holds our controller FXMLs.
   After loading the FXML file, the scene graph is created in memory. After the title
   and stage have been set, the stage may now be displayed. This will occur when the
   main method begins (line 34).

   Created By: Daron Adkins and Hunter Caughlin   Turn-in Date: Nov. 30th, 2016 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdkinsCaughlinFinalProject extends Application {
    public void start(Stage stage) throws Exception {
        new Alert(Alert.AlertType.INFORMATION, "This program will allow the user to calculate the\n" +          //Welcome message
                "perimeter and/or area of five shapes; A Square, Circle,\n" +
                "Triangle, Trapezoid, or Pentagon. After calculations,\n" +
                "the program will display the shape to the user. Please\n" +
                "click the 'Help' button for any further guidance.").showAndWait();

        //Load the .fxml file!
        Parent parent = FXMLLoader.load(getClass().getResource("Views/Tabs.fxml"));

        //Create the scene graph in memory.
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/style.css");

        //Set the program title.
        stage.setTitle("Perimeter and Area Calculator");

        //Set the scene.
        stage.setScene(scene);

        //Show the stage.
        stage.show();
    }

    //Main method
    public static void main(String[] args) {
        launch(args);
    }
}