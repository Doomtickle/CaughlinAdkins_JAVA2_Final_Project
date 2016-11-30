/* This class is responsible for all functions inside of the
   Pentagon tab. Calculates perimeter and area, offers to reset
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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineCap;

import java.io.IOException;

public class PentagonController {
    @FXML
    private VBox pentagonPane;		  //"Vertical Box" that the pentagon pane will be placed in.
    @FXML
    private Label periLabel;          //Label that displays the perimeter of the shape.
    @FXML
    private Label areaLabel;          //Label that display the area of the shape.
    @FXML
    private TextField pentaSide;      //Textfield for a pentagon's side.

    //================================================= PENTAGON FUNCTIONS ================================================//

    @FXML
    public void pentaPListener() 										//Button listener for a pentagon's perimeter.
    {
        double perimeter;												//Initialze the perimeter variable.
        String str = pentaSide.getText();

        try 															//TRY the parsing and arithmetic; if error, CATCH.
        {
            double side = Double.parseDouble(str);					 	//Parse the string to a double.
            perimeter = (side * 8); 									//Calculate perimeter.
            periLabel.setText("Perimeter : " +
                    (Math.round(perimeter * 100.0)/100.0) + " units.");			//Set the perimeter label.

            try {
                drawPentagon();										//Draw the shape.
            } catch (IOException e) {									//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch (NumberFormatException e) 								//CATCH if the input is not a number, OR left empty.
        {
            if(str.isEmpty())											//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else														//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }


    public void pentaAListener()  									    //Button listener for a pentagon's area.
    {
        double area; 													//Initialize the area variable.
        String str = pentaSide.getText();

        try 															//TRY the parsing and arithmetic; if error, CATCH.
        {
            double side = Double.parseDouble(str); 						//Parse the string to a double.
            area = 5 * ((side * side)/(4*Math.tan(Math.PI/5))); 		//Calculate the area.
            areaLabel.setText("Area : " +
                    (Math.round(area * 100.0)/100.0) + " units.");			//Set the area label.

            try {
                drawPentagon();										//Draw the shape.
            } catch (IOException e) {									//If error, stack trace.
                e.printStackTrace();
            }
        }
        catch (NumberFormatException e) 								//CATCH if the input is not a number, OR left empty.
        {
            if(str.isEmpty())											//Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else														//Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void drawPentagon() throws IOException {						//Method that will draw our shape.

        pentagonPane.getChildren().clear();								//Clear the pane.
        Polygon pentagon = new Polygon();								//Create a new polygon.

        double theta = 2 * Math.PI / 5;									//This will be used to draw sides.

        pentagon.getPoints().setAll(									//Set the points that each line will connect to.
                50*(Math.cos(0)), 20*(Math.sin(0)),
                50*(Math.cos(theta * 1)), 50*(Math.sin(theta * 1)),
                50*(Math.cos(theta * 2)), 50*(Math.sin(theta * 2)),
                50*(Math.cos(theta * 3)), 50*(Math.sin(theta * 3)),
                50*(Math.cos(theta * 4)), 50*(Math.sin(theta * 4))

        );

        pentagon.setStroke(Color.FORESTGREEN);						   //Draw a filled in pentagon.
        pentagon.setStrokeWidth(4);
        pentagon.setStrokeLineCap(StrokeLineCap.ROUND);
        pentagon.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        pentagonPane.getChildren().addAll(pentagon);				   //Add the pentagon to the pane.
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
