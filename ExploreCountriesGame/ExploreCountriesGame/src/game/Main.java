package game;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Refrence : https://github.com/arwagh/Code-Wizard-Game
        // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        Parent root = FXMLLoader.load(getClass().getResource("intro.fxml"));
        PauseTransition wait = new PauseTransition(Duration.seconds(5));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
            wait.setOnFinished(e -> {
            stage.hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("homePage.fxml"));
            AnchorPane rootHome = null;
            try {
                rootHome = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scene sceneHome = new Scene(rootHome);
            HomePageController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(sceneHome);
            stage.show();
        });
        wait.play();
      
    }

    public static void main(String[] args) {
        launch(args);
    }

}

