package game;

import java.io.IOException;
import javafx.scene.media.AudioClip;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static game.MapController.score;
import static game.MapController.level;

public class HomePageController implements Initializable{
    

     public static String gamer_name;

    @FXML
    private MediaView media;
  
    @FXML
    private ImageView logo;
   // Refrence : https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
    public  AudioClip clip1 = new AudioClip(getClass().getResource("/voice/clickSound.mp3").toString());
    public  AudioClip wrong = new AudioClip(getClass().getResource("/voice/error.mp3").toString());

    private MediaPlayer mediaPlayer;
    @FXML
    private TextField playerNameField;
    @FXML
    private PasswordField passwordField;
    private Button start;
    @FXML
    private ImageView close;
    
    
    @FXML
    private ImageView loginButton;
    @FXML
    private ImageView signUpButton;
    @FXML
    private AnchorPane anchor;
    
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
}
    
    @FXML public void exitApp(MouseEvent e){
        clip1.play();
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
    
    public void scaleUp (ImageView b){
        b.setScaleX(b.getScaleX() + 0.1);
        b.setScaleY(b.getScaleY() + 0.1);
     }
     
     public void scaleDown (ImageView b ){
        b.setScaleX(b.getScaleX() - 0.1);
        b.setScaleY(b.getScaleY() - 0.1);
 
     }
     
     public void errorMove(){
      // Refrences: 
//        https://www.youtube.com/watch?v=fPo7zNrFF7U&t=1s
//	https://www.youtube.com/watch?v=-WfyzkDodlI&t=640s
//	https://www.youtube.com/watch?v=W8JrY3Qpf1s&list=PLhs1urmduZ2-4hFJxb2dgfWwcinNqEz0c&index=4
     TranslateTransition r = new TranslateTransition(Duration.millis(1),anchor);
     r.setToX(40);
      TranslateTransition l = new TranslateTransition(Duration.seconds(0.1),anchor);
      l.setToX(-40);
      TranslateTransition m = new TranslateTransition(Duration.millis(1),anchor);
      l.setToX(0);
    SequentialTransition s = new SequentialTransition(r,l,m);
    s.setCycleCount(1);
    s.play();
     }
     
    @FXML
     public void login(MouseEvent e)throws InterruptedException, IOException{
     
         System.out.println("login");
         
       if(!(passwordField.getText().equals("")) && !(playerNameField.getText().equals(""))){
           
           Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            List<username> list =null;
            String queryp="from username";
            Query query =session.createQuery(queryp);
            boolean s = false;
            list =query.list();
             for(username u:list){ 
                 if(playerNameField.getText().equals(u.getUsername())){
                 if(passwordField.getText().equals(u.getPass())){
                   clip1.play();
                    List<score> list2 =null;
                    s= true;
            String queryp2="from score";
            Query query1 =session.createQuery(queryp2);
            list2 =query1.list();
             for(score sc:list2){ 
                 if(playerNameField.getText().equals(sc.getUsername())){
                     score=Integer.parseInt(sc.getScore());
                     level=Integer.parseInt(sc.getLevel());    }
             }
           save_name_in(playerNameField);
           // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("map.fxml"));
       Parent root =(Parent) loader.load();
       MapController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
                 
                 }  
                 }
             }
             
             tx.commit();
           session.close();     
         if (s== false) {
             playerNameField.clear();
             passwordField.clear();
            wrong.play(); 
            errorMove();
            System.out.println("login error");
                 }
       }
       else {
           wrong.play(); 
           errorMove();
       }
     }
     @FXML public void loginEnterMouse(MouseEvent e){
     scaleUp(loginButton);
     }
    @FXML public void loginExitMouse(MouseEvent e){
    scaleDown(loginButton);
    }
    
   @FXML public void signUp(MouseEvent e)throws InterruptedException, IOException{
   
       System.out.println("signup");
       
       
      if(!(passwordField.getText().equals("")) && !(playerNameField.getText().equals(""))){
           Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            username name=new username();
            String n=playerNameField.getText();
            String p=passwordField.getText();
            name.setUsername(n);
            name.setPass(p);
          clip1.play();
          save_name_in(playerNameField);
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("map.fxml"));
       Parent root =(Parent) loader.load();
       MapController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
        session.save(name);
           tx.commit();
           session.close();  
      }
       else {
          wrong.play();
          errorMove();
      }
   }
     @FXML public void signUpEnterMouse(MouseEvent e){
     scaleUp(signUpButton);
     }
    @FXML public void signUpExitMouse(MouseEvent e){
    scaleDown(signUpButton);
    }
    
    public void save_name_in(TextField t){ 
    gamer_name=t.getText();
        System.out.println(gamer_name);
    }
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    
   
}
