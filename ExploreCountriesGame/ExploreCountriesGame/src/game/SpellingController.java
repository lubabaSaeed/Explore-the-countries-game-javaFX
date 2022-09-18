
package game;


import static game.HomePageController.gamer_name;
import static game.MapController.score;
import static game.MapController.level;
import static game.MapController.level;
import static game.MapController.score;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SpellingController  implements Initializable {
    // Refrence : https://stackoverflow.com/questions/47663497/how-can-i-add-an-audioclip-in-javafx
    public  AudioClip capital_sound;
    public  AudioClip clip1 = new AudioClip(getClass().getResource("/voice/clickSound.mp3").toString());
@FXML
    private ImageView close;
   @FXML  GridPane spelling_pan;
//   @FXML   AnchorPane sPane;   
   int ca=0,cb=0,cc=0,ch=0,ci=0,cn=0,cr=0,co=0,cw=0;
    ImageView A_letter=new ImageView("/image/A.png");
    ImageView A_letter2=new ImageView("/image/A.png");
    ImageView A_letter3=new ImageView("/image/A.png");
    ImageView A_letter4=new ImageView("/image/A.png");

    ImageView B_letter=new ImageView("/image/b.png");
    ImageView B_letter2=new ImageView("/image/b.png");
    ImageView B_letter3=new ImageView("/image/b.png");
    ImageView B_letter4=new ImageView("/image/b.png");
   // ImageView B_letter5=new ImageView("/image/b.png");

    ImageView C_letter=new ImageView("/image/C.png");
    ImageView C_letter2=new ImageView("/image/C.png");
    ImageView C_letter3=new ImageView("/image/C.png");
    ImageView C_letter4=new ImageView("/image/C.png");
  //  ImageView C_letter5=new ImageView("/image/C.png");

    ImageView H_letter=new ImageView("/image/H.png");
    ImageView H_letter2=new ImageView("/image/H.png");
    ImageView H_letter3=new ImageView("/image/H.png");
    ImageView H_letter4=new ImageView("/image/H.png");
  //  ImageView H_letter5=new ImageView("/image/H.png");

    ImageView I_letter=new ImageView("/image/I.png");
    ImageView I_letter2=new ImageView("/image/I.png");
    ImageView I_letter3=new ImageView("/image/I.png");
    ImageView I_letter4=new ImageView("/image/I.png");
  //  ImageView I_letter5=new ImageView("/image/I.png");

    ImageView I2_letter=new ImageView("/image/I.png");
    
    ImageView R_letter=new ImageView("/image/R.png");
    ImageView R_letter2=new ImageView("/image/R.png");
    ImageView R_letter3=new ImageView("/image/R.png");
    ImageView R_letter4=new ImageView("/image/R.png");
  //  ImageView R_letter5=new ImageView("/image/R.png");

    ImageView N_letter=new ImageView("/image/N.png");
    ImageView N_letter2=new ImageView("/image/N.png");
    ImageView N_letter3=new ImageView("/image/N.png");
    ImageView N_letter4=new ImageView("/image/N.png");
  //  ImageView N_letter5=new ImageView("/image/N.png");

    ImageView Y_letter=new ImageView("/image/Y.png");

    ImageView D_letter=new ImageView("/image/D.png");


    ImageView E_letter=new ImageView("/image/E.png");


    ImageView G_letter=new ImageView("/image/G.png");


    ImageView S_letter=new ImageView("/image/S.png");
  

    ImageView L_letter=new ImageView("/image/L.png");
  

    ImageView J_letter=new ImageView("/image/J.png");
    ImageView M_letter=new ImageView("/image/M.png");
    ImageView O_letter=new ImageView("/image/O.png");
    ImageView O_letter2=new ImageView("/image/O.png");
    ImageView O_letter3=new ImageView("/image/O.png");
    ImageView O_letter4=new ImageView("/image/O.png");
   // ImageView O_letter5=new ImageView("/image/O.png");

    ImageView O2_letter=new ImageView("/image/O.png");
    ImageView W_letter=new ImageView("/image/W.png");
    ImageView W_letter2=new ImageView("/image/W.png");
    ImageView W_letter3=new ImageView("/image/W.png");
    ImageView W_letter4=new ImageView("/image/W.png");
  //  ImageView W_letter5=new ImageView("/image/W.png");

    Image space=new Image("/image/space.png");

           
    Country country ; int c_id;
    
    


    
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private ImageView pronounce;
     @FXML
    Button A_BUTTON;
     @FXML
    Button B_BUTTON;
      @FXML
    Button C_BUTTON;
       @FXML
    Button H_BUTTON;
        @FXML
    Button I_BUTTON;
         @FXML
    Button N_BUTTON;
          @FXML
    Button O_BUTTON;
           @FXML
    Button R_BUTTON;
            @FXML
    Button W_BUTTON;
             @FXML
    Button DELETE_BUTTON;
              @FXML
    Button ENTER_BUTTON;
     RotateTransition rotate= new RotateTransition(Duration.millis(1000));
    @FXML
    
    private Label label_name;
    // Refrence: https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
     System.out.println(label_name.getText()+" spelling");
}
      public void incrementScore(){
     
        if (country.getCountryname() == "Saudi Arabia"){
        
            if (score==1){
              score++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "China"){
        
            if (score==5){
            score++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "Brazil"){
        
             if (score==9){
                 score++;
             }
        }
        if (country.getCountryname() == "Russia"){
         if (score==13){
             score++;
         }
        }
        
         Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session1.beginTransaction();
            score sco=new score();
             sco.setUsername(gamer_name);
             String scor=String.valueOf(score) ;
           List<score> list1 =null;
            String queryp="from score";
            Query query1 =session1.createQuery(queryp);
            list1 =query1.list();
             for(score u:list1){ 
                 if(sco.getUsername().equals(u.getUsername())){
                     u.setScore(scor);
                  session1.update(u);
            }}
          
            tx1.commit();
           session1.close(); 
    
    }
    @FXML
    public void exitApp(MouseEvent e){

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
    
    ImageView space0=new ImageView(space);
    ImageView space1=new ImageView(space);
    ImageView space2=new ImageView(space);
    ImageView space3=new ImageView(space);
    ImageView space4=new ImageView(space);
    ImageView space5=new ImageView(space);
    ImageView space6=new ImageView(space);
    public void setLETTER (Country c){
        spelling_pan.setAlignment(Pos.CENTER);
        RotateTransition rotate= new RotateTransition(Duration.millis(80));
        rotate.setNode(pronounce);
        rotate.setByAngle(3);
        rotate.setCycleCount(rotate.INDEFINITE);
        rotate.setAutoReverse(true);
        rotate.play();
    A_letter.setId("A_node");
    A_letter2.setId("A_node");
    A_letter3.setId("A_node");
    A_letter4.setId("A_node");

     B_letter.setId("B_node");
     B_letter2.setId("B_node");
     B_letter3.setId("B_node");
     B_letter4.setId("B_node");
     
     
     C_letter.setId("C_node");
     C_letter2.setId("C_node");
     C_letter3.setId("C_node");
     C_letter4.setId("C_node");

     H_letter.setId("H_node");
     H_letter2.setId("H_node");
     H_letter3.setId("H_node");
     H_letter4.setId("H_node");

     I_letter.setId("I_node");
     I_letter2.setId("I_node");
     I_letter3.setId("I_node");
     I_letter4.setId("I_node");

     R_letter.setId("R_node");
     R_letter2.setId("R_node");
     R_letter3.setId("R_node");
     R_letter4.setId("R_node"); 

     N_letter.setId("N_node");
     N_letter2.setId("N_node");
     N_letter3.setId("N_node");
     N_letter4.setId("N_node");

     O_letter.setId("O_node");
     O_letter2.setId("O_node");
     O_letter3.setId("O_node");
     O_letter4.setId("O_node");

     W_letter.setId("W_node");
     W_letter2.setId("W_node");
     W_letter3.setId("W_node");
     W_letter4.setId("W_node");
    
    space0.setId("empty_node");
    space1.setId("empty_node");
    space2.setId("empty_node");
    space3.setId("empty_node");
    space4.setId("empty_node");
    space5.setId("empty_node");
    space6.setId("empty_node");
         country = c;
         if (c.getCountryname() == "Saudi Arabia" ){
    
             spelling_pan.add(Y_letter, 2, 0);
             spelling_pan.add(D_letter, 4, 0);
             spelling_pan.add(space1, 0, 0);
             spelling_pan.add(space2, 1, 0);
             spelling_pan.add(space3, 3, 0);
             spelling_pan.add(space4, 5, 0);            
          c_id=1;
          
          //نطق العاصمة
          //clip1 =  new AudioClip(getClass().getResource("/voice/Riyadh.mp3").toString());//مو شغال معرف ليه مع انه لو جربتي الي تحته شلتي الكومنت تمام يزبط
        capital_sound =  new AudioClip(getClass().getResource("/voice/Riyadh.mp3").toString());

          
         }
         
         if (c.getCountryname() == "China" ){
           spelling_pan.add(E_letter, 1, 0);
           spelling_pan.add(I2_letter, 4, 0);
           spelling_pan.add(G_letter, 6, 0);
           spelling_pan.add(space1, 0, 0);
           spelling_pan.add(space2, 2, 0);
           spelling_pan.add(J_letter, 3, 0);
           spelling_pan.add(space4, 5, 0);     
          c_id=2;
         
      //نطق العاصمة
          capital_sound =  new AudioClip(getClass().getResource("/voice/Beijing.mp3").toString());
         }
         if (c.getCountryname() == "Brazil" ){
            c_id=3;
           spelling_pan.add(S_letter, 3, 0);
           spelling_pan.add(L_letter, 5, 0);
           spelling_pan.add(space1, 0, 0);
           spelling_pan.add(space2, 1, 0);
           spelling_pan.add(space3, 2, 0);
           spelling_pan.add(space4, 4, 0); 
           
           //نطق العاصمة
          capital_sound =  new AudioClip(getClass().getResource("/voice/Brasilia.mp3").toString());}
         
          //Russia
          if (c.getCountryname() == "Russia" ){
           c_id=4;
           spelling_pan.add(M_letter, 0, 0);
           spelling_pan.add(S_letter, 2, 0);         
           spelling_pan.add(O2_letter, 4, 0);
           spelling_pan.add(space1,1, 0);
           spelling_pan.add(space2,3, 0);
           spelling_pan.add(space3,5, 0);
           
          // نطق عاصمة روسيا 
        
          capital_sound =  new AudioClip(getClass().getResource("/voice/Moscow.mp3").toString());
    }
  
    }
int  row=0,col=0, count = 1;

        public void set_in_empty(ImageView letters,GridPane gridPane){
            nextcol (count);
            count++;
        if (c_id==2&&col==7){
                System.out.println("full");
            }
        if (c_id!=2&&col==6){
                System.out.println("full");
            } 
        else{    
  for (Node node : gridPane.getChildren()) {
      System.out.print(col);
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col) {
        System.out.println();
      if(node.getId()=="empty_node"){     
          gridPane.getChildren().remove(node); 
          gridPane.add(letters, col, row); System.out.println("add");
             break;}
      else{
          if (c_id==2){
              if(col==3){
              col=col+1;}
          }
          col=col+1;
          }
      
      }
    }col=col+1;}}
       int iconut = 0;
  public void delete_last_letter(GridPane gridPane){
  count--;iconut=count-1; nextcol (iconut);
  for (Node node : gridPane.getChildren()) {
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == (col-1)) {
         col--;
        if(node.getId()!=null){
          gridPane.getChildren().remove(node);
          switch (col){
          case(0):gridPane.add(space0, col, row);break;
          case(1):gridPane.add(space1, col, row);break;
          case(2):gridPane.add(space2, col, row);break;
          case(3):gridPane.add(space3, col, row);break;
          case(4):gridPane.add(space4, col, row);break;
          case(5):gridPane.add(space5, col, row);break;
          case(6):gridPane.add(space6, col, row);break;
          }
          
        
      break;}
        else {
           // if(col==0)break;
           // delete_last_letter(spelling_pan);
        }}
      }}
        
        int result=0;
    int col_check=0;
   public void check(GridPane gridPane){
        for(int count =0;count<6;count++){
   
    ///saudi 
    if(c_id==1){
        
    
  for (Node node : gridPane.getChildren()) {
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col_check) {
        if(node.getId()=="R_node"){
         if (col_check==0){
             result=result+1;}
        }
        else if(node.getId()=="I_node"){
         if (col_check==1){
             result=result+1;}
       }
         
            if(node.getId()=="A_node"){
         if (col_check==3){
             result=result+1;}
            }
             if(node.getId()=="H_node"){
         if (col_check==5){
             result=result+1;}
            } 

    }}}
    //china
     if(c_id==2){
  for (Node node : gridPane.getChildren()) {
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col_check) {
        if(node.getId()=="B_node"){
         if (col_check==0){
             result=result+2;}
         
        }
        else if(node.getId()=="I_node"){
         if (col_check==2){
             result=result+1;}
        }         
            if(node.getId()=="N_node"){
         if (col_check==5){
             result=result+1;}
            }

    } }}
     
  //Brazil   
       if(c_id==3){
  for (Node node : gridPane.getChildren()) {
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col_check) {
        if(node.getId()=="B_node"){
         if (col_check==0){
             result=result+1;}
         }
        
         if(node==R_letter){
         if (col_check==1){
              result=result+1;}}
         
          if(node.getId()=="A_node"){
         if (col_check==2){
             result=result+1;}
            }
          if(node.getId()=="I_node"){
         if (col_check==4){
             result=result+1;}
         
            } 

    }  
  }}
        //Russia
            if(c_id==4){
  for (Node node : gridPane.getChildren()) {
    if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col_check) {
        if(node.getId()=="O_node"){
         if (col_check==1){
             result=result+2;}
         
        }
        else if(node.getId()=="C_node"){
         if (col_check==3){
             result=result+1;}
        }         
            if(node.getId()=="W_node"){
         if (col_check==5){
             result=result+1;}
            }

    } }}col_check=col_check+1; }}
 
        
  public void  button_enter(Node n){

     n.setScaleX(n.getScaleX() + 0.1);
       n.setScaleY(n.getScaleY() + 0.1); 
//
 }
  public void  button_exit(Node n){

     n.setScaleX(n.getScaleX() - 0.1);
        n.setScaleY(n.getScaleY() - 0.1);
}
 @FXML public void  A_letter_enter(MouseEvent e){
     button_enter(A_BUTTON);
    
 }
 @FXML
  public void  A_letter_exit(MouseEvent e){
   button_exit( A_BUTTON);
  }
   @FXML public void  B_letter_enter(MouseEvent e){
    button_enter( B_BUTTON);

 }
  @FXML 
  public void  B_letter_exit(MouseEvent e){
    button_exit( B_BUTTON);

      
}
  @FXML public void  C_letter_enter(MouseEvent e){

    button_enter( C_BUTTON);

      
 }
  @FXML public void  C_letter_exit(MouseEvent e){
            
button_exit( C_BUTTON);
 }
   @FXML public void  H_letter_enter(MouseEvent e){

 button_enter( H_BUTTON);
       
 }
  @FXML public void  H_letter_exit(MouseEvent e){
    button_exit( H_BUTTON);

 }
   @FXML public void  I_letter_enter(MouseEvent e){
    button_enter( I_BUTTON);

       
 }
  @FXML public void  I_letter_exit(MouseEvent e){
    button_exit( I_BUTTON);

      
 }
  
   @FXML public void  N_letter_enter(MouseEvent e){
    button_enter( N_BUTTON);

 }
  @FXML public void  N_letter_exit(MouseEvent e){
    button_exit( N_BUTTON);

 }
   @FXML public void  O_letter_enter(MouseEvent e){

           button_enter( O_BUTTON);
      
 }
  @FXML public void  O_letter_exit(MouseEvent e){
    button_exit( O_BUTTON);

 }
   @FXML public void  R_letter_enter(MouseEvent e){
    button_enter( R_BUTTON);

 }
  @FXML public void  R_letter_exit(MouseEvent e){
    button_exit( R_BUTTON);

 }
   @FXML public void  W_letter_enter(MouseEvent e){
    button_enter( W_BUTTON);

}
  @FXML public void  W_letter_exit(MouseEvent e){
          button_exit(W_BUTTON);
 
      
 }
    @FXML public void  Enter_enter(MouseEvent e){

    button_enter( ENTER_BUTTON);

 }
   
  @FXML public void  Enter_exit(MouseEvent e){
    button_exit( ENTER_BUTTON);

 }
    @FXML public void  delete_enter(MouseEvent e){
    button_enter( DELETE_BUTTON);

    }   
 @FXML public void  delete_exit(MouseEvent e){
          button_exit( DELETE_BUTTON);

 }
    
        
 @FXML public void  A_letter_click(ActionEvent e){
              clip1.play();

     ca=ca+1;
     if (ca==5){ca=1;}
      if (ca==1){ set_in_empty(A_letter,spelling_pan );
                 System.out.println(ca);
      }
       if (ca==2){ set_in_empty(A_letter2,spelling_pan );      
           }
       if (ca==3) { set_in_empty(A_letter3,spelling_pan );
         System.out.println(ca);
         }
      if (ca==4){ set_in_empty(A_letter4,spelling_pan );
         System.out.println(ca);
         }
    

            }     
            
  @FXML public void  B_letter_click(ActionEvent e){
               clip1.play();

       cb=cb+1;
     if (cb==5){cb=1;}
         switch (cb){
         case(1): set_in_empty(B_letter,spelling_pan ); break;
         case(2): set_in_empty(B_letter2,spelling_pan );  break;
         case(3): set_in_empty(B_letter3,spelling_pan );  break;
         case(4): set_in_empty(B_letter4,spelling_pan );  break; 
         
         
            }  }
   @FXML public void  C_letter_click(ActionEvent e){
                clip1.play();

        cc=cc+1;
     if (cc==5){cc=1;}
        switch (cc){
         case(1):set_in_empty(C_letter,spelling_pan );   break;
         case(2):set_in_empty(C_letter2,spelling_pan );  break;
         case(3):set_in_empty(C_letter3,spelling_pan );  break;
         case(4):set_in_empty(C_letter4,spelling_pan );  break;

            }}
  
   @FXML public void  H_letter_click(ActionEvent e){
                clip1.play();

        ch=ch+1;
     if (ch==5){ch=1;}
         switch (ch){
         case(1):set_in_empty(H_letter,spelling_pan );   break;
         case(2):set_in_empty(H_letter2,spelling_pan );   break;
         case(3):set_in_empty(H_letter3,spelling_pan );   break;
         case(4):set_in_empty(H_letter4,spelling_pan );   break;

            } }  
   
    @FXML public void  I_letter_click(ActionEvent e){
                 clip1.play();

         ci=ci+1;
     if (ci==5){ci=1;}
           switch (ci){
         case(1): set_in_empty(I_letter,spelling_pan );   break;
         case(2): set_in_empty(I_letter2,spelling_pan );  break;
         case(3): set_in_empty(I_letter3,spelling_pan );  break;
         case(4): set_in_empty(I_letter4,spelling_pan );  break;
           }
           } 
    
     @FXML public void  N_letter_click(ActionEvent e){
                  clip1.play();

         cn=cn+1;
         if (cn==5){cn=1;}
         switch (cn){
         case(1): set_in_empty(N_letter,spelling_pan );  break;
         case(2): set_in_empty(N_letter2,spelling_pan ); break;
         case(3): set_in_empty(N_letter3,spelling_pan ); break;
         case(4): set_in_empty(N_letter4,spelling_pan ); break; 
         
       }}
     @FXML public void  O_letter_click(ActionEvent e){
                  clip1.play();

         co=co+1;
         if(co==5){co=1;}
         switch (co){
         case(1):set_in_empty(O_letter,spelling_pan );   break;
         case(2):set_in_empty(O_letter2,spelling_pan );  break;
         case(3):set_in_empty(O_letter3,spelling_pan );  break;
         case(4):set_in_empty(O_letter4,spelling_pan );  break; 
            }
     }
    
    @FXML public void  R_letter_click(ActionEvent e){
                 clip1.play();

        cr=cr+1;
        if(cr==5){cr=1;}
         switch (cr){
         case(1): set_in_empty(R_letter,spelling_pan );   break;
         case(2): set_in_empty(R_letter2,spelling_pan );  break;
         case(3): set_in_empty(R_letter3,spelling_pan );  break;
         case(4): set_in_empty(R_letter4,spelling_pan );  break; 

               }}     
   
   
   
    @FXML public void  W_letter_click(ActionEvent e){
                 clip1.play();

        cw=cw+1;
        if(cw==5){cw=1;}
         switch (cw){
         case(1):  set_in_empty(W_letter,spelling_pan ); break;
         case(2):  set_in_empty(W_letter2,spelling_pan ); break;
         case(3):  set_in_empty(W_letter3,spelling_pan ); break;
         case(4):  set_in_empty(W_letter4,spelling_pan ); break; 

               }}
    @FXML public void  delete_click(ActionEvent e){
                       clip1.play();
     
            delete_last_letter(spelling_pan );}
    
    @FXML public void  enter_click(ActionEvent e) throws IOException{
                 clip1.play();

          check( spelling_pan);
          System.out.println(col_check);
          System.out.println(result);
          if (result==4){
          incrementScore();
          System.out.println("score = "+ score + " level = "+ level);
  
          FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("win1.fxml"));
        Parent root =(Parent) loader.load();
       Win1Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setCountry(country);
       controller.setStage(myStage);
       
        }
           
           else{     FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("spelling.fxml"));
        Parent root =(Parent) loader.load();
       SpellingController controller = loader.getController();
       myStage.setScene(new Scene(root));
       controller.setStage(myStage);
//        country =  new Country("Saudi Arabia","/image/styleSaudi.css","/image/saudiFlagre.png","","","","");
        controller.setLETTER(country);
       }}
  
//       
//     }
    
    public void next (Button b){
        // Rerfrence:  https://youtu.be/ISEtiXCkESYv=VDTVeDozcag​
         RotateTransition rotate= new RotateTransition(Duration.millis(100));
        rotate.setNode(b);
        rotate.setByAngle(5);
        rotate.setCycleCount(10);
        rotate.setAutoReverse(true);
        rotate.play();}
public void nextcol (int count_keyboard){
 switch(c_id) {
     case(1):
     switch(count_keyboard) {
     case(1):{next (I_BUTTON);break;}
     case(2):{next (A_BUTTON);break;}
     case(3):{next (H_BUTTON);break;}}break;
     
     case(2):
         switch(count_keyboard) {
     case(1):{next (I_BUTTON);break;}
     case(2):{next (N_BUTTON);break;}}break;
          case(3):
         switch(count_keyboard) {
   
     case(1):{next (R_BUTTON);break;}
     case(2):{next (A_BUTTON);break;}
     case(3):{next (I_BUTTON);break;}}break;
      case(4):
         switch(count_keyboard) {
     case(1):{next (C_BUTTON);break;}
     case(2):{next (W_BUTTON);break;}}break;
         
  
        }
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }

// تجربة تشغيل صوت  ينطق العاصمة 
    
    @FXML
    private void pronounceWord(MouseEvent event) {
        capital_sound.play();
    }
  
    
       
    
}

