/* This class is responsible for all functions inside of the
   Square or Rectangle tab. Calculates perimeter and area, offers to reset
   fields, and gives the user a help button if needed. The program
   will draw the shape according to whichever tab is selected.

   Created By: Daron Adkins and Hunter Caughlin   Turn-in Date: Nov. 30th, 2016 */

package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

import java.io.IOException;

public class SquareController {
    @FXML
    private VBox rectanglePane;		  //"Vertical Box" that our rectangle pane will be placed in.
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField squareSide1;    //textfield for the first square side.
    @FXML
    private TextField squareSide2;    //textfield for the second square side.

    //============================================ SQUARE FUNCTIONS =======================================//

    @FXML
    public void squarePListener() 											//Button listener for a square's perimeter.
    {
        double perimeter;						       					 	//Initialze the perimeter variable.
        String str1 = squareSide1.getText();	       						//Get the string for the first side.
        String str2 = squareSide2.getText();   								//Get the string for the second side.

        try  																//TRY the parsing and arithmetic; if error, CATCH.
        {
            double sqSide1 = Double.parseDouble(str1);  					//Parse all strings to doubles.
            double sqSide2 = Double.parseDouble(str2);
            perimeter = (2 * sqSide1) + (2 * sqSide2);  					//Calculate perimeter.
            periLabel.setText("Perimeter : " +
                    (Math.round(perimeter * 100.0)/100.0) + " units.");			//Set perimeter label.

            try {
                drawRectangle(sqSide1, sqSide2);
            } catch (IOException e) {										//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 										//CATCH if the input is not a number, OR left empty.
        {
            if(str1.isEmpty() || str2.isEmpty())        					//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else															//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void squareAListener() 											//Button listener for a square's area.
    {
        double area;														//Initialize the area variable.
        String str1 = squareSide1.getText();    							//Get the string for the first side.
        String str2 = squareSide2.getText();								//Get the string for the second side

        try 																//TRY the parsing and arithmetic; if error, CATCH.
        {
            double sqSide1 = Double.parseDouble(str1);						//Parse all strings to doubles.
            double sqSide2 = Double.parseDouble(str2);
            area = (sqSide1 * sqSide2); 									//Calculate the area.
            areaLabel.setText("Area : " +
                    (Math.round(area * 100.0)/100.0) + " units.");				//Set the area label.

            try {
                drawRectangle(sqSide1, sqSide2);											//Draw the shape.
            } catch (IOException e) {										//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 										//CATCH if the input is not a number, OR left empty.
        {
            if(str1.isEmpty() || str2.isEmpty())        					//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else															//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void drawRectangle(double s1, double s2) throws IOException {    //Draws a rectangle.

        rectanglePane.getChildren().clear();								//Clear the pane.

        Rectangle r = new Rectangle();										//New rectangle.
        double side1 = (s1 < 25) ? (s1 * 10) : s1;							//Determine our draw length.
        double side2 = (s2 < 25) ? (s2 * 10) : s2;

        r.setWidth(side1);													//Set width and height.
        r.setHeight(side2);
        r.setStroke(Color.FORESTGREEN);										//Draw a filled in square or rectangle.
        r.setStrokeWidth(4);
        r.setStrokeLineCap(StrokeLineCap.ROUND);
        r.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        rectanglePane.getChildren().addAll(r);								//Add to the pane.
    }

    //==================================== OTHER FUNCTIONS =========================================//

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
