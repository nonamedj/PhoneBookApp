
package phonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhoneBook extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Telefonkönyv");
        stage.setWidth(600);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

  
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
