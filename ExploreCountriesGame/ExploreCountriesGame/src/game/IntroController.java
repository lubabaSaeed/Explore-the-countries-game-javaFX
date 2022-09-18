
package game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class IntroController implements Initializable{
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    //Refrence: https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
 
    AudioClip a1 = new AudioClip(this.getClass().getResource("/voice/intro.mp3").toString());
    
    private Stage myStage;
    public void setStage(Stage stage) {
    myStage = stage;
}

    
     public void waitSec () throws InterruptedException {
      Thread.sleep(9000);
     }
    
    
    public void s () throws IOException{
      
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("listGames.fxml"));
             Parent root = (Parent) loader.load();
            ListGamesController controller = loader.getController();
            myStage.setScene(new Scene(root));
       System.out.println("error in wait");
         
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        a1.play();
        for(int i=0;i<10;i++){
            System.out.println(i);
            
        }

    }
  

}
