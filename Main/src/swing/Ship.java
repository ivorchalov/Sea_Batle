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
    public void setCountOfTypesOfShips(int countOfTypesOfShips) {
        Ship.countOfTypesOfShips = countOfTypesOfShips;
    }
    public ArrayList<Ship> getShips(){
        return ships;
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
        Ship antiBugShip = new Ship(0,0);
        Ship fourDeckShip = new Ship(4,1);
        Ship threeDeckShip = new Ship(3,2);
        Ship doubleDeckShip = new Ship(2,3);
        Ship singleDeckShip = new Ship(1,4);

        ships.add(antiBugShip);
        ships.add(fourDeckShip);
        ships.add(threeDeckShip);
        ships.add(doubleDeckShip);
        ships.add(singleDeckShip);
    }

    public void setShip(int i, int j){

        Cell cell = new Cell();

        for(int index = 0; index < health; index++){
            if(vertical){
                Main.allyField[i + index][j] = 1;
                cell.updateCell(Main.group,Main.allyCellList.get((i+index-1)*10+j-1).getX(), Main.allyCellList.get((i+index-1)*10+j-1).getY());
            } else {
                Main.allyField[i][j + index] = 1;
                cell.updateCell(Main.group, Main.allyCellList.get((i-1)*10+j+index-1).getX(), Main.allyCellList.get((i-1)*10+j+index-1).getY());
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