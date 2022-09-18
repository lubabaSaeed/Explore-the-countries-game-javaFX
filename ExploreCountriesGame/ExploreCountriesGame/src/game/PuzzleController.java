
package game;


import static game.MapController.score;
import static game.MapController.level;
import static game.HomePageController.gamer_name;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PuzzleController  {

    @FXML private AnchorPane root2;
    @FXML
    private ImageView startButton;
     @FXML
    private ImageView close;
    static int count = 0 ;
    static BooleanProperty complete = new SimpleBooleanProperty(false);
     
    private static String styleImg;
     private  String flagImg;
     
   Country country;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
 
    @FXML
    private Label label_name;
     public void setCountry(Country c) {
     country = c;
     
   }     
     

     
     private Stage myStage;
     public void setStage(Stage stage) {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
     label_name.setText(gamer_name);
     System.out.println(label_name.getText()+" puzzel");
      
           
           
               
   }
     public void setFlagAndStyle (Country c){
         country = c;
         flagImg = c.getCountryflag();
         styleImg = c.getCountryStyleImg(); 
         try {
            init(myStage);
        } catch (IOException ex) {
            Logger.getLogger(PuzzleController.class.getName()).log(Level.SEVERE, null, ex);
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
    
     public void startGamePre(MouseEvent e){
        System.out.println("entered");
        startButton.setScaleX(startButton.getScaleX() + 0.1);
        startButton.setScaleY(startButton.getScaleY() + 0.1);  
    }
     public void startGameRel(MouseEvent e)  {
        System.out.println("exited");
        startButton.setScaleX(startButton.getScaleX() - 0.1);
        startButton.setScaleY(startButton.getScaleY() - 0.1);
         
    }
     
    public void start(MouseEvent event) throws IOException {
        System.out.println("start");
        init(myStage);
        startButton.setScaleX(0);
        startButton.setScaleY(0);
        
    }
    
    public void incrementScore(){
     
        if (country.getCountryname() == "Saudi Arabia"){
            
            if (score==0){
                
                score++; 
                Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session1.beginTransaction();
            score sco=new score();
             String scor=String.valueOf(score) ;
            String leve=String.valueOf(level) ;
            sco.setUsername(gamer_name);
            sco.setScore(scor);
           sco.setLevel(leve);
            session1.save(sco);
            tx1.commit();
           session1.close(); 
            }
        }
        if (country.getCountryname() == "China"){
            
            if (score==4){
                score++;
            }
        }
        if (country.getCountryname() == "Brazil"){
        
             if (score==8){
                 score++;
             
             }
        }
        if (country.getCountryname() == "Russia"){
         if (score==12){
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
    
    public void win () throws IOException{
//         saudiScoreGames[0] = true;
        incrementScore();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("win1.fxml"));
       Parent root =(Parent) loader.load();
       Win1Controller controller = loader.getController();
       myStage.setScene(new Scene(root));
        controller.setStage(myStage);
       controller.setCountry(country);
       count = 0;
       complete.setValue(Boolean.FALSE);
//       score();
       
       
        }
    
    // Refrences: https://a143mk.blogspot.com/2016/02/puzzle-game.html 
    
     final List<Piece> pieces  = new ArrayList<Piece>();
    public static Timeline timeline;
    
   

    public void init(Stage primaryStage) throws IOException {             
        complete.addListener((ob, old, news) -> {
            
        PauseTransition wait = new PauseTransition(Duration.seconds(2));   
           if (complete.getValue() == true  ){
                
               wait.setOnFinished(e -> {try {
                        win ();
                    } catch (IOException ex) {
                        Logger.getLogger(PuzzleController.class.getName()).log(Level.SEVERE, null, ex);
                    }});
               System.out.println("win");
               wait.play();
            }
        
        });
        System.out.println("init");

        
        // load puzzle image
        Image image = new Image(getClass().getResourceAsStream(
          flagImg  ));
        int numOfColumns = (int) (image.getWidth() / Piece.SIZE );
        int numOfRows = (int) (image.getHeight() / Piece.SIZE);
        // create desk
        final Desk desk = new Desk(numOfColumns, numOfRows);
        // create puzzle pieces

        for (int col = 0; col < numOfColumns; col++) {
            for (int row = 0; row < numOfRows; row++) {
                int x = col * Piece.SIZE;
                int y = row * Piece.SIZE;
                final Piece piece = new Piece(image, x, y, row>0, col>0,
                        row<numOfRows -1, col < numOfColumns -1,
                        desk.getWidth(), desk.getHeight());
                pieces.add(piece);
            }
        }
        desk.getChildren().addAll(pieces);
        System.out.println(pieces.size());
                if (timeline != null) timeline.stop();
                timeline = new Timeline();
                double i =0.1;
                for (final Piece piece : pieces) {
                    
                   piece.setActive();
                   double shuffleX = Math.random() *
                           (desk.getWidth() - Piece.SIZE + 48f ) -
                           24f - piece.getCorrectX();
                   double shuffleY = Math.random() *
                           (desk.getHeight() - Piece.SIZE + 30f ) -
                           15f - piece.getCorrectY();
                    timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                            new KeyValue(piece.translateXProperty(),shuffleX ),
                            new KeyValue(piece.translateYProperty(),shuffleY)));
                            i=i+0.5;
                }
                timeline.playFromStart();
        root2.getChildren().addAll(desk);
    }

   

    /**
     * Node that represents the playing area/ desktop where the puzzle Piece sit
     */
    
    public static class Desk extends Pane {
        
        Desk(int numOfColumns, int numOfRows) {
              getStylesheets().add(getClass().getResource(styleImg).toExternalForm());
              getStyleClass().add("my-pane");
            double DESK_WIDTH = Piece.SIZE * numOfColumns;
            double DESK_HEIGHT = Piece.SIZE * numOfRows;
            setPrefSize(2000,2000);
            setMaxSize(DESK_WIDTH, DESK_HEIGHT);
            autosize();
            // create path for lines
            Path grid = new Path();
            grid.setStroke(Color.rgb(70, 70, 70));
            getChildren().add(grid);
            // create vertical lines
             for (int col = 0; col < numOfColumns - 1; col++) {
                 grid.getElements().addAll(
                     new MoveTo(Piece.SIZE + Piece.SIZE * col, 5),
                     new LineTo(Piece.SIZE + Piece.SIZE * col, Piece.SIZE * numOfRows - 5)
                 );
            }
            // create horizontal lines
            for (int row = 0; row < numOfRows - 1; row++) {
                 grid.getElements().addAll(
                     new MoveTo(5, Piece.SIZE + Piece.SIZE * row),
                     new LineTo(Piece.SIZE * numOfColumns - 5, Piece.SIZE + Piece.SIZE * row)
                 );
            }
        }
        @Override protected void layoutChildren() {}
    }

    /**
     * Node that represents a puzzle piece
     */
    public static class Piece extends Parent {
        
        
        
        public static final int SIZE = 100;
        private final double correctX;
        private final double correctY;
        private final boolean hasTopTab;
        private final boolean hasLeftTab;
        private final boolean hasBottomTab;
        private final boolean hasRightTab;
        private double startDragX;
        private double startDragY;
        private Shape pieceStroke;
        private Shape pieceClip;
        private ImageView imageView = new ImageView();
        private Point2D dragAnchor;

        public Piece(Image image, final double correctX, final double correctY,
                     boolean topTab, boolean leftTab, boolean bottomTab, boolean rightTab,
                     final double deskWidth, final double deskHeight) throws IOException {
            this.correctX = correctX;
            this.correctY = correctY;
            this.hasTopTab = topTab;
            this.hasLeftTab = leftTab;
            this.hasBottomTab = bottomTab;
            this.hasRightTab = rightTab;
            // configure clip
            pieceClip = createPiece();
            pieceClip.setFill(Color.WHITE);
            pieceClip.setStroke(null);
            // add a stroke
            pieceStroke = createPiece();
            pieceStroke.setFill(null);
            pieceStroke.setStroke(Color.BLACK);
            // create image view
            imageView.setImage(image);
            imageView.setClip(pieceClip);
            setFocusTraversable(true);
            getChildren().addAll(imageView, pieceStroke);
            // turn on caching so the jigsaw piece is fasr to draw when dragging
            setCache(true);
            // start in inactive state
            setInactive();
            // add listeners to support dragging
            setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    toFront();
                    startDragX = getTranslateX();
                    startDragY = getTranslateY();
                    dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
                }
            });
            setOnMouseReleased(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    if (getTranslateX() < (10) && getTranslateX() > (- 10) &&
                        getTranslateY() < (10) && getTranslateY() > (- 10)) {
                        setTranslateX(0);
                        setTranslateY(0);
                        try {
                            setInactive();
                        } catch (IOException ex) {
                            Logger.getLogger(PuzzleController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            setOnMouseDragged(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    double newTranslateX = startDragX
                                            + me.getSceneX() - dragAnchor.getX();
                    double newTranslateY = startDragY
                                            + me.getSceneY() - dragAnchor.getY();
                    double minTranslateX = - 45f - correctX;
                    double maxTranslateX = (deskWidth - Piece.SIZE + 50f ) - correctX;
                    double minTranslateY = - 30f - correctY;
                    double maxTranslateY = (deskHeight - Piece.SIZE + 70f ) - correctY;
                    if ((newTranslateX> minTranslateX ) &&
                            (newTranslateX< maxTranslateX) &&
                            (newTranslateY> minTranslateY) &&
                            (newTranslateY< maxTranslateY)) {
                        setTranslateX(newTranslateX);
                        setTranslateY(newTranslateY);
                    }
                }
            });
        }

        private Shape createPiece() {
             System.out.println("shape");
            Shape shape = createPieceRectangle();
            if (hasRightTab) {
                shape = Shape.union(shape,
                        createPieceTab(69.5f, 0f, 10f, 17.5f, 50f, -12.5f, 11.5f,
                                25f, 56.25f, -14f, 6.25f, 56.25f, 14f, 6.25f));
            }
            if (hasBottomTab) {
                shape = Shape.union(shape,
                        createPieceTab(0f, 69.5f, 17.5f, 10f, -12.5f, 50f, 25f,
                                11f, -14f, 56.25f, 6.25f, 14f, 56.25f, 6.25f));
            }
            if (hasLeftTab) {
                shape = Shape.subtract(shape,
                        createPieceTab(-31f, 0f, 10f, 17.5f, -50f, -12.5f, 11f,
                                25f, -43.75f, -14f, 6.25f, -43.75f, 14f, 6.25f));
            }
            if (hasTopTab) {
                shape = Shape.subtract(shape,
                        createPieceTab(0f, -31f, 17.5f, 10f, -12.5f, -50f, 25f,
                                12.5f, -14f, -43.75f, 6.25f, 14f, -43.75f, 6.25f));
            }
            shape.setTranslateX(correctX);
            shape.setTranslateY(correctY);
            shape.setLayoutX(50f);
            shape.setLayoutY(50f);
            return shape;
        }

        private Rectangle createPieceRectangle() {
             System.out.println("createPieceRectangle");
            Rectangle rec = new Rectangle();
            rec.setX(-50);
            rec.setY(-50);
            rec.setWidth(SIZE);
            rec.setHeight(SIZE);
            return rec;
        }

        private Shape createPieceTab(double eclipseCenterX, double eclipseCenterY, double eclipseRadiusX, double eclipseRadiusY,
                                     double rectangleX, double rectangleY, double rectangleWidth, double rectangleHeight,
                                     double circle1CenterX, double circle1CenterY, double circle1Radius,
                                     double circle2CenterX, double circle2CenterY, double circle2Radius) {
            Ellipse e = new Ellipse(eclipseCenterX, eclipseCenterY, eclipseRadiusX, eclipseRadiusY);
            Rectangle r = new Rectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight);
            Shape tab = Shape.union(e, r);
            Circle c1 = new Circle(circle1CenterX, circle1CenterY, circle1Radius);
            tab = Shape.subtract(tab, c1);
            Circle c2 = new Circle(circle2CenterX, circle2CenterY, circle2Radius);
            tab = Shape.subtract(tab, c2);
            return tab;
        }

        public void setActive() {
            setDisable(false);
            setEffect(new DropShadow());
            toFront();
           
        }

        public void setInactive() throws IOException {
           
            
              System.out.println("count = " + count);
            setEffect(null);
            setDisable(true);
            count++;
            System.out.println("count = " + count);
            if (count == 24){ 

                complete.setValue(Boolean.TRUE);           
            }
            toBack();
           
        }
        

        public double getCorrectX() { return correctX; }

        public double getCorrectY() { return correctY; }
    }
    
    
    
}
