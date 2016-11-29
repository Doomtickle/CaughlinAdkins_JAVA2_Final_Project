import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import javax.swing.*;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.*;

public class ACFPC {
    @FXML
    private AnchorPane A1;  //AnchorPane
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private Button resetButton;       //Button to reset all fields.
    @FXML
    private Button helpButton;        //Button for user help.

    @FXML
    private TextField tfSquare;       //'tf' stands for textfield. TextField at the top of each column.
    @FXML
    private TextField squareSide1;    //textfield for the first square side.
    @FXML
    private TextField squareSide2;    //textfield for the second square side.
    @FXML
    private Button squarePeri;        //Button for square perimeter.
    @FXML
    private Button squareArea;        //Button for square area.

    @FXML
    private TextField tfCircle;       //Top Circle textfield
    @FXML
    private TextField circRadius;     //textfield for a circle's radius.
    @FXML
    private Button circPeri;          //Button to calculate a circle's perimeter.
    @FXML
    private Button circArea;          //Button to calculate a circle's area.

    @FXML
    private TextField tfTriangle;     //Top Triangle textfield
    @FXML
    private TextField triBase;          //textfield for a triangle's base.
    @FXML
    private TextField triHeight;      //textfield for a triangle's height.
    @FXML
    private TextField triSide1;          //textfield for a triangle's first side.
    @FXML
    private TextField triSide2;          //textfield for a triangle's second side.
    @FXML
    private Button triPeri;              //Button to calculate a triangle's perimeter.
    @FXML
    private Button triArea;              //Button to calculate a triangle's area.

    @FXML
    private TextField tfTrapezoid;    //Top Trapezoid textfield
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
    @FXML
    private Button trapPeri;          //Button to calculate a trapezoid's area.
    @FXML
    private Button trapArea;          //Button to calculate a trapezoid's perimeter.

    @FXML
    private TextField tfPentagon;      //Top Pentagon textField
    @FXML
    private TextField pentaSide;      //Textfield for a pentagon's side.
    @FXML
    private Button pentaPeri;          //Button to calculate a pentagon's perimeter.
    @FXML
    private Button pentaArea;          //Button to calculate a pentagon's area.


    //================================= SQUARE FUNCTIONS ==============================//

    public void squarePListener() //Button listener for a square's perimeter.
    {
        double perimeter;
        String str1 = squareSide1.getText();
        String str2 = squareSide2.getText();

        try {
            double sqSide1 = Double.parseDouble(str1);
            double sqSide2 = Double.parseDouble(str2);
            perimeter = (2 * sqSide1) + (2 * sqSide2);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
            try {
                drawRectanglePerimeter(sqSide1, sqSide2);
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

    //================================= CIRCLE FUNCTIONS ==================================//

    public void circPListener() //Button listener for a circle's perimeter.
    {
        double perimeter;
        final double PI = Math.PI;
        String str = circRadius.getText();

        try {
            double radius = Double.parseDouble(str);
            perimeter = 2 * (PI * radius);
            periLabel.setText("Perimeter : " + (Math.round(perimeter * 100.0) / 100.0) + " units.");
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
        } catch (NumberFormatException e) {
            if (str.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    //================================= TRIANGLE FUNCTIONS =================================//

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
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

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

    //================================= TRAPEZOID FUNCTIONS =================================//

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
        } catch (NumberFormatException e) {
            if (str1.isEmpty() || str2.isEmpty() || str3.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields was left blank.  Please fill in all fields.").showAndWait();
            else
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    //================================= PENTAGON FUNCTIONS =================================//

    public void pentaPListener() //Button listener for a pentagon's perimeter.
    {
        double perimeter;
        String str = pentaSide.getText();

        try {
            double side = Double.parseDouble(str);
            perimeter = (side * 8);
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

    public void resetFields() //Sets the prompt fields back to it's default.
    {
        squareSide1.setText("");
        squareSide2.setText("");
        circRadius.setText("");
        triBase.setText("");
        triHeight.setText("");
        triSide1.setText("");
        triSide2.setText("");
        trapBase1.setText("");
        trapBase2.setText("");
        trapHeight.setText("");
        trapSide1.setText("");
        trapSide2.setText("");
        pentaSide.setText("");

        periLabel.setText("");
        areaLabel.setText("");
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


    @FXML
    public void drawRectanglePerimeter(double s1, double s2) throws IOException {

        if(s1 < 50 || s2 < 50){
            s1 *= 5;
            s2 *= 5;
        }else if(s1 < 25 || s2 < 25){
            s1 *= 10;
            s2 *= 10;
        }
        Rectangle r = new Rectangle();
        r.setX(150);
        r.setY(400);

        r.setWidth(s1);
        r.setHeight(s2);

        A1.getChildren().add(r);

    }

    public void drawCirclePerimeter(double radius) throws IOException {


    }

    public void drawCircleArea(double s1, double s2) throws IOException {


    }

    public void drawTrianglePerimeter(double s1, double s2) throws IOException {


    }

    public void drawTriangleArea(double s1, double s2) throws IOException {


    }

    public void drawTrapezoidPerimeter(double s1, double s2) throws IOException {


    }

    public void drawTrapezoidArea(double s1, double s2) throws IOException {


    }

    public void drawPentagonPerimeter(double s1, double s2) throws IOException {


    }

    public void drawPentagonArea(double s1, double s2) throws IOException {


    }

}