package swing;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    //    Line line2 = new Line(350,700,350,500);
    //    line2.setStroke(Color.BLACK);
    //    Rotate rotate2 = new Rotate();
    //    rotate2.setAngle(-45);
    //    rotate2.setPivotX(350);
    //    rotate2.setPivotY(700);
    //    line2.getTransforms().add(rotate2);

        Group group = new Group();
        Scene scene = new Scene(group, 1280, 720);
        primaryStage.setTitle("Hello world");
        primaryStage.setScene(scene);
        primaryStage.show();

        int[][] allyField = new int[10][10];
        int[][] enemyField = new int[10][10];

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
        //        {0,0,0,0,0,0,0,0,0,0},
        //        {0,0,0,0,0,0,0,0,0,0}
        //};

        ArrayList<Cell> allyCellList = new ArrayList<>();
        ArrayList<Cell> enemyCellList = new ArrayList<>();

        int x = 100;
        int y = 50;

        for(int i = 0; i < allyField.length; i++){
            for(int j = 0; j < allyField.length; j++){
                Cell cell = new Cell();
                cell.drawCell(x,y, group, true);
                cell.setLine(i);
                cell.setColumn(j);
                allyCellList.add(cell);
                x += 50;
            }
            x = 100;
            y += 50;
        }

        x = 700;
        y = 50;

        for(int i = 0; i < enemyField.length; i++){
            for(int j = 0; j < enemyField.length; j++){
                Cell cell = new Cell();
                cell.drawCell(x,y, group, false);
                cell.setLine(i);
                cell.setColumn(j);
                enemyCellList.add(cell);
                x += 50;
            }
            x = 700;
            y += 50;
        }

        System.out.println(allyCellList.get(0).getLine());
        System.out.println(allyCellList.get(0).getColumn());
        System.out.println(allyCellList.get(99).getLine());
        System.out.println(allyCellList.get(99).getColumn());
   }
}

class Ship{
    private int health = 4;
    private int countOfShips = 10;
    private boolean vertical = true;


    public void setShip(Scene scene){
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                vertical = false;
                System.out.println(vertical);
            }
        });
        for(int i = 0; i < health; i++){

        }
    }
}

class Cell{

    private final int width = 50;
    private final int height = 50;
    private int line;
    private int column;
    private boolean hitCell = false;

    public int getLine(){
        return line;
    }

    public void setLine(int line){
        this.line = line;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public boolean isHitCell() { return hitCell; }

    public void drawCell(int x, int y, Group group, boolean ally){
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        group.getChildren().add(rectangle);
        MouseClickedOnCell(rectangle, ally);
    }

    private void MouseClickedOnCell(Rectangle rectangle, boolean ally){
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(ally == true){
                    System.out.println("Ally field");
                    hitCell = true;
                    System.out.println(hitCell);
                    rectangle.setFill(Color.DARKGREY);
                } else {
                    System.out.println("Enemy field");
                    hitCell = true;
                    System.out.println(hitCell);
                    rectangle.setFill(Color.RED);
                }
            }
        });
    }
}
