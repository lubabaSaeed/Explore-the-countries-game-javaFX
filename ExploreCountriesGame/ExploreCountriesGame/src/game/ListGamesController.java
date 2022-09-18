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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class ListGamesController implements Initializable {
    
    
     public  AudioClip clip1 = new AudioClip(getClass().getResource("/voice/clickSound.mp3").toString());
     public  AudioClip clip2 = new AudioClip(getClass().getResource("/voice/bubble.mp3").toString());
     
     
    @FXML private ImageView backButton;
    @FXML private ImageView close;
    // pics
    @FXML ImageView puzzlePic ;
    @FXML ImageView memCradsPic;
    @FXML ImageView mazPic ;
    @FXML ImageView spellingPic;
    // rectagels
    @FXML Rectangle puzzleRect;
    @FXML Rectangle spellingRect;
    @FXML Rectangle mazeRect;
    @FXML Rectangle memCardsRect;
    
     @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    
    @FXML
    private ImageView spellingButton;
    @FXML
    private ImageView mazeButton;
    @FXML
    private ImageView memoryButton;
    @FXML
    private ImageView puzzleButton;
    

     
     Image puzzleAbleButton = new Image("/image/puzzleButton2.png");
     Image spellingAbleButton = new Image("/image/spellingButton.png");
     Image mazeAbleButton = new Image("/image/mazeButton.png");
     Image memoryCardAbleButton = new Image("/image/memoryButton2.png");
     Image star = new Image("/image/starPic.png");
     
     private Country country ;
    Color yellow = Color.web("0xf9ffbc");
    @FXML
    private Label label_name;
    
      
      
      public void setCountry(Country c){
        country = c;
        countryScore();
        scoreLabel.setText(String.valueOf(score * 10));
        levelLabel.setText(String.valueOf(level));
        label_name.setText(gamer_name);

       }
    
    public void completeGameButton(Rectangle r , ImageView button, ImageView pic){
        r.setFill(yellow);
        pic.setImage(star);
        
        if (pic.equals(puzzlePic)){
        button.setImage(puzzleAbleButton);
        }
        if (pic.equals(memCradsPic)){
        button.setImage(memoryCardAbleButton);
        }
        if (pic.equals(mazPic)){
        button.setImage(mazeAbleButton);
        }
        if (pic.equals(spellingPic)){
        button.setImage(spellingAbleButton);
        }
    }
    
    public void ableButton(Rectangle r , ImageView button){
        r.setFill(yellow);
        if (button.equals(puzzleButton)){
        button.setImage(puzzleAbleButton);
        }
        if (button.equals(memoryButton)){
        button.setImage(memoryCardAbleButton);
        }
        if (button.equals(mazeButton)){
        button.setImage(mazeAbleButton);
        }
        if (button.equals(spellingButton)){
        button.setImage(spellingAbleButton);
        }
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
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
   }
     
     public void scaleUpBackButton (ImageView i ){
       
        i.setScaleX(i.getScaleX() + 0.1);
        i.setScaleY(i.getScaleY() + 0.1);
     }
     
     public void scaleDownBackButton (ImageView i ){

        i.setScaleX(i.getScaleX() - 0.1);
        i.setScaleY(i.getScaleY() - 0.1);
     }
     
     @FXML public void backEnterMouse(MouseEvent e){
        scaleUpBackButton(backButton); 
    }
     @FXML public void backExiteMouse(MouseEvent e)  {
        scaleDownBackButton(backButton);    
    }
   
     @FXML
    public void back(MouseEvent event) throws IOException {

        clip1.play();
        // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("map.fxml"));
       Parent root =(Parent) loader.load();
       MapController controller = loader.getController();
       myStage.setScene(new Scene(root));
        controller.setStage(myStage);
   
    }
    
    public void countryScore (){
        if (country.getCountryname() == "Saudi Arabia"){
            if (score > 4){
                completeGameButton(puzzleRect,puzzleButton,puzzlePic);
                completeGameButton(spellingRect,spellingButton,spellingPic);
                completeGameButton(mazeRect,mazeButton,mazPic);
                completeGameButton(memCardsRect,memoryButton,memCradsPic);
            }
           if (score >0){
            completeGameButton(puzzleRect,puzzleButton,puzzlePic);
            ableButton(spellingRect,spellingButton);
        }
         if (score > 1){
            completeGameButton(spellingRect,spellingButton,spellingPic);
            ableButton(mazeRect,mazeButton);
        }
         if (score >2 ){
            completeGameButton(mazeRect,mazeButton,mazPic);
            ableButton(memCardsRect,memoryButton);
        }
         if (score > 3){
            completeGameButton(memCardsRect,memoryButton,memCradsPic);
        }
    }
        
        if (country.getCountryname() == "China"){
            if (score > 8){
                completeGameButton(puzzleRect,puzzleButton,puzzlePic);
                completeGameButton(spellingRect,spellingButton,spellingPic);
                completeGameButton(mazeRect,mazeButton,mazPic);
                completeGameButton(memCardsRect,memoryButton,memCradsPic);
            }
              if (score > 4){
            completeGameButton(puzzleRect,puzzleButton,puzzlePic);
            ableButton(spellingRect,spellingButton);
        }
             if (score > 5){
            completeGameButton(spellingRect,spellingButton,spellingPic);
            ableButton(mazeRect,mazeButton);
        }
             if (score > 6){
            completeGameButton(mazeRect,mazeButton,mazPic);
            ableButton(memCardsRect,memoryButton);
        }
            if (score > 7){
            completeGameButton(memCardsRect,memoryButton,memCradsPic);
        }
        }
            if (country.getCountryname() == "Brazil"){
            if (score > 12){
                completeGameButton(puzzleRect,puzzleButton,puzzlePic);
                completeGameButton(spellingRect,spellingButton,spellingPic);
                completeGameButton(mazeRect,mazeButton,mazPic);
                completeGameButton(memCardsRect,memoryButton,memCradsPic);
            }
              if (score > 8){
            completeGameButton(puzzleRect,puzzleButton,puzzlePic);
            ableButton(spellingRect,spellingButton);
        }
            if (score > 9){
             completeGameButton(spellingRect,spellingButton,spellingPic);
            ableButton(mazeRect,mazeButton);
        }
             if (score > 10){
            completeGameButton(mazeRect,mazeButton,mazPic);
            ableButton(memCardsRect,memoryButton);
        }
             if (score > 11){
            completeGameButton(memCardsRect,memoryButton,memCradsPic);
        }
            }
            if (country.getCountryname() == "Russia"){
            if (score > 16){
                completeGameButton(puzzleRect,puzzleButton,puzzlePic);
                completeGameButton(spellingRect,spellingButton,spellingPic);
                completeGameButton(mazeRect,mazeButton,mazPic);
                completeGameButton(memCardsRect,memoryButton,memCradsPic);
            }
              if (score > 12){
           completeGameButton(puzzleRect,puzzleButton,puzzlePic);
            ableButton(spellingRect,spellingButton);
        }
              if (score >13){
             completeGameButton(spellingRect,spellingButton,spellingPic);
            ableButton(mazeRect,mazeButton);
        }
           if (score > 14){
           completeGameButton(mazeRect,mazeButton,mazPic);
            ableButton(memCardsRect,memoryButton);
        }
            if (score > 15){
            completeGameButton(memCardsRect,memoryButton,memCradsPic);
        }
        
    }
        }  
    
    
    public void spellingPage() throws IOException{
        clip1.play();
        // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("spelling.fxml"));
        Parent root =(Parent) loader.load();
       SpellingController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
       controller.setLETTER (country);
    }
    public void mazePage() throws IOException, Exception{
        clip1.play();
        // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("maze.fxml"));
        Parent root =(Parent) loader.load();
        MazeController controller = loader.getController();
        Scene scene =new Scene(root);   
        controller.set_landmarks_image(country);
        controller.start(scene);
        myStage.setScene(scene);
        controller.setStage(myStage);
    }
    public void memoryCardsPage() throws IOException{
        clip1.play();
        // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("memoryCard.fxml"));
        Parent root =(Parent) loader.load();
       MemoryCardController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
        controller.setCards(country);
    }
    
    
    public void spellingAccess() throws IOException{
     if (country.getCountryname() == "Saudi Arabia"){
         if(score > 0){
         spellingPage();
      }
         
     }
     if (country.getCountryname() == "China"){
       if(score > 4){
       spellingPage();
       }
     }
     if (country.getCountryname() == "Brazil"){
     if(score > 8){
     spellingPage();
     }
     }
     if (country.getCountryname() == "Russia"){
     if(score > 12){
     spellingPage();
     }
     }
    }
    
     public void mazeAccess() throws IOException, Exception{
     if (country.getCountryname() == "Saudi Arabia"){
         if(score > 1){
         mazePage();
      }
         
     }
     if (country.getCountryname() == "China"){
       if(score > 5){
        mazePage();
       }
     }
     if (country.getCountryname() == "Brazil"){
     if(score > 9){
      mazePage();
     }
     }
     if (country.getCountryname() == "Russia"){
     if(score > 13){
      mazePage();
     }
     }
    }
      
    
    public void memoryAccess() throws IOException{
     if (country.getCountryname() == "Saudi Arabia"){
         if(score > 2){
         memoryCardsPage();
      }
         
     }
     if (country.getCountryname() == "China"){
       if(score > 6){
       memoryCardsPage();
       }
     }
     if (country.getCountryname() == "Brazil"){
     if(score > 10){
      
     memoryCardsPage();
     }
     }
     if (country.getCountryname() == "Russia"){
     if(score > 14){
     memoryCardsPage();
     }
     }
    }

     
     public void scaleUp (Rectangle r , ImageView i , ImageView b){
         
        r.setScaleX(r.getScaleX() + 0.5);
        r.setScaleY(r.getScaleY() + 0.5);
        
        i.setScaleX(i.getScaleX() + 0.5);
        i.setScaleY(i.getScaleY() + 0.5);
        
        b.setScaleX(b.getScaleX() + 0.3);
        b.setScaleY(b.getScaleY() + 0.3);
     }
     
     public void scaleDown (Rectangle r , ImageView i,ImageView b  ){
        
        r.setScaleX(r.getScaleX() - 0.5);
        r.setScaleY(r.getScaleY() - 0.5);
        
        i.setScaleX(i.getScaleX() - 0.5);
        i.setScaleY(i.getScaleY() - 0.5);
        
        b.setScaleX(b.getScaleX() - 0.3);
        b.setScaleY(b.getScaleY() - 0.3);
     }
     
     
     //  ****   puzzle  *****
     
    @FXML
     public void startPuzzleButton(MouseEvent e)throws InterruptedException, IOException{
         clip1.play();
     }
    @FXML
     public void startPuzzleEnterMouseButton(MouseEvent e){
          scaleUp(puzzleRect , puzzlePic,puzzleButton);  
    }
    @FXML
    public void startPuzzleExitedMouseButton(MouseEvent e){
         scaleDown(puzzleRect , puzzlePic,puzzleButton);
    }
     
     @FXML public void startPuzzle(MouseEvent e)throws InterruptedException, IOException{
         clip1.play();
         //Refrence : https://www.youtube.com/watch?v=XCgcQTQCfJQ&list=PLoodc-fmtJNYbs-gYCdd5MYS4CKVbGHv2&index=7&t=27s
        FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("puzzle.fxml"));
        Parent root =(Parent) loader.load();
       PuzzleController controller = (PuzzleController)loader.getController();
       Scene scene = new Scene(root);
       Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
       window.setScene(scene);
       controller.setFlagAndStyle(country);
       controller.setStage(myStage);
          
    }
    @FXML public void startPuzzleEnterMouse(MouseEvent e){
        clip2.play();
         scaleUp(puzzleRect , puzzlePic,puzzleButton);  
    }
    @FXML public void startPuzzleExitedMouse(MouseEvent e){
         scaleDown(puzzleRect , puzzlePic,puzzleButton);
    }
    
    
    //  ****   memory cards *****
    
    @FXML
    public void startMemCardsButton(MouseEvent e)throws InterruptedException, IOException{
        
        memoryAccess();
    }
    @FXML
     public void startMemCardsEnterMouseButton(MouseEvent e){
          scaleUp(memCardsRect , memCradsPic,memoryButton); 
    }
    @FXML
    public void startMemCardsExitedMouseButton(MouseEvent e){
        scaleDown(memCardsRect , memCradsPic,memoryButton);
    }
    
    
    
    @FXML public void startMemCards(MouseEvent e)throws InterruptedException, IOException{

      memoryAccess();
     
    }
    @FXML public void startMemCardsEnterMouse(MouseEvent e){
        clip2.play();
        scaleUp(memCardsRect , memCradsPic,memoryButton);
        
    }
    @FXML public void startMemCardsExitedMouse(MouseEvent e){
        scaleDown(memCardsRect , memCradsPic,memoryButton);
    }
    
    
     //  ****   maze  *****
    @FXML
    public void startMazeButton(MouseEvent e)throws InterruptedException, IOException, Exception{
        mazeAccess();

    }
    @FXML
     public void startMazeEnterMouseButton(MouseEvent e){
          scaleUp(mazeRect , mazPic,mazeButton); 
    }
    @FXML
    public void startMazeExitedMouseButton(MouseEvent e){
          scaleDown(mazeRect , mazPic,mazeButton);
    }
    
    @FXML public void startMaze(MouseEvent e)throws InterruptedException, IOException, Exception{
       mazeAccess();

    }
    @FXML public void startMazeEnterMouse(MouseEvent e){
        clip2.play();
       scaleUp(mazeRect , mazPic,mazeButton);  
    }
    @FXML public void startMazeExitedMouse(MouseEvent e) {
        scaleDown(mazeRect , mazPic,mazeButton);
    }
    
    //  ****  spelling  *****
    
    @FXML
    public void startSpellingButton(MouseEvent e)throws InterruptedException, IOException{
        spellingAccess();

    }
    @FXML
     public void startSpellingEnterMouseButton(MouseEvent e){
          scaleUp(spellingRect , spellingPic,spellingButton);
    }
    @FXML
    public void startSpellingExitedMouseButton(MouseEvent e){
         scaleDown(spellingRect , spellingPic,spellingButton);
    }
     
     @FXML public void startSpelling(MouseEvent e)throws InterruptedException, IOException{

        spellingAccess();

    }
    @FXML public void startSpellingEnterMouse(MouseEvent e){
        clip2.play();
         scaleUp(spellingRect , spellingPic,spellingButton);
        
    }
    @FXML public void startSpellingExitedMouse(MouseEvent e){
         scaleDown(spellingRect , spellingPic,spellingButton);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    

   
    
}