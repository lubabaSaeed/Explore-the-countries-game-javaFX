package game;


import static game.HomePageController.gamer_name;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MapController implements Initializable {
    
    // Audio clips Refrence: https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
    
   @FXML
     Label label_name;
     public  AudioClip clip1; 
    @FXML
    private ImageView saudi;
    @FXML
    private ImageView china;
    @FXML
    private ImageView brazil;
    
    @FXML
    private ImageView russia;
    @FXML
    private ImageView close;
    
    
    public static int score = 0;
    public static int level = 0;
    private Country country;

    
    
    
    @FXML
    private Label scoreLabel ;
    @FXML
    private Label levelLabel;
    @FXML
    private ImageView chinaLock;
    @FXML
    private ImageView russiaLock;
    @FXML
    private ImageView brazilLock;

    
    public void lockVisibility(){
        
       if (score > 3){
             chinaLock.visibleProperty().setValue(false); 
         }  
            if (score > 7){
            brazilLock.visibleProperty().setValue(false);  
            }
       if (score > 11){
            russiaLock.visibleProperty().setValue(false);
       }   
    }
    
    public void scaleUpWithLock(ImageView i , ImageView l){
    
        i.setScaleX(i.getScaleX() + 0.5);
        i.setScaleY(i.getScaleY() + 0.5);
        l.setScaleX(l.getScaleX() + 0.5);
        l.setScaleY(l.getScaleY() + 0.5);
        
        
    }
    public void scaleDownWithLock(ImageView i , ImageView l){
        i.setScaleX(i.getScaleX() - 0.5);
        i.setScaleY(i.getScaleY() - 0.5);
        l.setScaleX(l.getScaleX() - 0.5);
        l.setScaleY(l.getScaleY() - 0.5);
    }
    
     // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
     private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
     lockVisibility();
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
     System.out.println(label_name.getText()+" map");
 
    }
     
     
     
     public void scaleUpFlag (ImageView i){

        i.setScaleX(i.getScaleX() + 0.5);
        i.setScaleY(i.getScaleY() + 0.5);
     }
     
     public void scaleDownFlag (ImageView i ){
        
        i.setScaleX(i.getScaleX() - 0.5);
        i.setScaleY(i.getScaleY() - 0.5);
     }
   // Rerfrence:  https://youtu.be/ISEtiXCkESYv=VDTVeDozcag​
     RotateTransition rotate;
     public void rotate (ImageView i ){ 
       rotate= new RotateTransition(Duration.millis(50));
        rotate.setNode(i);
        rotate.setByAngle(15);
        rotate.setCycleCount(16);
        rotate.setAutoReverse(true);
        rotate.play();
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
    
    @FXML public void startGameSaudi(MouseEvent e)throws InterruptedException, IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("listGames.fxml"));
       Parent root =(Parent) loader.load();
       ListGamesController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
       country =  new Country("Saudi Arabia","/image/styleSaudi.css","/image/saudiFlagre.png","");
       controller.setCountry(country);
          
    }
    @FXML public void startGamePreSaudi(MouseEvent e)throws InterruptedException, IOException{
        clip1 = new AudioClip(getClass().getResource("/voice/SaudiArabia.mp3").toString());//الكود الصح بس تسجيله ما يشتغل بشوف حل واعدله 
        clip1.play();
        scaleUpFlag(saudi);
        
        
        
    }
    @FXML public void startGameRelSaudi(MouseEvent e) throws InterruptedException, IOException {
         scaleDownFlag(saudi);
    }
    @FXML public void startGameChina(MouseEvent e)throws InterruptedException, IOException{
        if (score > 3){
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("listGames.fxml"));
       Parent root =(Parent) loader.load();
       ListGamesController controller = loader.getController();
       myStage.setScene(new Scene(root));
        controller.setStage(myStage);
       country =  new Country("China","/image/styleChina.css","/image/chinaFlagre.png","");
       controller.setCountry(country);// ** this method in puzzleController
        }
        else {
         rotate (chinaLock )  ; 
        }// wrong sound
    }
    @FXML public void startGamePreChina(MouseEvent e)throws InterruptedException, IOException{
         clip1 = new AudioClip(getClass().getResource("/voice/China.mp3").toString());//الكود الصح بس تسجيله ما يشتغل بشوف حل واعدله 
         if (score > 3){
        clip1.play();
        scaleUpFlag(china);
         }
         else {
         scaleUpWithLock(china , chinaLock);
         }
        
        
    }
    @FXML public void startGameRelChina(MouseEvent e) throws InterruptedException, IOException {
        if (score > 3){
        scaleDownFlag(china);
        }
        else {
         scaleDownWithLock(china , chinaLock);
         
         }
         
    }
    @FXML public void startGameBrazil(MouseEvent e)throws InterruptedException, IOException{

        if (score > 7){
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("listGames.fxml"));
       Parent root =(Parent) loader.load();
        ListGamesController controller = loader.getController();
       myStage.setScene(new Scene(root));
       country =  new Country("Brazil","/image/styleBrazil.css","/image/brazilFlagre.png","");
        controller.setStage(myStage);
       controller.setCountry(country);
      }
        else{ rotate (brazilLock )  ; 
    }}
    @FXML public void startGamePreBrazil(MouseEvent e)throws InterruptedException, IOException{
        if (score > 7){
         clip1 = new AudioClip(getClass().getResource("/voice/Brazill.mp3").toString());//الكود الصح بس تسجيله ما يشتغل بشوف حل واعدله 
        clip1.play();
         scaleUpFlag(brazil);
        }
        else {
         scaleUpWithLock(brazil , brazilLock);
          

         }
        
    }
    @FXML public void startGameRelBrazil(MouseEvent e) throws InterruptedException, IOException {
        if (score > 7){
         scaleDownFlag(brazil);
        }
        else {
         scaleDownWithLock(brazil , brazilLock);
        
         }
    }
    
    @FXML public void startGameRussia(MouseEvent e)throws InterruptedException, IOException{
        if (score > 11){
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("listGames.fxml"));
       Parent root =(Parent) loader.load();
       ListGamesController controller = loader.getController();
       myStage.setScene(new Scene(root));
        controller.setStage(myStage);
       country =  new Country("Russia","/image/styleRussia.css","/image/russiaFlagb.png","");
       controller.setCountry(country);// ** this method in puzzleController
       
        }
        else{   rotate (russiaLock )  ; }
    }
    @FXML public void startGamePreRussia(MouseEvent e)throws InterruptedException, IOException{
         clip1 = new AudioClip(getClass().getResource("/voice/Russia.mp3").toString());//الكود الصح بس تسجيله ما يشتغل بشوف حل واعدله 
         if (score > 11){
        clip1.play();
        scaleUpFlag(russia);
         }
         else {
         scaleUpWithLock(russia , russiaLock);
               

         }
        
        
    }
    @FXML public void startGameRelRussia(MouseEvent e) throws InterruptedException, IOException {
        if (score > 11){
        scaleDownFlag(russia);
        }
         else {
         scaleDownWithLock(russia , russiaLock);
         
         }
         
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    
}
