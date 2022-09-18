
package game;


import static game.HomePageController.gamer_name;
import static game.MapController.score;
import static game.MapController.level;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class Win1Controller implements Initializable {
    
    @FXML ImageView backButton;
    @FXML private ImageView close;
    
     private Stage myStage;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    // Refrence : https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
  public  AudioClip yay = new AudioClip(getClass().getResource("/voice/yay.mp3").toString());
    public  AudioClip clip1 = new AudioClip(getClass().getResource("/voice/clickSound.mp3").toString());
    @FXML
    private Label label_name;
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
     public void setStage(Stage stage) {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
   }
     
     @FXML public void exitApp(MouseEvent e){

        System.out.println("you succ go out");
        myStage.close();
        
    }
    @FXML public void exitAppEnterMouse(MouseEvent e){
        System.out.println("pressed close");
        close.setScaleX(close.getScaleX() + 0.1);
        close.setScaleY(close.getScaleY() + 0.1);
        
    }
    
    @FXML public void exitAppExitMouse(MouseEvent e){
        close.setScaleX(close.getScaleX() - 0.1);
        close.setScaleY(close.getScaleY() - 0.1);
    }
    
     private Country country;
     public void setCountry(Country c) {
     country = c;
   }  
    
     public void scaleUp (ImageView i ){

        i.setScaleX(i.getScaleX() + 0.1);
        i.setScaleY(i.getScaleY() + 0.1);
     }
     
     public void scaleDown (ImageView i ){

        i.setScaleX(i.getScaleX() - 0.1);
        i.setScaleY(i.getScaleY() - 0.1);
     }
     
     @FXML public void backEnterMouse(MouseEvent e){
        scaleUp(backButton); 
    }
     @FXML public void backExiteMouse(MouseEvent e)  {
        scaleDown(backButton);    
    }
     
    @FXML
    public void back(MouseEvent event) throws IOException {

          clip1.play();
          FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("listGames.fxml"));
       Parent root =(Parent) loader.load();
       ListGamesController controller = loader.getController();
       myStage.setScene(new Scene(root));
        controller.setStage(myStage);
       controller.setCountry(country);
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       yay.play();
    }    

    
}
