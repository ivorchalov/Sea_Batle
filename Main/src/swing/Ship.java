package swing;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

class Ship{

    private int health;
    private int count;
    static int countOfTypes = 0;
    static int countOfShips = 10;
    boolean isSetOnField = false;

    Ship(int health, int count){
        this.health = health;
        this.count = count;
    }

    Ship(){
        System.out.println("Ok");
    }

    private boolean vertical = false;

    public int getHealth(){
        return health;
    }

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

    public int getCountOfTypes(){
        return countOfTypes;
    }
    public void setCountOfTypes(int countOfTypes) {
        Ship.countOfTypes = countOfTypes;
    }

    public void hitShip(){
        health--;
    }

    public void draw(Group group, int x, int y){
        int a = 1;
        int b = 1;
        if (vertical){
            b = health;
        } else {
            a = health;
        }
        for(int i = 0; i < count; i++){
            Rectangle rectangle = new Rectangle(x, y, a * 50,  b *50);
            rectangle.setFill(Color.BLUE);
            rectangle.setStroke(Color.BLACK);
            group.getChildren().add(rectangle);
            MouseDragged(rectangle);
            x += 100 + 50 * (health-1);
        }
    }

    public void rotate(Scene scene, Rectangle rectangle){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
                Rotate rotate = new Rotate();
                if (vertical){
                    rotate.setAngle(-90);
                } else {
                    rotate.setAngle(90);
                }
                vertical = !vertical;
                rotate.setPivotX(rectangle.getX()+25);
                rotate.setPivotY(rectangle.getY()+25);
                rectangle.getTransforms().add(rotate);
                System.out.println(vertical);
            }
        });
    }

    public void MouseDragged(Rectangle rectangle){
        rectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rectangle.setX(mouseEvent.getX()-25);
                rectangle.setY(mouseEvent.getY()-25);
            }
        });
        rectangle.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate(rectangle.getScene(), rectangle);
                System.out.println("Detected");
            }
        });

        rectangle.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("Over");
            }
        });
        rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                rotate(rectangle.getScene(), rectangle);

            }
        });
    }

//    public void create(){
//        Ship battleship = new Ship(4,1);
//        Ship cruiser = new Ship(3,2);
//        Ship destroyer = new Ship(2,3);
//        Ship sloop = new Ship(1,4);
//
//        ships.add(battleship);
//        ships.add(cruiser);
//        ships.add(destroyer);
//        ships.add(sloop);
//    }

    public void setShip(int i, int j){

        Cell cell = new Cell();

        for(int index = 0; index < health; index++){
            if(vertical){
                Main.allyField[i + index][j] = 1;
                int x = Main.allyCellList.get((i+index-1)*10+j-1).getX();
                int y = Main.allyCellList.get((i+index-1)*10+j-1).getY();
                cell.update(Main.group, x, y);
            } else {
                Main.allyField[i][j + index] = 1;
                int x = Main.allyCellList.get((i-1)*10+j+index-1).getX();
                int y = Main.allyCellList.get((i-1)*10+j+index-1).getY();
                cell.update(Main.group, x, y);
            }
        }

        for(int index1 = 1; index1 < Main.allyField.length - 1; index1++){
            for(int index2 = 1; index2 < Main.allyField.length - 1; index2++){
                System.out.print(Main.allyField[index1][index2] + " ");
            }
            System.out.println();
        }
    }
}








































