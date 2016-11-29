package Controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;

import java.io.IOException;

/**
 * Created by Doomtickle on 11/29/16.
 */
public class TrapezoidController {

    @FXML
    private VBox trapezoidPane;
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField trapBase1;      //textfield for a trapezoid's first base.
    @FXML
    private TextField trapBase2;      //textfield for a trapezoid's second base.
    @FXML
    private TextField trapHeight;     //textfield for a trapezoid's height.
    @FXML
    private TextField trapSide1;      //textfield for a trapezoid's first side.
    @FXML
    private TextField trapSide2;      //textfield for a trapezoid's second side.

    public void trapPListener() //Button listener for a trapezoid's perimeter.
    {
        double perimeter;
        String str1 = trapBase1.getText();
        String str2 = trapBase2.getText();
        String str3 = trapSide1.getText();
        String str4 = trapSide2.getText();

        try {
            double base1 = Double.parseDouble(str1);
            double base2 = Double.parseDouble(str2);
            double side1 = Double.parseDouble(str3);
            double side2 = Double.parseDouble(str4);
            perimeter = (base1 + base2 + side1 + side2);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
            try {
                drawTrapezoid();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    public void trapAListener()  //Button listener for a trapezoid's area.
    {
        double area;
        String str1 = trapBase1.getText();
        String str2 = trapBase2.getText();
        String str3 = trapHeight.getText();

        try {
            double base1 = Double.parseDouble(str1);
            double base2 = Double.parseDouble(str2);
            double height = Double.parseDouble(str3);
            area = (((base1 + base2) / 2) * height);
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
            try {
                drawTrapezoid();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void drawTrapezoid() throws IOException {

        trapezoidPane.getChildren().clear();
        Polygon trapezoid = new Polygon();

        trapezoid.getPoints().setAll(
                100d, 150d,
                200d, 150d,
                185d, 100d,
                115d, 100d

        );

        trapezoid.setStroke(Color.FORESTGREEN);
        trapezoid.setStrokeWidth(4);
        trapezoid.setStrokeLineCap(StrokeLineCap.ROUND);
        trapezoid.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));
//        Text baseText = new Text();
//        Text side2Text = new Text();
//        Text side3Text = new Text();

//        baseText.setText("Base: " + String.valueOf(base1));
//        baseText.setX(200.0);
//        baseText.setY(400.0);
//
//        side2Text.setText("Side 2: " + String.valueOf(s2));
//        side2Text.setX(300.0);
//        side2Text.setY(400.0);
//
//        side3Text.setText("Side 3: " + String.valueOf(s3));
//        side3Text.setX(300.0);
//        side3Text.setY(400.0);

        trapezoidPane.getChildren().addAll(trapezoid);


    }
    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        trapBase1.setText("");
        trapBase2.setText("");
        trapHeight.setText("");
        trapSide1.setText("");
        trapSide2.setText("");
        periLabel.setText("");
        areaLabel.setText("");
        trapezoidPane.getChildren().clear();
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
