
package game;



import static game.HomePageController.gamer_name;
import static game.MapController.score;
import static game.MapController.level;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
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
import javafx.util.Duration;

public class WinGamesController implements Initializable {
    
    
    ImageView backToMapButton;
    @FXML private ImageView close;
    
     private Stage myStage;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star1;
    // Refrence : https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
    public  AudioClip congratulations = new AudioClip(getClass().getResource("/voice/congratulations.mp3").toString());
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
    
    public void scaleUp (ImageView i ){

        i.setScaleX(i.getScaleX() + 0.1);
        i.setScaleY(i.getScaleY() + 0.1);
     }
     
     public void scaleDown (ImageView i ){

        i.setScaleX(i.getScaleX() - 0.1);
        i.setScaleY(i.getScaleY() - 0.1);
     }
     
    @FXML
     public void backtoMapEnterMouse(MouseEvent e){
        scaleUp(backButton); 
    }
    @FXML
     public void backtoMapExiteMouse(MouseEvent e)  {
        scaleDown(backButton);    
    }
     
    @FXML
    public void backtoMap(MouseEvent event) throws IOException {
        clip1.play();
        FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("map.fxml"));
        Parent root =(Parent) loader.load();
       MapController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);

        
    }
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        congratulations.play();
        // Refrences: 
        //https://www.youtube.com/watch?v=fPo7zNrFF7U&t=1s
        //https://www.youtube.com/watch?v=-WfyzkDodlI&t=640s
       //https://www.youtube.com/watch?v=W8JrY3Qpf1s&list=PLhs1urmduZ2-4hFJxb2dgfWwcinNqEz0c&index=4
        ScaleTransition star1transition1 = new ScaleTransition(Duration.seconds(1),star1);
        star1transition1.setToX(1.2);
        star1transition1.setToY(1.2);
        ScaleTransition star1transition2 = new ScaleTransition(Duration.seconds(1),star1);
        star1transition2.setToX(1);
        star1transition2.setToY(1);
        SequentialTransition s1 = new SequentialTransition(star1transition1,star1transition2);
        s1.setCycleCount(15);
        s1.play();
        
        
        ScaleTransition star2transition1 = new ScaleTransition(Duration.seconds(1),star2);
        star2transition1.setToX(1.2);
        star2transition1.setToY(1.2);
        ScaleTransition star2transition2 = new ScaleTransition(Duration.seconds(1),star2);
        star2transition2.setToX(1);
        star2transition2.setToY(1);
        SequentialTransition s2 = new SequentialTransition(star2transition1,star2transition2);
        s2.setCycleCount(15);
        s2.play();
        
        
        ScaleTransition star3transition1 = new ScaleTransition(Duration.seconds(1),star3);
        star3transition1.setToX(1.2);
        star3transition1.setToY(1.2);
        ScaleTransition star3transition2 = new ScaleTransition(Duration.seconds(1),star3);
        star3transition2.setToX(1);
        star3transition2.setToY(1);
        SequentialTransition s3 = new SequentialTransition(star3transition1,star3transition2);
        s3.setCycleCount(15);
        s3.play();
    }    

    
}
