
package game;


import static game.HomePageController.gamer_name;
import static game.MapController.score;
import static game.MapController.level;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MazeController implements Initializable {

    @FXML
    private ImageView close;
  
    
    private Country country ;
    
    
    @FXML
     AnchorPane mazePane;
    @FXML
    AnchorPane landmarks;
     ImageView    landmarks1;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label label_name;
     
      public void incrementScore(){
     
        if (country.getCountryname() == "Saudi Arabia"){
        
            if (score==2){
              score++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "China"){
        
            if (score==6){
            score++;
            System.out.println("score = "+ score + " level = " + level);
            }
        }
        if (country.getCountryname() == "Brazil"){
        
             if (score==10){
                 score++;
             }
        }
        if (country.getCountryname() == "Russia"){
         if (score==14){
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
         
     int count1;
    public void set_landmarks_image(Country c){
        country = c;
         
        if (c.getCountryname() == "China" ){
            landmarks1=new ImageView("/image/greatWallOfChina.png");
         landmarks.getChildren().add(landmarks1);
              landmarks1.setFitWidth(80);
        landmarks1.setFitHeight(84);
      
         }
         
        if (c.getCountryname() == "Brazil" ){
            landmarks1=new ImageView("/image/iguazuFalls.png");
         landmarks.getChildren().add(landmarks1);
    
     landmarks1.setFitWidth(80);
        landmarks1.setFitHeight(80);
    }
    if (c.getCountryname() == "Russia" ){
         landmarks1=new ImageView("/image/kremlin.png");
         landmarks.getChildren().add(landmarks1);
              landmarks1.setFitWidth(80);
        landmarks1.setFitHeight(84);
    }
     // Rerfrence:  https://youtu.be/ISEtiXCkESYv=VDTVeDozcag​
     RotateTransition rotate= new RotateTransition(Duration.millis(100));
        rotate.setNode(landmarks1);
        rotate.setByAngle(2);
        rotate.setCycleCount(5000);
        rotate.setAutoReverse(true);
        rotate.play();
        
        if (c.getCountryname() == "Saudi Arabia" ){
            landmarks1=new ImageView("/image/kaaba.png"); 
        landmarks.getChildren().add(landmarks1);
         landmarks1.setFitWidth(80);
        landmarks1.setFitHeight(84);
         count1=1;
}
    
    }
     // Refrence : https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
    private Stage myStage;
     public void setStage(Stage stage) throws Exception {
     myStage = stage;
     scoreLabel.setText(String.valueOf(score * 10));
     levelLabel.setText(String.valueOf(level));
      label_name.setText(gamer_name);
       System.out.println(label_name.getText()+" maz");
     
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    

  
      // Refrence: https://www.writebug.com/git/codes?owner=Tommorow&repo=maze-game 
      class CreateMap {
	// تهيئة الخريطة ، يتم حظر جميع الطرق افتراضيًا
	// يمثل صف الصف عدد صفوف الشبكة الفارغة في البداية ، وهناك جدران بين الشبكات ، لذا فإن حجم الصفيف النهائي ثنائي الأبعاد هو في الواقع (2row + 1) * (2colum + 1)

	private int row;
	private int column;

	public int[][] map;// مصفوفة لتخزين المتاهة
	// private Vector[] Pos;
	private int r;
	private int c;

	CreateMap(int r0, int c0) {
		row = r0;
		column = c0;
		r = 2 * row + 1;
		c = 2 * column + 1;

		map = new int[r][c];
	}

	public void Init() {

		for (int i = 0; i < r; i++) // تعيين كل الشبكات كجدران
			for (int j = 0; j < c; j++)
				map[i][j] = 0;// 0 هو الجدار 1 هو الطريق

		// تم تعيين الشبكة الوسطى على 1
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				map[2 * i + 1][2 * j + 1] = 1;// 0 هو الجدار 1 هو الطريق

		// خوارزمية Primm
		accLabPrime();
	}

	// معالجة المصفوفة من خلال خوارزمية Prim لإنشاء المتاهة النهائية
	// فكرة:
	// ابحث عن أقرب نقطة لزيارتها عشوائيًا (تتم زيارة كل نقطة مرة واحدة فقط ، حتى تتم زيارة جميع الطرق) ،
	// سيتم إنشاء طريقة للوصول إلى جميع النقاط (غير المرتبة). عندما يتم العثور على النقطة التالية بشكل عشوائي ، سيتم فتح الجدار بين الشبكتين المتجاورتين السابقتين

	public void accLabPrime() {
		// acc يخزن قائمة الانتظار التي تمت زيارتها ، لا يخزن noacc أي قائمة انتظار وصول
		int[] acc, noacc;
		int count = row * column;
		int accsize = 0;// سجل عدد النقاط التي تمت زيارتها

		acc = new int[count];
		noacc = new int[count];

		// الإزاحة في كل اتجاه على الصف الإزاحة في كل اتجاه من اتجاهات العمود 0 يسار 1 يمين 3 أعلى 2 أسفل

		int[] offR = { -1, 1, 0, 0 };
		int[] offC = { 0, 0, 1, -1 };

		// إزاحة في أربعة اتجاهات ، يسار ، يمين ، أعلى ، أسفل
		int[] offS = { -1, 1, row, -row }; // تحريك لأعلى ولأسفل هو تغيير سطر واحد
		// في التهيئة التهيئة ، 0 يعني عدم الزيارة ، و 0 في noacc يعني عدم الزيارة
		for (int i = 0; i < count; i++) {
			acc[i] = 0;
			noacc[i] = 0;
		}

		// نقطة البداية
		Random rd = new Random();
		acc[0] = rd.nextInt(count);// نقطة البداية

		int pos = acc[0];
		// قم بإيداع النقطة الأولى
		noacc[pos] = 1;
		while (accsize < count) {
			// خذ النقطة الحالية
			int x = pos % row;
			int y = pos / row;// إحداثيات النقطة
			int offpos = -1;// تستخدم لتسجيل الإزاحة
			int w = 0;
			// حاول في جميع الاتجاهات الأربعة حتى تحصل عليها
			while (++w < 5) {
				// الوصول العشوائي إلى أقرب نقطة
				int point = rd.nextInt(4); // 0-3
				int repos;
				int move_x, move_y;
				// احسب اتجاه الحركة
				repos = pos + offS[point];// بعد نقل الرمز
				move_x = x + offR[point];// الموقف بعد التحرك
				move_y = y + offC[point];
				// تحديد ما إذا كانت الحركة قانونية
				if (move_y >= 0 && move_x >= 0 && move_x < row && move_y < column && repos >= 0 && repos < count
						&& noacc[repos] != 1) {
					noacc[repos] = 1;// ضع علامة على النقطة كما تمت زيارتها
					acc[++accsize] = repos; // ++ accsize النقطة التي تمت زيارتها ، ويمثل repos الرمز السفلي للنقطة
					pos = repos; // استخدم هذه النقطة كنقطة انطلاق
					offpos = point;
					// ضع 1 في منتصف الشبكة المجاورة

					map[2 * x + 1 + offR[point]][2 * y + 1 + offC[point]] = 1;
					break;
				} else {
					if (accsize == count - 1)
						return;
					continue;
				}
			}
			if (offpos < 0) {// لا أجد طريقة للتغلب على ذلك ، ابحث عن نقطة انطلاق جديدة من المسار الذي سلكته
				pos = acc[rd.nextInt(accsize + 1)];}
		}
	}
}


 class Mazegame2 {
    Scanner scan;
    Scanner user;
    int rows;
    int columns;
    String [][] maze;

    int x; //Player x-Position 
    int y; //Player y-Position
    boolean gotTreasure;

    /**
     * Konstruktor for the class.
     */
    public Mazegame2(){
        init(); 
        game();
        scan.close();
        user.close();  
    }

    /**
     * Initialisation of the maze and all attributes.
     */
    public void init(){
        user = new Scanner(System.in); //Scanner for Userinput

        /********************************
         * Scanning the maze from a file. 
         */
        //1. Open the file. Has to be in a try-catch-Bracket, because the file might not be there.
        try{
            scan = new Scanner(new File("maze.txt"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        //2. Scan the dimensions of the maze.
        rows = scan.nextInt();
        columns = scan.nextInt();
        scan.nextLine(); // So that the next Line can be scanned.

        maze = new String[rows][columns];//Create the maze-Array with the right dimensions.

        for (int i = 0; i < rows; i++){
            String temp = scan.nextLine(); //Scan one line.
            for (int j = 0; j < columns; j++){
                maze[i][j] = temp.substring(j, j+1);//Put every character in the maze
                if (maze[i][j].equals("P")){ //Look out for the Player-Position
                    x = j; 
                    y = i;
                }
            }
        }  
        gotTreasure = false;
    }

    /**
     * Prints the Input of the maze-Array. But only if the spots are visible by the player.
     */
    public void printMaze(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(maze[i][j]);
                System.out.print(" ");
        }
        System.out.println();
      }  
    }

    /**
     * Prints the possebilities to move by the player.
     */
    public void printUserPossebilities(){
        System.out.println();
        System.out.println("You may:");
        System.out.println("1) Move up");
        System.out.println("2) Move down");
        System.out.println("3) Move left");
        System.out.println("4) Move right");
        System.out.println("0) Quit");      
    }

    /**
     * 
     */
    public void update(int choice){
        int xdir=0; 
        int ydir=0;
        // Update the direction based on the userChoice
        switch (choice){
            case 0: System.exit(0);
            case 1: xdir = 0; ydir = -1; break;
            case 2: xdir = 0; ydir =1; break;
            case 3: xdir = -1; ydir = 0; break;
            case 4: xdir = 1; ydir = 0; break;
        }

        /**
         * Update the situation based on the current direction and step.
         */
        //1. Check if the new position is in the array.
        if (x+xdir >= 0 && x+xdir <columns && y+ydir >=0 && y+ydir < rows){
            //2. Check if a step is possible
            if (maze[y+ydir][x+xdir].equals("X")){
                System.out.println("Cannot move into a cave-in! Try something else.");
            }else{
                //3. clear the P from the old Position
                maze[y][x] =".";
                //4. Check if the Player is over the treasure
                if (maze[y+ydir][x+xdir].equals("T")){
                    gotTreasure = true;
                }
                x = x+xdir; 
                y = y + ydir; 
                maze[y][x] = "P"; //Show the new position of the player.
            }
        }else{
            System.out.println("That's not a possible Move.");
        }   
    }

    /**
     * The game-Methode that includes the game-loop and 
     */
    public void game(){
        while (!gotTreasure){
            printMaze(); 
            printUserPossebilities();
            int userInput = user.nextInt(); //Wait for userinput
            update(userInput);
        }

        printMaze();            
        System.out.println("Congratulations, you found the treasure!");  
    }

        Mazegame2 m = new Mazegame2();

    }


        class node {
	public int x, y;

	node() {
	}

	node(int a, int b) {
		x = a;
		y = b;
	}

	void set(int a, int b) {
		x = a;
		y = b;
	}
}


	public int Size = 8;// حجم الخريطة الفعال ، المستخدم لخوارزمية Prim لإنشاء الخريطة
	public static final int Range = 16;// طول جانب الخلية
	public int VSize = (Size * 2 + 1) * Range;// الحجم الفعلي للخريطة
	public int maze[][] = new int[VSize][VSize];// خريطة
	public int vis[][] = new int[VSize][VSize];// مسار الزيارة
	public node f[][] = new node[VSize][VSize];
	public int[][] dir = { { -Range, 0 }, { Range, 0 }, { 0, -Range }, { 0, Range } };// اتجاه الحركة
	public CreateMap c = new CreateMap(Size, Size);
	Rectangle rec = new Rectangle(Range, Range, Range, Range);
	private int recX = 16, recY = 16;
	private boolean autoPath = false;// ما إذا كان سيتم تشغيل دقة الصورة التلقائية
        
int count2=0;
	public void start(Scene scene) throws IOException {

		CreateMap();
		Pane pane = Init();// إنشاء منصة المتاهة
		mazePane.getChildren().addAll(pane);
		scene.setOnKeyPressed((KeyEvent k) -> {
                    
                         if (count1 == 1){
                          if (count2%2 == 0){
                      DropShadow shad= new DropShadow(200,Color.WHITE);
                      landmarks1.setEffect(shad);
                          }
                         if (count2%2!=0){
                      DropShadow shad= new DropShadow(50,Color.WHITE);
                      landmarks1.setEffect(shad);
                        }System.out.println(count2);count2++;}
                         
                    KeyCode code = k.getCode();
                    int tx = recX, ty = recY;
                    if (code.equals(KeyCode.LEFT)){System.out.println("left");}
                    if (code.equals(KeyCode.LEFT) && autoPath == false) { // الضغط على الزر الأيسر
                        tx -= Range;
                    } else if (code.equals(KeyCode.RIGHT) && autoPath == false) {// النقر بزر الماوس الأيمن
                        tx += Range;
                    } else if (code.equals(KeyCode.UP) && autoPath == false) {// الضغط على مفتاح السهم لأعلى
                        ty -= Range;
                    } else if (code.equals(KeyCode.DOWN) && autoPath == false) {// اضغط على مفتاح السهم لأسفل
                        ty += Range;
                    } else if (code.equals(KeyCode.SPACE)) {
                        if (autoPath == false) {
                            autoPath = true;
                            node e = new node();
                            e.set(recX, recY);
                            autoMove(e);
                        }
                    }
                    if (inside(tx, ty) && maze[tx][ty] == 1 && autoPath == false) {
                        // System.out.println(recX+" "+recY+" "+tx + " " + ty);
                        move(tx, ty);
                        recX = tx;
                        recY = ty;
                    } else if (recX == VSize - Range * 2 && recY == VSize - Range * 2) {try {
                        // تحديد الخروج عن الحدود وضرب الحائط

//***********************
                  incrementScore();
                System.out.println("score = "+ score + " level = "+ level);
                // Refrence : https://stackoverflow.com/questions/13246211/javafx-how-to-get-stage-from-controller-during-initialization
               FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("video.fxml"));
                Parent root =(Parent) loader.load();
                VideoController controller = loader.getController();
                myStage.setScene(new Scene(root));
                controller.setCountry(country);
                controller.setStage(myStage);
//****************########################



                        move(Range, Range);
                        recX = Range;
                        recY = Range;
                        } catch (IOException ex) {
                            Logger.getLogger(MazeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });


	}

	public void move(int tx, int ty) {
		SequentialTransition link = new SequentialTransition();// قائمة الرسوم المتحركة
		link.setNode(rec);
		TranslateTransition tt = new TranslateTransition();

		tt.setFromX(recX - 16);
		tt.setToX(tx - 16);
		tt.setFromY(recY - 16);
		tt.setToY(ty - 16);

		link.getChildren().add(tt);
		link.play();
	}

	public void CreateMap() {
		c.Init();// إنشاء متاهة
		for (int i = 0; i < VSize; i += Range) {
			for (int j = 0; j < VSize; j += Range) {
				maze[i][j] = c.map[i / Range][j / Range];
			}
		} // رسم خرائط المتاهة
	}

	public Pane Init() {
		Image boy =new Image("/image/student.png");
               Image grass =new Image("/image/tree.png");

		Pane pane = new Pane();
		for (int i = 0; i < VSize; i += Range) {
			for (int j = 0; j < VSize; j += Range) {
				Rectangle r = new Rectangle(i, j, Range, Range);
				if (maze[i][j] == 0) {
					r.setFill(new ImagePattern(grass));
				} else if (maze[i][j] == 1) {
					r.setFill(Color.TRANSPARENT);
				}
				if (i == VSize - Range && j == VSize - Range * 2) {
					r.setFill(Color.TRANSPARENT);
				}
				pane.getChildren().add(r);
			}
		}
		rec.setFill(new ImagePattern(boy));
		pane.getChildren().add(rec);// إظهار الكتلة المستهدفة
		return pane;
	}

	public void autoMove(node e) {
		SequentialTransition link = new SequentialTransition();// قائمة الرسوم المتحركة
		link.setNode(rec);
		Queue<node> queue = new ArrayBlockingQueue<node>(1000);
		int flag = 0;
		System.out.println(e.x + " " + e.y);
		queue.add(e);
		vis[e.x][e.y] = 1;// زار
		while (flag == 0) {// اتساع أول اجتياز ، ابحث عن أقصر طريق
			node now = queue.remove();
			for (int i = 0; i < 4; i++) {
				int fx = now.x + dir[i][0];
				int fy = now.y + dir[i][1];
				if ((inside(fx, fy) && (vis[fx][fy] == 0) && maze[fx][fy] == 1)) {
					vis[fx][fy] = 1;
					f[fx][fy] = new node(now.x, now.y);
					queue.add(new node(fx, fy));
				}
				if (fx == VSize - Range * 2 && fy == VSize - Range * 2) {// ابدأ التراجع عندما تصل إحدى الطرق إلى النهاية

					node ans[] = new node[1000];
					int cnt = 0;
					int t1, t2;
					ans[cnt] = new node(fx, fy);
					while (f[fx][fy].x != e.x || f[fx][fy].y != e.y) {// تتبع مرة أخرى وفقًا لإحداثيات النقطة السابقة التي سجلتها النقطة للحصول على أقصر مسار إلى النقطة.
						t1 = fx;
						t2 = fy;
						cnt++;
						ans[cnt] = new node(f[fx][fy].x, f[fx][fy].y);
						fx = f[t1][t2].x;
						fy = f[t1][t2].y;
					}

					ans[++cnt] = new node(0, 0);

					for (int l = cnt - 1; l > 0; l--) {
						
						TranslateTransition tt = new TranslateTransition();
						tt.setFromX(ans[l].x - 30);
						tt.setToX(ans[l - 1].x - 30);
						tt.setFromY(ans[l].y - 30);
						tt.setToY(ans[l - 1].y - 30);
						link.getChildren().add(tt);
					}
					flag = 1;
					break;

				}
			}
		}
		link.play();

	}

	boolean inside(int fx, int fy) {
		return (fx >= Range && fx <= VSize - Range && fy >= Range && fy <= VSize - Range);
	}}

