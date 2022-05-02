package swing;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

abstract class Ship{
    private int health;
    private int count;
    //private static int countOfTypes = 0;
    private static boolean vertical = false;
    static ArrayList<Ship> ships = new ArrayList<>();

    Ship(int health, int count){
        this.health = health;
        this.count = count;
    }
//    Ship(){
//        createShips();
//    }

    public int getHealth(){
        return health;
    }

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

//    public int getCountOfTypes(){
//        return countOfTypes;
//    }
//    public void setCountOfTypes(int countOfTypes) {
//        Ship.countOfTypes = countOfTypes;
//    }

//    public ArrayList<Ship> getShips(){
//        return ships;
//    }

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

    public void rotate(Scene scene){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
                vertical = !vertical;
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
    }



//    public void createShips(){
//        Ship antiBugShip = new Ship(0,0);
//        Ship fourDeckShip = new Ship(4,1);
//        Ship threeDeckShip = new Ship(3,2);
//        Ship doubleDeckShip = new Ship(2,3);
//        Ship singleDeckShip = new Ship(1,4);
//
//        ships.add(antiBugShip);
//        ships.add(fourDeckShip);
//        ships.add(threeDeckShip);
//        ships.add(doubleDeckShip);
//        ships.add(singleDeckShip);
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








































