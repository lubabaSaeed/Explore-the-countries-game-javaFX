
package game;

import static game.HomePageController.gamer_name;
import static game.MapController.score;
import static game.MapController.level;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MemoryCardController implements Initializable {

    Color disableColor = Color.web("0x45463e");
    
    @FXML
    private ImageView close;
    @FXML
    private BorderPane root;
    @FXML
    private GridPane pane;
    
     Image emptyCard11;
     Image emptyCard22;
     Image emptyCard33;
     
     ImageView emptyCard1;
     ImageView emptyCard2;
     ImageView emptyCard3;
     ImageView emptyCard4;
     ImageView emptyCard5;
     ImageView emptyCard6;
    
     
     private Country country;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label label_name;


     public void setCards (Country c){
         country = c;
         if (c.getCountryname() == "Saudi Arabia" ){
             
         emptyCard11 = new Image ("/image/saudiCAMEL.png");
         emptyCard22 = new Image ("/image/saudiTHAWB.png");
         emptyCard33 = new Image ("/image/saudiKABSA.png");
         }
         
         if (c.getCountryname() == "China" ){
             
         emptyCard11 = new Image ("/image/chinaPANDA.png");
         emptyCard22 = new Image ("/image/chinaHANFU.png");
         emptyCard33 = new Image ("/image/chinaNOODLES.png");

         
         }  
         
         if (c.getCountryname() == "Brazil" ){
         
         emptyCard11 = new Image ("/image/brazilToucan.png");
         emptyCard22 = new Image ("/image/brazilBAIANA.png");
         emptyCard33 = new Image ("/image/brazilCOFFEE.png");

         }
         if (c.getCountryname() == "Russia" ){
         
         emptyCard11 = new Image ("/image/russiaBEAR.png");
         emptyCard22 = new Image ("/image/russiaUSHANKA.png");
         emptyCard33 = new Image ("/image/russiaBORSCHT.png");

         }
         
    }
    
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
     System.out.println(label_name.getText()+" memory card");
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
        
         BooleanProperty flip1 = new SimpleBooleanProperty(false);
         BooleanProperty flip2 = new SimpleBooleanProperty(false);
         BooleanProperty flip3 = new SimpleBooleanProperty(false);
        
    
        AtomicInteger card1 = new AtomicInteger(11);
        AtomicInteger card2 = new AtomicInteger(11);
        AtomicInteger card3 = new AtomicInteger(11);
        AtomicInteger card4 = new AtomicInteger(11);
        AtomicInteger card5 = new AtomicInteger(11);
        AtomicInteger card6 = new AtomicInteger(11);

        Image mystryCard = new Image ("/image/mystryCardres.png");
        
        ImageView mystryCard1 = new ImageView(mystryCard);
        ImageView mystryCard2 = new ImageView(mystryCard);
        ImageView mystryCard3 = new ImageView(mystryCard);
        ImageView mystryCard4 = new ImageView(mystryCard);
        ImageView mystryCard5 = new ImageView(mystryCard);
        ImageView mystryCard6 = new ImageView(mystryCard);
        
         public void incrementScore(){
     
        if (country.getCountryname() == "Saudi Arabia"){
        
            if (score==3){
              score++;
              level++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "China"){
        
            if (score==7){
            score++;
            level++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "Brazil"){
        
             if (score==11){
                 score++;
                 level++;
             }
        }
        if (country.getCountryname() == "Russia"){
         if (score==15){
             score++;
             level++;
         }
        }
        
         Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session1.beginTransaction();
            score sco=new score();
             sco.setUsername(gamer_name);
             String scor=String.valueOf(score) ;
             String leve=String.valueOf(level) ;
           List<score> list1 =null;
            String queryp="from score";
            Query query1 =session1.createQuery(queryp);
            list1 =query1.list();
             for(score u:list1){ 
                 if(sco.getUsername().equals(u.getUsername())){
                     u.setScore(scor);
                     u.setLevel(leve);
                  session1.update(u);
            }}
          
            tx1.commit();
           session1.close(); 
    
    }
         
        
        
        public void win () throws IOException{
        incrementScore();  
        if(country.getCountryname() == "Russia"){
            // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        System.out.println("score = "+ score + " level = "+ level);
        FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("winGames.fxml"));
         Parent root =(Parent) loader.load();
         WinGamesController controller = loader.getController();
         myStage.setScene(new Scene(root));
     //  controller.setCountry(country);
         controller.setStage(myStage);  

     }
        else{
       
         System.out.println("score = "+ score + " level = "+ level);
         // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("win2.fxml"));
        Parent root =(Parent) loader.load();
       Win2Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setCountry(country);
       controller.setStage(myStage);   
        }}
        
    
    
    public void init() {
 
        pane.setVgap(75);
        pane.setHgap(50);


      
        flip1.addListener((ob, old, news) -> {
            if (flip2.getValue() == true && flip3.getValue() == true ){
                System.out.println("win");
            try {

                      try {
                      TimeUnit.SECONDS.sleep(2);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                win ();
            } catch (IOException ex) {
                Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        });
        flip2.addListener((ob, old, news) -> {
            if (flip1.getValue() == true && flip3.getValue() == true ){
                System.out.println("win");
            try {
                try {
                      TimeUnit.SECONDS.sleep(2);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                win ();
            } catch (IOException ex) {
                Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        flip3.addListener((ob, old, news) -> {
            if (flip2.getValue() == true && flip1.getValue() == true ){
                System.out.println("win");
            try {
                try {
                      TimeUnit.SECONDS.sleep(2);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                win ();
            } catch (IOException ex) {
                Logger.getLogger(MemoryCardController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
       // Refrence:  https://stackoverflow.com/questions/19896562/flip-a-card-animation
       ScaleTransition stShowFront = new ScaleTransition(Duration.millis(1000));
       stShowFront.setFromX(0);
       stShowFront.setToX(1);
     // ******************   card 1 **************************
        mystryCard1.setOnMouseClicked(e -> {
            if (card1.get() !=2){
         // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){
            stShowFront.setNode(mystryCard1);
            stShowFront.play();
            check();
            mystryCard1.setImage(emptyCard11);
            System.out.println("enter 1");
              card1.set(1);
          if (card1.get()== 1 && card2.get()==1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
               stShowFront.setOnFinished(er ->{
                 flip1.setValue(Boolean.TRUE);
               });
              card1.set(2);
              card2.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card1.get()== 1 && card3.get()==1){
              card1.set(0);
              card3.set(0);
          }
          else if (card1.get()== 1 && card4.get()==1){
              card1.set(0);
              card4.set(0);
          }
          else if (card1.get()== 1 && card5.get()==1){
              card1.set(0);
              card5.set(0);
          }
          else if (card1.get()== 1 && card6.get()==1){
            card1.set(0);
            card6.set(0);
          }
            }
           // ******************   china cards **************************
             if (country.getCountryname() == "China" ){
            stShowFront.setNode(mystryCard1);
            stShowFront.play();
            check();
            mystryCard1.setImage(emptyCard22);
            System.out.println("enter 1");
              card1.set(1);
          if (card1.get()== 1 && card6.get()==1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
               stShowFront.setOnFinished(er ->{
                 flip1.setValue(Boolean.TRUE);
               });
              card1.set(2);
              card6.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card1.get()== 1 && card3.get()==1){
              card1.set(0);
              card3.set(0);
          }
          else if (card1.get()== 1 && card4.get()==1){
              card1.set(0);
              card4.set(0);
          }
          else if (card1.get()== 1 && card5.get()==1){
              card1.set(0);
              card5.set(0);
          }
          else if (card1.get()== 1 && card2.get()==1){
            card1.set(0);
            card2.set(0);
          }
            }
            // ******************  brazil cards **************************
             if (country.getCountryname() == "Brazil" ){
            stShowFront.setNode(mystryCard1);
            stShowFront.play();
            check();
            mystryCard1.setImage(emptyCard33);
            System.out.println("enter 1");
              card1.set(1);
          if (card1.get()== 1 && card3.get()==1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
               stShowFront.setOnFinished(er ->{
                 flip1.setValue(Boolean.TRUE);
               });
              card1.set(2);
              card3.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card1.get()== 1 && card2.get()==1){
              card1.set(0);
              card2.set(0);
          }
          else if (card1.get()== 1 && card4.get()==1){
              card1.set(0);
              card4.set(0);
          }
          else if (card1.get()== 1 && card5.get()==1){
              card1.set(0);
              card5.set(0);
          }
          else if (card1.get()== 1 && card6.get()==1){
            card1.set(0);
            card6.set(0);
          }
            }
             
             // ******************   russia cards  **************************
             if (country.getCountryname() == "Russia" ){
            stShowFront.setNode(mystryCard1);
            stShowFront.play();
            check();
            mystryCard1.setImage(emptyCard11);
            System.out.println("enter 1");
              card1.set(1);
          if (card1.get()== 1 && card6.get()==1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
               stShowFront.setOnFinished(er ->{
                 flip1.setValue(Boolean.TRUE);
               });
              card1.set(2);
              card6.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card1.get()== 1 && card3.get()==1){
              card1.set(0);
              card3.set(0);
          }
          else if (card1.get()== 1 && card4.get()==1){
              card1.set(0);
              card4.set(0);
          }
          else if (card1.get()== 1 && card5.get()==1){
              card1.set(0);
              card5.set(0);
          }
          else if (card1.get()== 1 && card2.get()==1){
            card1.set(0);
            card2.set(0);
          }
            }
             
            }
            
        });   
        // ******************   card 2 **************************
        mystryCard2.setOnMouseClicked(e -> {
            if (card2.get() !=2){
              // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){  
            stShowFront.setNode(mystryCard2);
            stShowFront.play();
            check();
            mystryCard2.setImage(emptyCard11);
            System.out.println("enter 2");
            card2.set(1);
          if (card2.get()== 1 && card1.get()== 1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
              stShowFront.setOnFinished(er -> {
              flip1.setValue(Boolean.TRUE);
              });
              card1.set(2);
              card2.set(2);
              System.out.println("flip 1"+flip1);
          }
            else if (card2.get()== 1 && card3.get()== 1){
              card2.set(0);
              card3.set(0);
          }
           else if (card2.get()== 1 && card4.get()== 1){
            card2.set(0);
            card4.set(0);
          }
          
           else if (card2.get()== 1 && card5.get()== 1){
            card2.set(0);
            card5.set(0);
          }
          
            else if (card2.get()== 1 && card6.get()== 1){
             card2.set(0);
             card6.set(0);
          }
            }
             // ******************   china cards  **************************
              if (country.getCountryname() == "China" ){  
            stShowFront.setNode(mystryCard2);
            stShowFront.play();
            check();
            mystryCard2.setImage(emptyCard33);
            System.out.println("enter 2");
            card2.set(1);
          if (card2.get()== 1 && card4.get()== 1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
              stShowFront.setOnFinished(er -> {
              flip3.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card2.set(2);
              System.out.println("flip 3"+flip3);
          }
            else if (card2.get()== 1 && card3.get()== 1){
              card2.set(0);
              card3.set(0);
          }
           else if (card2.get()== 1 && card1.get()== 1){
            card2.set(0);
            card1.set(0);
          }
          
           else if (card2.get()== 1 && card5.get()== 1){
            card2.set(0);
            card5.set(0);
          }
          
            else if (card2.get()== 1 && card6.get()== 1){
             card2.set(0);
             card6.set(0);
          }
            }
             // ******************   brazil cards  **************************
              if (country.getCountryname() == "Brazil" ){  
            stShowFront.setNode(mystryCard2);
            stShowFront.play();
            check();
            mystryCard2.setImage(emptyCard11);
            System.out.println("enter 2");
            card2.set(1);
          if (card2.get()== 1 && card5.get()== 1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
              stShowFront.setOnFinished(er -> {
              flip2.setValue(Boolean.TRUE);
              });
              card5.set(2);
              card2.set(2);
              System.out.println("flip 2"+flip2);
          }
            else if (card2.get()== 1 && card3.get()== 1){
              card2.set(0);
              card3.set(0);
          }
           else if (card2.get()== 1 && card4.get()== 1){
            card2.set(0);
            card4.set(0);
          }
          
           else if (card2.get()== 1 && card1.get()== 1){
            card2.set(0);
            card1.set(0);
          }
          
            else if (card2.get()== 1 && card6.get()== 1){
             card2.set(0);
             card6.set(0);
          }
            }
             // ******************   Russia cards  **************************
              if (country.getCountryname() == "Russia" ){  
            stShowFront.setNode(mystryCard2);
            stShowFront.play();
            check();
            mystryCard2.setImage(emptyCard22);
            System.out.println("enter 2");
            card2.set(1);
          if (card2.get()== 1 && card5.get()== 1){
              stShowFront.setAutoReverse(true);
              stShowFront.setCycleCount(1);
              stShowFront.setOnFinished(er -> {
              flip2.setValue(Boolean.TRUE);
              });
              card5.set(2);
              card2.set(2);
              System.out.println("flip 2"+flip2);
          }
            else if (card2.get()== 1 && card3.get()== 1){
              card2.set(0);
              card3.set(0);
          }
           else if (card2.get()== 1 && card4.get()== 1){
            card2.set(0);
            card4.set(0);
          }
          
           else if (card2.get()== 1 && card1.get()== 1){
            card2.set(0);
            card1.set(0);
          }
          
            else if (card2.get()== 1 && card6.get()== 1){
             card2.set(0);
             card6.set(0);
          }
            } 
            }
        });
        
        
        // ******************   card 3 **************************
        mystryCard3.setOnMouseClicked(e -> {
            if (card3.get() !=2){
                 // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){ 
            stShowFront.setNode(mystryCard3);
            stShowFront.play();
            check();
            mystryCard3.setImage(emptyCard33);
            
            System.out.println("enter 3");
               card3.set(1);
         if (card3.get()== 1 && card6.get()== 1){
             stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
            card3.set(2);
            card6.set(2);
            System.out.println("flip 3"+flip3);
          }
          else if (card3.get()== 1 && card1.get()== 1){
             card3.set(0);
             card1.set(0);
          }
          else if (card3.get()== 1 && card2.get()== 1){
            card3.set(0);
            card2.set(0);
          }
          else if (card3.get()== 1 && card4.get()== 1){
             card3.set(0);
             card4.set(0);
          }
         else if (card3.get()== 1 && card5.get()== 1){
             card3.set(0);
             card5.set(0);
          }
            }
              // ******************   china cards  **************************
             if (country.getCountryname() == "China" ){ 
            stShowFront.setNode(mystryCard3);
            stShowFront.play();
            check();
            mystryCard3.setImage(emptyCard11);
            
            System.out.println("enter 3");
               card3.set(1);
         if (card3.get()== 1 && card5.get()== 1){
             stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
            card3.set(2);
            card5.set(2);
            System.out.println("flip 2"+flip2);
          }
          else if (card3.get()== 1 && card1.get()== 1){
             card3.set(0);
             card1.set(0);
          }
          else if (card3.get()== 1 && card2.get()== 1){
            card3.set(0);
            card2.set(0);
          }
          else if (card3.get()== 1 && card4.get()== 1){
             card3.set(0);
             card4.set(0);
          }
         else if (card3.get()== 1 && card6.get()== 1){
             card3.set(0);
             card6.set(0);
          }
            }
             // ******************   brazil cards  **************************
             if (country.getCountryname() == "Brazil" ){ 
            stShowFront.setNode(mystryCard3);
            stShowFront.play();
            check();
            mystryCard3.setImage(emptyCard33);
            
            System.out.println("enter 3");
               card3.set(1);
         if (card3.get()== 1 && card1.get()== 1){
             stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip1.setValue(Boolean.TRUE);
              });
            card3.set(2);
            card1.set(2);
            System.out.println("flip 1"+flip1);
          }
          else if (card3.get()== 1 && card6.get()== 1){
             card3.set(0);
             card6.set(0);
          }
          else if (card3.get()== 1 && card2.get()== 1){
            card3.set(0);
            card2.set(0);
          }
          else if (card3.get()== 1 && card4.get()== 1){
             card3.set(0);
             card4.set(0);
          }
         else if (card3.get()== 1 && card5.get()== 1){
             card3.set(0);
             card5.set(0);
          }
            }
             // ******************   Russia cards  **************************
             if (country.getCountryname() == "Russia" ){ 
            stShowFront.setNode(mystryCard3);
            stShowFront.play();
            check();
            mystryCard3.setImage(emptyCard33);
            
            System.out.println("enter 3");
               card3.set(1);
         if (card3.get()== 1 && card4.get()== 1){
             stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
            card3.set(2);
            card4.set(2);
            System.out.println("flip 3"+flip3);
          }
          else if (card3.get()== 1 && card6.get()== 1){
             card3.set(0);
             card6.set(0);
          }
          else if (card3.get()== 1 && card2.get()== 1){
            card3.set(0);
            card2.set(0);
          }
          else if (card3.get()== 1 && card1.get()== 1){
             card3.set(0);
             card1.set(0);
          }
         else if (card3.get()== 1 && card5.get()== 1){
             card3.set(0);
             card5.set(0);
          }
            }
            }
        });
        // ******************   card 4 **************************
        mystryCard4.setOnMouseClicked(e -> {
            if (card4.get() !=2){
                 // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){ 
            stShowFront.setNode(mystryCard4);
            stShowFront.play();
            check();
            mystryCard4.setImage(emptyCard22);
            System.out.println("enter 4");
               card4.set(1);
          if (card4.get()== 1 && card5.get()== 1){

              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card5.set(2);
              System.out.println("flip 2"+flip2);
          }
          else if (card4.get()== 1 && card1.get()== 1){
              card4.set(0);
              card1.set(0);
          }
          else if (card4.get()== 1 && card2.get()== 1){
              card4.set(0);
              card2.set(0);
          }
          else if (card4.get()== 1 && card3.get()== 1){
              card4.set(0);
              card3.set(0);
          }
          else if (card4.get()== 1 && card6.get()== 1){
              card4.set(0);
              card6.set(0);
          }
            }
              // ******************   china cards  **************************
              if (country.getCountryname() == "China" ){ 
            stShowFront.setNode(mystryCard4);
            stShowFront.play();
            check();
            mystryCard4.setImage(emptyCard33);
            System.out.println("enter 4");
               card4.set(1);
          if (card4.get()== 1 && card2.get()== 1){

              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card2.set(2);
              System.out.println("flip 3"+flip3);
          }
          else if (card4.get()== 1 && card1.get()== 1){
              card4.set(0);
              card1.set(0);
          }
          else if (card4.get()== 1 && card5.get()== 1){
              card4.set(0);
              card5.set(0);
          }
          else if (card4.get()== 1 && card3.get()== 1){
              card4.set(0);
              card3.set(0);
          }
          else if (card4.get()== 1 && card6.get()== 1){
              card4.set(0);
              card6.set(0);
          }
            }
               // ******************   brazil cards  **************************
               if (country.getCountryname() == "Brazil" ){ 
            stShowFront.setNode(mystryCard4);
            stShowFront.play();
            check();
            mystryCard4.setImage(emptyCard22);
            System.out.println("enter 4");
               card4.set(1);
          if (card4.get()== 1 && card6.get()== 1){

              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card6.set(2);
              System.out.println("flip 3"+flip3);
          }
          else if (card4.get()== 1 && card1.get()== 1){
              card4.set(0);
              card1.set(0);
          }
          else if (card4.get()== 1 && card2.get()== 1){
              card4.set(0);
              card2.set(0);
          }
          else if (card4.get()== 1 && card3.get()== 1){
              card4.set(0);
              card3.set(0);
          }
          else if (card4.get()== 1 && card5.get()== 1){
              card4.set(0);
              card5.set(0);
          }
            }
               // ******************   Russia cards  **************************
               if (country.getCountryname() == "Russia" ){ 
            stShowFront.setNode(mystryCard4);
            stShowFront.play();
            check();
            mystryCard4.setImage(emptyCard33);
            System.out.println("enter 4");
               card4.set(1);
          if (card4.get()== 1 && card3.get()== 1){

              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card3.set(2);
              System.out.println("flip 3"+flip3);
          }
          else if (card4.get()== 1 && card1.get()== 1){
              card4.set(0);
              card1.set(0);
          }
          else if (card4.get()== 1 && card2.get()== 1){
              card4.set(0);
              card2.set(0);
          }
          else if (card4.get()== 1 && card6.get()== 1){
              card4.set(0);
              card6.set(0);
          }
          else if (card4.get()== 1 && card5.get()== 1){
              card4.set(0);
              card5.set(0);
          }
            }
            }
        });
        // ******************   card 5 **************************
        mystryCard5.setOnMouseClicked(e -> {
            if (card5.get() !=2){
                 // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){ 
            stShowFront.setNode(mystryCard5);
            stShowFront.play();
            check();
            mystryCard5.setImage(emptyCard22);
            System.out.println("enter 5");
               card5.set(1);
          if (card5.get()== 1 && card4.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card5.set(2);
              System.out.println("flip 2"+flip2);
          }
          else if (card5.get()== 1 && card1.get()== 1){
              card5.set(0);
              card1.set(0);
          }
          else if (card5.get()== 1 && card2.get()== 1){
              card5.set(0);
              card2.set(0);
          }
          else if (card5.get()== 1 && card3.get()== 1){
              card5.set(0);
              card3.set(0);
          }
          else if (card5.get()== 1 && card6.get()== 1){
              card5.set(0);
              card6.set(0);
          }
            }
              // ******************   china cards  **************************
             if (country.getCountryname() == "China" ){ 
            stShowFront.setNode(mystryCard5);
            stShowFront.play();
            check();
            mystryCard5.setImage(emptyCard11);
            System.out.println("enter 5");
               card5.set(1);
          if (card5.get()== 1 && card3.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
              card3.set(2);
              card5.set(2);
              System.out.println("flip 2"+flip2);
          }
          else if (card5.get()== 1 && card1.get()== 1){
              card5.set(0);
              card1.set(0);
          }
          else if (card5.get()== 1 && card2.get()== 1){
              card5.set(0);
              card2.set(0);
          }
          else if (card5.get()== 1 && card4.get()== 1){
              card5.set(0);
              card4.set(0);
          }
          else if (card5.get()== 1 && card6.get()== 1){
              card5.set(0);
              card6.set(0);
          }
            }
              // ******************   brazil cards  **************************
             if (country.getCountryname() == "Brazil" ){ 
            stShowFront.setNode(mystryCard5);
            stShowFront.play();
            check();
            mystryCard5.setImage(emptyCard11);
            System.out.println("enter 5");
               card5.set(1);
          if (card5.get()== 1 && card2.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
              card2.set(2);
              card5.set(2);
              System.out.println("flip 2"+flip2);
          }
          else if (card5.get()== 1 && card1.get()== 1){
              card5.set(0);
              card1.set(0);
          }
          else if (card5.get()== 1 && card4.get()== 1){
              card5.set(0);
              card4.set(0);
          }
          else if (card5.get()== 1 && card3.get()== 1){
              card5.set(0);
              card3.set(0);
          }
          else if (card5.get()== 1 && card6.get()== 1){
              card5.set(0);
              card6.set(0);
          }
            }
              // ******************   Russia cards  **************************
             if (country.getCountryname() == "Russia" ){ 
            stShowFront.setNode(mystryCard5);
            stShowFront.play();
            check();
            mystryCard5.setImage(emptyCard22);
            System.out.println("enter 5");
               card5.set(1);
          if (card5.get()== 1 && card2.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip2.setValue(Boolean.TRUE);
              });
              card2.set(2);
              card5.set(2);
              System.out.println("flip 2"+flip2);
          }
          else if (card5.get()== 1 && card1.get()== 1){
              card5.set(0);
              card1.set(0);
          }
          else if (card5.get()== 1 && card4.get()== 1){
              card5.set(0);
              card4.set(0);
          }
          else if (card5.get()== 1 && card3.get()== 1){
              card5.set(0);
              card3.set(0);
          }
          else if (card5.get()== 1 && card6.get()== 1){
              card5.set(0);
              card6.set(0);
          }
            }
             
            }
        });
        
        
        // ******************   card 6 **************************
        mystryCard6.setOnMouseClicked(e -> {
            if (card6.get() !=2){
                 // ******************   saudi cards  **************************
             if (country.getCountryname() == "Saudi Arabia" ){ 
            stShowFront.setNode(mystryCard6);
            stShowFront.play();
            check();
            mystryCard6.setImage(emptyCard33);
            System.out.println("enter 6");
               card6.set(1);
          if (card6.get()== 1 && card3.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
              card3.set(2);
              card6.set(2);
              System.out.println("flip 3"+flip3);
          }
          else if (card6.get()== 1 && card1.get()== 1){
              card6.set(0);
              card1.set(0);  
          }
          else if (card6.get()== 1 && card2.get()== 1){
              card6.set(0);
              card2.set(0);
          }
          else if (card6.get()== 1 && card4.get()== 1){
              card6.set(0);
              card4.set(0);
          }
          else if (card6.get()== 1 && card5.get()== 1){
              card6.set(0);
              card5.set(0);
          }
          }
                 // ******************   china cards  **************************
             if (country.getCountryname() == "China" ){ 
            stShowFront.setNode(mystryCard6);
            stShowFront.play();
            check();
            mystryCard6.setImage(emptyCard22);
            System.out.println("enter 6");
               card6.set(1);
          if (card6.get()== 1 && card1.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip1.setValue(Boolean.TRUE);
              });
              card1.set(2);
              card6.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card6.get()== 1 && card3.get()== 1){
              card6.set(0);
              card3.set(0);  
          }
          else if (card6.get()== 1 && card2.get()== 1){
              card6.set(0);
              card2.set(0);
          }
          else if (card6.get()== 1 && card4.get()== 1){
              card6.set(0);
              card4.set(0);
          }
          else if (card6.get()== 1 && card5.get()== 1){
              card6.set(0);
              card5.set(0);
          }
          }
                 // ******************   brazil cards  **************************
             if (country.getCountryname() == "Brazil" ){ 
            stShowFront.setNode(mystryCard6);
            stShowFront.play();
            check();
            mystryCard6.setImage(emptyCard22);
            System.out.println("enter 6");
               card6.set(1);
          if (card6.get()== 1 && card4.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip3.setValue(Boolean.TRUE);
              });
              card4.set(2);
              card6.set(2);
              System.out.println("flip 3"+flip3);
          }
          else if (card6.get()== 1 && card1.get()== 1){
              card6.set(0);
              card1.set(0);  
          }
          else if (card6.get()== 1 && card2.get()== 1){
              card6.set(0);
              card2.set(0);
          }
          else if (card6.get()== 1 && card3.get()== 1){
              card6.set(0);
              card3.set(0);
          }
          else if (card6.get()== 1 && card5.get()== 1){
              card6.set(0);
              card5.set(0);
          }
          }
               // ******************   Russia cards  **************************
             if (country.getCountryname() == "Russia" ){ 
            stShowFront.setNode(mystryCard6);
            stShowFront.play();
            check();
            mystryCard6.setImage(emptyCard11);
            System.out.println("enter 6");
               card6.set(1);
          if (card6.get()== 1 && card1.get()== 1){
              stShowFront.setAutoReverse(true);
                  stShowFront.setCycleCount(1);
                  stShowFront.setOnFinished(er -> {
                   flip1.setValue(Boolean.TRUE);
              });
              card1.set(2);
              card6.set(2);
              System.out.println("flip 1"+flip1);
          }
          else if (card6.get()== 1 && card4.get()== 1){
              card6.set(0);
              card4.set(0);  
          }
          else if (card6.get()== 1 && card2.get()== 1){
              card6.set(0);
              card2.set(0);
          }
          else if (card6.get()== 1 && card3.get()== 1){
              card6.set(0);
              card3.set(0);
          }
          else if (card6.get()== 1 && card5.get()== 1){
              card6.set(0);
              card5.set(0);
          }
          }
             
            }
        });
        
        pane.add(mystryCard1, 0, 0);
        pane.add(mystryCard2, 0, 1);
        pane.add(mystryCard3, 1, 0);
        pane.add(mystryCard4, 1, 1);
        pane.add(mystryCard5, 2, 0);
        pane.add(mystryCard6, 2, 1);
        root.setCenter(pane);
    }
    
    
    public void check(){
        // Refrence:  https://stackoverflow.com/questions/19896562/flip-a-card-animation
        ScaleTransition stHideFront = new ScaleTransition(Duration.millis(1000));
         stHideFront.setFromX(0);
         stHideFront.setToX(1);

         if (card1.get()== 0 ){ 
             
             stHideFront.setNode(mystryCard1);
             stHideFront.play();
             mystryCard1.setImage(mystryCard);
             card1.set(11);
             }
         if (card2.get()== 0 ){ 
             stHideFront.setNode(mystryCard2);
             stHideFront.play();
             mystryCard2.setImage(mystryCard);
             card2.set(11);
            }
         
          if (card3.get()== 0 ){
             stHideFront.setNode(mystryCard3);
             stHideFront.play();
             mystryCard3.setImage(mystryCard);
             card3.set(11);
            }
         
           if (card4.get()== 0 ){ 
             stHideFront.setNode(mystryCard4);
             stHideFront.play();
             mystryCard4.setImage(mystryCard);
             card4.set(11);
           }
         if (card5.get()== 0 ){ 
             stHideFront.setNode(mystryCard5);
             stHideFront.play();
             mystryCard5.setImage(mystryCard);
             card5.set(11);
             }
         if (card6.get()== 0 ){
             stHideFront.setNode(mystryCard6);
             stHideFront.play();
             mystryCard6.setImage(mystryCard);
             card6.set(11);
             }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       init();
    }    

  
    
}
