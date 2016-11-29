import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ACFP extends Application {
    public void start(Stage stage) throws Exception {
        //Load the .fxml file!
        Parent parent = FXMLLoader.load(getClass().getResource("Views/Tabs.fxml"));

        //Create the scene graph in memory.
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/style.css");

        stage.setTitle("Perimeter and Area Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}