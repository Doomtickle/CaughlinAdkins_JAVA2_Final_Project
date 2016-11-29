package Controllers; /**
 * Created by Doomtickle on 11/29/16.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;

import java.io.IOException;

public class TriangleController {
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private Button resetButton;       //Button to reset all fields.
    @FXML
    private Button helpButton;        //Button for user help.
    @FXML
    private TextField triBase;          //textfield for a triangle's base.
    @FXML
    private TextField triHeight;      //textfield for a triangle's height.
    @FXML
    private TextField triSide1;          //textfield for a triangle's first side.
    @FXML
    private TextField triSide2;          //textfield for a triangle's second side.
    @FXML
    private VBox trianglePane;

    @FXML
    public void triPListener() //Button listener for a triangle's perimeter.
    {
        double perimeter;
        String str1 = triBase.getText();
        String str2 = triSide1.getText();
        String str3 = triSide2.getText();

        try {
            double base = Double.parseDouble(str1);
            double side1 = Double.parseDouble(str2);
            double side2 = Double.parseDouble(str3);
            perimeter = (base + side1 + side2);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
            try {
                drawTriangle(base, side1, side2);
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
    public void triAListener() //Button listener for a triangle's area.
    {
        double area;
        String str1 = triBase.getText();
        String str2 = triHeight.getText();

        try {
            double base = Double.parseDouble(str1);
            double height = Double.parseDouble(str2);
            area = ((base * height) / 2);
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }
    @FXML
    public void drawTriangle(double base, double s2, double s3) throws IOException {

        trianglePane.getChildren().clear();
        Polygon triangle = new Polygon();

        triangle.getPoints().setAll(
                100d, 100d,
                150d, 50d,
                250d, 150d
        );

        triangle.setStroke(Color.FORESTGREEN);
        triangle.setStrokeWidth(4);
        triangle.setStrokeLineCap(StrokeLineCap.ROUND);
        triangle.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));
//        Text baseText = new Text();
//        Text side2Text = new Text();
//        Text side3Text = new Text();
//
//        baseText.setText("Base: " + String.valueOf(base));
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

        trianglePane.getChildren().addAll(triangle);


    }
    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        triBase.setText("");
        triHeight.setText("");
        triSide1.setText("");
        triSide2.setText("");
        periLabel.setText("");
        areaLabel.setText("");
        trianglePane.getChildren().clear();
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
