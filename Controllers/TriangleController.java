/* This class is responsible for all functions inside of the
   Triangle tab. Calculates perimeter and area, offers to reset
   fields, and gives the user a help button if needed. The program
   will draw the shape according to whichever tab is selected.

   Created By: Daron Adkins and Hunter Caughlin   Turn-in Date: Nov. 30th, 2016 */

package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;

import java.io.IOException;

public class TriangleController {

    @FXML
    private VBox trianglePane;		  //"Vertical Box" that the triangle pane will be placed in.
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField triBase;        //textfield for a triangle's base.
    @FXML
    private TextField triHeight;      //textfield for a triangle's height.
    @FXML
    private TextField triSide1;       //textfield for a triangle's first side.
    @FXML
    private TextField triSide2;       //textfield for a triangle's second side.

    //================================================ TRIANGLE FUNCTIONS =================================================//

    public void triPListener() 												//Button listener for a triangle's perimeter.
    {
        double perimeter; 													//Initialze the perimeter variable.
        String str1 = triBase.getText();									//Get the string for the traingle's base.
        String str2 = triSide1.getText();									//Get the string for the triangles first side.
        String str3 = triSide2.getText();									//Get the string for the triangle's second side.

        try 																//TRY the parsing and arithmetic; if error, CATCH.
        {
            double base = Double.parseDouble(str1); 						//Parse all strings to doubles.
            double side1 = Double.parseDouble(str2);
            double side2 = Double.parseDouble(str3);
            perimeter = (base + side1 + side2); 							//Calculate perimeter.
            periLabel.setText("Perimeter : " +
                    (Math.round(perimeter * 100.0)/100.0) + " units.");		    //Set the perimeter label.

            try {
                drawTriangle();
            } catch (IOException e) {								     	//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e)										//CATCH if the input is not a number, OR left empty.
        {
            if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty())			//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else															//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    public void triAListener() 											   //Button listener for a triangle's area.
    {
        double area; 													   //Initialize the area variable.
        String str1 = triBase.getText();								   //Get the string for the triangle's base.
        String str2 = triHeight.getText();								   //Get the string for the triangle's height.

        try 															   //TRY the parsing and arithmetic; if error, CATCH.
        {
            double base = Double.parseDouble(str1); 					   //Parse all strings to doubles.
            double height = Double.parseDouble(str2);
            area = ((base * height) / 2); 								   //Calculate the area.
            areaLabel.setText("Area : " +
                    (Math.round(area * 100.0)/100.0) + " units.");	           //Set the area label.

            try {
                drawTriangle();										  //Draw the shape.
            } catch (IOException e) {									  //If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 				    				   //CATCH if the input is not a number, OR left empty.
        {
            if(str1.isEmpty() || str2.isEmpty())						   //Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else														   //Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }


    @FXML
    public void drawTriangle() throws IOException {						  //This method will draw a triangle.

        trianglePane.getChildren().clear();								  //Clear the pane.
        Polygon triangle = new Polygon();								  //New polygon for use.

        triangle.getPoints().setAll(									  //Set vertices' locations.
                100d, 100d,
                150d, 50d,
                250d, 150d
        );

        triangle.setStroke(Color.FORESTGREEN);							  //Draw a filled in triangle.
        triangle.setStrokeWidth(4);
        triangle.setStrokeLineCap(StrokeLineCap.ROUND);
        triangle.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        trianglePane.getChildren().addAll(triangle);					  //Add the triangle to the pane.
    }

    //================================================ OTHER FUNCTIONS ===================================================//

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
