package swing;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

class Ship{
    private int health;
    private int countOfShips;
    private static int countOfTypesOfShips = 0;
    private static boolean vertical = true;
    static ArrayList<Ship> ships = new ArrayList<>();

    Ship(int health, int countOfShips){
        this.health = health;
        this.countOfShips = countOfShips;
    }
    Ship(){
        createShips();
    }

    public int getHealth(){
        return health;
    }

    public int getCountOfShips(){
        return countOfShips;
    }
    public void setCountOfShips(int countOfShips){
        this.countOfShips = countOfShips;
    }

    public int getCountOfTypesOfShips(){
        return countOfTypesOfShips;
    }

    public ArrayList<Ship> getShips(){
        return ships;
    }

    public static void setCountOfTypesOfShips(int countOfTypesOfShips) {
        Ship.countOfTypesOfShips = countOfTypesOfShips;
    }

    public void hitShip(){
        health--;
    }

    public void rotateShip(Scene scene){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
                vertical = !vertical;
                System.out.println(vertical);
            }
        });
    }

    public void createShips(){

        Ship fourDeckShip = new Ship(4,1);
        Ship threeDeckShip = new Ship(3,2);
        Ship doubleDeckShip = new Ship(2,3);
        Ship singleDeckShip = new Ship(1,4);

        ships.add(fourDeckShip);
        ships.add(threeDeckShip);
        ships.add(doubleDeckShip);
        ships.add(singleDeckShip);
    }

    public void setShip(int startX, int startY){
        Main main = new Main();

        for(int i = 0; i < health; i++){
            if(vertical){
                main.allyField[startX + i][startY] = 1;
            } else {
                main.allyField[startX][startY + i] = 1;
            }
        }

        for(int i = 1; i < main.allyField.length - 1; i++){
            for(int j = 1; j < main.allyField.length - 1; j++){
                System.out.print(main.allyField[i][j] + " ");
            }
            System.out.println();
        }
    }
}