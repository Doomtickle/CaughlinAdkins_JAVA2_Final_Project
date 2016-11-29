package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;

import java.io.IOException;

public class SquareController {
    @FXML
    private VBox rectanglePane;
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private Button resetButton;       //Button to reset all fields.
    @FXML
    private Button helpButton;        //Button for user help.
    @FXML
    private TextField squareSide1;    //textfield for the first square side.
    @FXML
    private TextField squareSide2;    //textfield for the second square side.
    @FXML
    private Button squarePeri;        //Button for square perimeter.
    @FXML
    private Button squareArea;        //Button for square area.

    //================================= SQUARE FUNCTIONS ==============================//


    @FXML
    void squarePListener() throws IOException //Button listener for a square's perimeter.
    {
        double perimeter;
        String str1 = squareSide1.getText();
        String str2 = squareSide2.getText();

        try {
            double sqSide1 = Double.parseDouble(str1);
            double sqSide2 = Double.parseDouble(str2);
            perimeter = (2 * sqSide1) + (2 * sqSide2);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
            squareSide1.setText("");
            squareSide2.setText("");
            try {
                drawRectangle(sqSide1, sqSide2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    public void squareAListener() //Button listener for a square's area.
    {
        double area;
        String str1 = squareSide1.getText();
        String str2 = squareSide2.getText();

        try {
            double sqSide1 = Double.parseDouble(str1);
            double sqSide2 = Double.parseDouble(str2);
            area = (sqSide1 * sqSide2);
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }
    @FXML
    public void drawRectangle(double s1, double s2) throws IOException {

        rectanglePane.getChildren().clear();

        Rectangle r = new Rectangle();
        double side1 = (s1 < 25) ? (s1 * 10) : s1;
        double side2 = (s2 < 25) ? (s2 * 10) : s2;

        r.setWidth(side1);
        r.setHeight(side2);
        r.setStroke(Color.FORESTGREEN);
        r.setStrokeWidth(4);
        r.setStrokeLineCap(StrokeLineCap.ROUND);
        r.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        Text width = new Text();
        Text height = new Text();

        width.setText("Width: " + String.valueOf(s1));
        width.setX(200.0);
        width.setY(400.0);

        height.setText("Height: " + String.valueOf(s2));
        height.setX(300.0);
        height.setY(400.0);


        rectanglePane.getChildren().addAll(width, height, r);


    }
    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        squareSide1.setText("");
        squareSide2.setText("");
        periLabel.setText("");
        areaLabel.setText("");
        rectanglePane.getChildren().clear();
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
