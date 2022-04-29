package swing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static int[][] allyField = new int[12][12];
    public static int[][] enemyField = new int[12][12];

    public static ArrayList<Cell> allyCellList = new ArrayList<>();
    public static ArrayList<Cell> enemyCellList = new ArrayList<>();

    public static Group group = new Group();

    public static void main(String[] args){

        Application.launch(args);

        System.out.println(allyCellList.get(0).getI());
        System.out.println(allyCellList.get(0).getJ());
        System.out.println(allyCellList.get(99).getI());
        System.out.println(allyCellList.get(99).getJ());
    }

    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene(group, 1280, 720);
        primaryStage.setTitle("Sea battle");
        primaryStage.setScene(scene);
        primaryStage.show();

        drawFields(group);

        Ship rotate = new Ship(0, 0);
        rotate.rotateShip(scene);
   }

   public static void drawFields(Group group){

       int x = 100;
       int y = 50;

       for(int i = 1; i < allyField.length - 1; i++){
           for(int j = 1; j < allyField.length - 1; j++){
               Cell cell = new Cell();
               cell.drawCell(group, x,y, true);
               cell.setI(i);
               cell.setJ(j);
               cell.setX(x);
               cell.setY(y);
               cell.setCurrentMatrixValue(allyField[i][j]);
               allyCellList.add(cell);
               x += 50;
           }
           x = 100;
           y += 50;
       }

       x = 700;
       y = 50;

       for(int i = 1; i < enemyField.length - 1; i++){
           for(int j = 1; j < enemyField.length - 1; j++){
               Cell cell = new Cell();
               cell.drawCell(group, x,y, false);
               cell.setI(i);
               cell.setJ(j);
               cell.setX(x);
               cell.setY(y);
               cell.setCurrentMatrixValue(enemyField[i][j]);
               enemyCellList.add(cell);
               x += 50;
           }
           x = 700;
           y += 50;
       }
   }
}


//int[][] enemyField = {
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0},
//        {0,0,0,0,0,0,0,0,0,0}
//};

//    Line line2 = new Line(350,700,350,500);
//    line2.setStroke(Color.BLACK);
//    Rotate rotate2 = new Rotate();
//    rotate2.setAngle(-45);
//    rotate2.setPivotX(350);
//    rotate2.setPivotY(700);
//    line2.getTransforms().add(rotate2);