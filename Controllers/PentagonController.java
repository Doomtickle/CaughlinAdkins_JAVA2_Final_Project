package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by Doomtickle on 11/29/16.
 */
public class PentagonController {
    @FXML
    private VBox pentagonPane;
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField pentaSide;      //Textfield for a pentagon's side.
    @FXML

    public void pentaPListener() //Button listener for a pentagon's perimeter.
    {
        double perimeter;
        String str = pentaSide.getText();

        try {
            double side = Double.parseDouble(str);
            perimeter = (side * 5);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    public void pentaAListener()  //Button listener for a pentagon's area.
    {
        double area;
        String str = pentaSide.getText();

        try {
            double side = Double.parseDouble(str);
            area = 5 * ((side * side) / (4 * Math.tan(Math.PI / 5)));
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more or the required fields has been left blank. Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    //================================== OTHER FUNCTIONS =================================//


    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        pentaSide.setText("");
        periLabel.setText("");
        areaLabel.setText("");
        pentagonPane.getChildren().clear();
    }

    public void helpListener() //Displays a help dialog box to the user. Explains how to get perimeter/area.
    {
        new Alert(Alert.AlertType.INFORMATION, "To calculate a....                 Enter the....\n" +
                "-------------------------------------------\n" +
                "Square's Perimeter           Square's Sides\n" +
                "Square's Area                   Square's Sides\n" +
                "Circle's Perimeter             Circle's Radius\n" +
                "Circle's Area                     Circle's Radius\n" +
                "Triangle's Perimeter         Base & 2 Sides\n" +
                "Triangle's Area                 Base & Height\n" +
                "Trapezoid's Perimeter      2 Bases & 2 Sides\n" +
                "Trapezoid's Area              2 Bases & Height\n" +
                "Pentagon's Perimeter       Pentagon's Side\n" +
                "Pentagon's Area               Pentagon's Side").showAndWait();

    }
}
