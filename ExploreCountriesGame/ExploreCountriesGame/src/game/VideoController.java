package game;


import static game.MapController.score;
import static game.MapController.level;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import static game.HomePageController.gamer_name;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class VideoController implements Initializable {
    // Refrence :  https://www.youtube.com/watch?v=VDTVeDozcag
    // Refrence : https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    
  public  AudioClip clip1 = new AudioClip(getClass().getResource("/voice/clickSound.mp3").toString());
    @FXML
    private ImageView close;
    
    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
     

    ImageView backButton;
    
    
    private Stage myStage;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Button playButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button pauseButton;
      
    private Country country;
    @FXML
    private Label label_name;
    public void setCountry(Country c) {
     country = c;
     set_landmarks_video(country);
   } 
    
    public void setStage(Stage stage) {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
     System.out.println(label_name.getText()+" vid");
     
   }
    
   
   
   //لكل دولة فيديو بعد لعبة المتاهه يشتغل 
    public void set_landmarks_video(Country ca){
      
        if (ca.getCountryname() == "Saudi Arabia" ){
          String MEDIA_URL1 = "/videos/kabaa.mp4";
          mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL1).toExternalForm()));
           mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
         }
         
        if (ca.getCountryname() == "China" ){
           String MEDIA_URL2 = "/videos/GreatWallofChina.mp4";
           mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL2).toExternalForm()));
            mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
      
         }
         
        if (ca.getCountryname() == "Brazil" ){
          String MEDIA_URL3 = "/videos/IguazuFalls.mp4";
          mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL3).toExternalForm()));
           mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
        }
        if (ca.getCountryname() == "Russia" ){
          String MEDIA_URL4 = "/videos/Kremlin.mp4";
          mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL4).toExternalForm()));
           mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);
        }
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            PauseTransition wait = new PauseTransition(Duration.seconds(2));
            @Override
            public void run() {
                wait.setOnFinished(e -> {
                FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("win1.fxml"));
        Parent root = null;
                try {
                    root = (Parent) loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(VideoController.class.getName()).log(Level.SEVERE, null, ex);
                }
       Win1Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setCountry(country);
       controller.setStage(myStage);
                });
                 wait.play();
//               FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("win1.fxml"));
//        Parent root = null;
//                try {
//                    root = (Parent) loader.load();
//                } catch (IOException ex) {
//                    Logger.getLogger(VideoController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//       Win1Controller controller = loader.getController();
//       myStage.setScene(new Scene(root));
//       controller.setCountry(country);
//       controller.setStage(myStage);
       
            }
        });
        
    }
//     
  
    
     @FXML
     public void exitApp(MouseEvent e){

        System.out.println("you succ go out");
        myStage.close();
        
    }
   @FXML
   public void exitAppEnterMouse(MouseEvent e){
        System.out.println("pressed close");
        close.setScaleX(close.getScaleX() + 0.1);
        close.setScaleY(close.getScaleY() + 0.1);
        
    }
    
    @FXML
    public void exitAppExitMouse(MouseEvent e){
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
     
    @FXML public void backEnterMouse(MouseEvent e){
         System.out.println("Scale");
       
    }
    @FXML public void backExiteMouse(MouseEvent e)  {
        System.out.println("Scale");  
    }
     @FXML 
     public void playEnterMouse(MouseEvent e){
     System.out.println("playEnter");
     playButton.setScaleX(playButton.getScaleX()+0.1);
     playButton.setScaleY(playButton.getScaleY()+0.1);
     
     }
    @FXML 
    public void playExitMouse(MouseEvent e){
    System.out.println("playExit");
     playButton.setScaleX(playButton.getScaleX()-0.1);
     playButton.setScaleY(playButton.getScaleY()-0.1);
    
    }
    @FXML
    public void resetExitMouse(MouseEvent event) {
     System.out.println("resetExit");
     resetButton.setScaleX(resetButton.getScaleX()-0.1);
     resetButton.setScaleY(resetButton.getScaleY()-0.1);
    }

    @FXML
    public void resetEnterMouse(MouseEvent event) {
     System.out.println("resetEnter");
     resetButton.setScaleX(resetButton.getScaleX()+0.1);
     resetButton.setScaleY(resetButton.getScaleY()+0.1);
    }

    @FXML
    public void pauseExitMouse(MouseEvent event) {
     System.out.println("pauseExit");
     pauseButton.setScaleX(pauseButton.getScaleX()-0.1);
     pauseButton.setScaleY(pauseButton.getScaleY()-0.1);
    }

    @FXML
    public void pauseEnterMouse(MouseEvent event) {
     System.out.println("pauseEnter");
     pauseButton.setScaleX(pauseButton.getScaleX()+0.1);
     pauseButton.setScaleY(pauseButton.getScaleY()+0.1);
    }

   
    @FXML
    public void back(MouseEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("win1.fxml"));
       Parent root =(Parent) loader.load();
       Win1Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
       controller.setCountry(country);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void playMedia(ActionEvent event) {
        clip1.play();
    mediaPlayer.play();
    }

    @FXML
    private void resetMedia(ActionEvent event) {
       if( mediaPlayer.getStatus() != MediaPlayer.Status.READY){
            clip1.play();
        mediaPlayer.seek(Duration.seconds(0.0));
       }

    }

    @FXML
    private void pauseMedia(ActionEvent event) {
         clip1.play();
        mediaPlayer.pause();
    }
    //Back in video controoler
@FXML 
       public void backButtonClickMouse(MouseEvent e) throws IOException{//يروح على شاشه الفوز بعد ما خلص من المتاهه والفيديو

        clip1.play();
        mediaPlayer.stop();
          FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("win1.fxml"));
       Parent root =(Parent) loader.load();
       Win1Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setCountry(country);
        controller.setStage(myStage);
       
   }  

  
   

}