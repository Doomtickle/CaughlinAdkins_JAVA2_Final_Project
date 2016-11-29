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
            try {
                drawPentagon();
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

    public void pentaAListener()  //Button listener for a pentagon's area.
    {
        double area;
        String str = pentaSide.getText();

        try {
            double side = Double.parseDouble(str);
            area = 5 * ((side * side) / (4 * Math.tan(Math.PI / 5)));
            areaLabel.setText("Area : " + (Math.round(area * 100.0) / 100.0) + " units.");
            try {
                drawPentagon();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more or the required fields has been left blank. Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void drawPentagon() throws IOException {

        pentagonPane.getChildren().clear();
        Polygon pentagon = new Polygon();

        double theta = 2 * Math.PI / 5;
//        for (int i = 0; i < 5; ++i) {
//            double x = Math.cos(theta * i);
//            double y = Math.sin(theta * i);

//            pentagon.getPoints().set(i, x);
//            pentagon.getPoints().set(i, y);
        pentagon.getPoints().setAll(
               50*(Math.cos(0)), 20*(Math.sin(0)),
                50*(Math.cos(theta * 1)), 50*(Math.sin(theta * 1)),
                50*(Math.cos(theta * 2)), 50*(Math.sin(theta * 2)),
                50*(Math.cos(theta * 3)), 50*(Math.sin(theta * 3)),
                50*(Math.cos(theta * 4)), 50*(Math.sin(theta * 4))

            );

        pentagon.setStroke(Color.FORESTGREEN);
        pentagon.setStrokeWidth(4);
        pentagon.setStrokeLineCap(StrokeLineCap.ROUND);
        pentagon.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));
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

        pentagonPane.getChildren().addAll(pentagon);


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
