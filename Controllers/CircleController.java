/* This class is responsible for all functions inside of the
   Circle tab. Calculates perimeter and area, offers to reset
   fields, and gives the user a help button if needed. The program
   will draw the shape according to whichever tab is selected.

   Created By: Daron Adkins and Hunter Caughlin   Turn-in Date: Nov. 30th, 2016 */

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
    private VBox circlePane;		  //"Vertical Box" in which the circle pane is placed.
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField circRadius;     //textfield for a circle's radius.

    @FXML
    public void circPListener() 											//Button listener for a circle's perimeter.
    {
        double perimeter; 													//Initialize the perimeter variable.
        final double PI = Math.PI;											//Initialize a PI variable.
        String str = circRadius.getText();									//Get the string for the circle's radius.

        try 																//TRY the parsing and arithmetic; if error, CATCH.
        {
            double radius = Double.parseDouble(str); 						//Parse the string to a double.
            perimeter = 2 * (PI * radius); 									//Calculate perimeter.
            periLabel.setText("Perimeter : " +
                    (Math.round(perimeter * 100.0)/100.0) + " units.");			//Set perimeter label.

            try {
                drawCircle(radius);											//Draw the shape.
            } catch (IOException e) {										//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch (NumberFormatException e) 									//CATCH if the input is not a number, OR left empty.
        {
            if(str.isEmpty())												//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else															//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void circAListener() 											//Button listener for a circle's area.
    {
        double area; 														//Initialize the area variable.
        final double PI = Math.PI;											//Initialize a PI variable.
        String str = circRadius.getText();									//Get the string for the circle's radius.

        try 																//TRY the parsing and arithmetic; if error, CATCH.
        {
            double radius = Double.parseDouble(str); 						//Parse the string to a double.
            area = (PI * radius * radius); 									//Calculate the area.
            areaLabel.setText("Area : " +
                    (Math.round(area * 100.0)/100.0) + " units.");			    //Set the area label.

            try {
                drawCircle(radius);											//Draw the shape.
            } catch (IOException e) {										//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 										//CATCH if the input is not a number, OR left empty.
        {
            if(str.isEmpty())												//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else															//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void drawCircle(double radius) throws IOException {

        circlePane.getChildren().clear();						//Clear the pane.

        double drawRadius = (radius < 75) ? radius*3 : radius;  //Calculate needed radius to draw with.

        Circle circle = new Circle();							//New shape.
        circle.setCenterX(10.0f);								//Set the center point.
        circle.setCenterY(10.0f);
        circle.setRadius(drawRadius);							//Set the radius using drawRadius
        circle.setStroke(Color.FORESTGREEN);					//Draw a filled in circle.
        circle.setStrokeWidth(4);
        circle.setStrokeLineCap(StrokeLineCap.ROUND);
        circle.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        Text radiusText = new Text();								//Create a text holder.

        radiusText.setText("Radius: " + String.valueOf(radius));	//Set the string using the value of our radius.
        radiusText.setX(200.0);										//Placement
        radiusText.setY(400.0);										//Placement

        circlePane.getChildren().addAll(radiusText, circle);		//Add the elements to the pane.
        circlePane.setAlignment(Pos.CENTER_LEFT);				//Position the pane.

    }

    //==================================== OTHER FUNCTIONS =========================================//

    @FXML
    public void resetFields() //Sets the prompt fields back to it's default.
    {
        circRadius.setText("");
        periLabel.setText("");
        areaLabel.setText("");
        circlePane.getChildren().clear(); //Clear the drawing pane as well.
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
