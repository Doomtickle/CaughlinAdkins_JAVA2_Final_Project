package Controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;

import java.io.IOException;

public class CircleController {

    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField circRadius;     //textfield for a circle's radius.
    @FXML
    private VBox circlePane;

    @FXML
    public void circPListener() //Button listener for a circle's perimeter.
    {
        double perimeter;
        final double PI = Math.PI;
        String str = circRadius.getText();

        try {
            double radius = Double.parseDouble(str);
            perimeter = 2 * (PI * radius);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
            try {
                drawCircle(radius);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    public void circAListener() //Button listener for a circle's area.
    {
        double area;
        final double PI = Math.PI;
        String str = circRadius.getText();

        try {
            double radius = Double.parseDouble(str);
            area = (PI * radius * radius);
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
            try {
                drawCircle(radius);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }
    @FXML
    public void drawCircle(double radius) throws IOException {

        circlePane.getChildren().clear();

        double drawRadius = (radius < 75) ? radius*3 : radius;

        Circle circle = new Circle();
        circle.setCenterX(10.0f);
        circle.setCenterY(10.0f);
        circle.setRadius(drawRadius);
        circle.setStroke(Color.FORESTGREEN);
        circle.setStrokeWidth(4);
        circle.setStrokeLineCap(StrokeLineCap.ROUND);
        circle.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        Text width = new Text();
        Text height = new Text();

        width.setText("Radius: " + String.valueOf(radius));
        width.setX(200.0);
        width.setY(400.0);


        circlePane.getChildren().addAll(width, height, circle);
        circlePane.setAlignment(Pos.CENTER_LEFT);


    }

    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        circRadius.setText("");

        periLabel.setText("");
        areaLabel.setText("");
        circlePane.getChildren().clear();
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
