/* This class is responsible for all functions inside of the
   Trapezoid tab. Calculates perimeter and area, offers to reset
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

public class TrapezoidController {

    @FXML
    private VBox trapezoidPane;       //"Vertical Box" that our trapezoid pane will be placed in.
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

    //=================================================== TRAPEZOID FUNCTIONS =============================================//

    @FXML
    public void trapPListener() 										  //Button listener for a trapezoid's perimeter.
    {
        double perimeter; 												  //Initialze the perimeter variable.
        String str1 = trapBase1.getText();							      //Get the string for the trapezoid's first base.
        String str2 = trapBase2.getText();								  //Get the string for the trapezoid's second base.
        String str3 = trapSide1.getText();								  //Get the string for the trapezoid's first side.
        String str4 = trapSide2.getText();								  //Get the string for the trapezoid's second side.

        try 															  //TRY the parsing and arithmetic; if error, CATCH.
        {
            double base1 = Double.parseDouble(str1); 					  //Parse all strings to doubles.
            double base2 = Double.parseDouble(str2);
            double side1 = Double.parseDouble(str3);
            double side2 = Double.parseDouble(str4);
            perimeter = (base1 + base2 + side1 + side2); 				  //Calculate perimeter.
            periLabel.setText("Perimeter : " +
                    (Math.round(perimeter * 100.0)/100.0) + " units.");		  //Set the perimeter label.

            try {
                drawTrapezoid();
            } catch (IOException e) {									  //If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 									  //CATCH if the input is not a number, OR left empty.
        {																  //Exception #1, empty fields.
            if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty())
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else														  //Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }

    @FXML
    public void trapAListener()  										  //Button listener for a trapezoid's area.
    {
        double area; 													  //Initialize the area variable.
        String str1 = trapBase1.getText();								  //Get the string for the trapezoid's first base.
        String str2 = trapBase2.getText();								  //Get the string for the trapezoid's second base.
        String str3 = trapHeight.getText();								  //Get the string for the trapezoid's height.

        try 															  //TRY the parsing and arithmetic; if error, CATCH.
        {
            double base1 = Double.parseDouble(str1);   					  //Parse all strings to doubles.
            double base2 = Double.parseDouble(str2);
            double height = Double.parseDouble(str3);
            area = (((base1 + base2)/2) * height);     					  //Calculate the area.
            areaLabel.setText("Area : " +
                    (Math.round(area * 100.0)/100.0) + " units.");			  //Set the area label.

            try {
                drawTrapezoid();
            } catch (IOException e) {									  //If error, stack trace.
                e.printStackTrace();
            }
        }
        catch(NumberFormatException e) 				   					  //CATCH if the input is not a number, OR left empty.
        {
            if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty())        //Exception #1, empty fields.
                new Alert(Alert.AlertType.ERROR, "One or more of the required fields" +
                        " was left blank.  Please fill in all fields.").showAndWait();
            else														  //Exception #2, non-number entered.
                new Alert(Alert.AlertType.ERROR, "Please only input numbers.").showAndWait();
        }
    }


    @FXML
    public void drawTrapezoid() throws IOException { 					 //This method will draw a trapezoid.

        trapezoidPane.getChildren().clear();						     //Clear the pane.
        Polygon trapezoid = new Polygon();								 //New polygon for use.

        trapezoid.getPoints().setAll(									 //Set all vertices.
                100d, 150d,
                200d, 150d,
                185d, 100d,
                115d, 100d

        );

        trapezoid.setStroke(Color.FORESTGREEN);							//Draw a filled in trapezoid.
        trapezoid.setStrokeWidth(4);
        trapezoid.setStrokeLineCap(StrokeLineCap.ROUND);
        trapezoid.setFill(Color.CORNSILK.deriveColor(0, 1.2, 1, 0.6));

        trapezoidPane.getChildren().addAll(trapezoid);					//Add the shape to the pane.
    }

    //==================================== OTHER FUNCTIONS =========================================//

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
