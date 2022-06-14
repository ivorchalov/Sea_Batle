import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static boolean startGame = false;

    public static int[][] allyField = new int[12][12];
    public static int[][] enemyField = new int[10][10];

    public static ArrayList<Cell> allyCellList = new ArrayList<>();
    public static ArrayList<Cell> enemyCellList = new ArrayList<>();
    public static ArrayList<Ship> ships = new ArrayList<>();

    public static Group group = new Group();
    public static Scene scene = new Scene(group, 1280, 960);

    public static void main(String[] args){ Application.launch(args); }

    @Override
    public void start(Stage primaryStage){

        primaryStage.setTitle("World of warships");
        primaryStage.setScene(scene);
        primaryStage.show();

        Field field = new Field();

        field.drawFields(group);
        enemyField = field.setEnemyField();
        drawShips(group);
    }

    public void drawShips(Group group){
        int x = 100;
        int y = 880;

        Ship sloop = new Ship(1,4);
        ships.add(sloop);
        sloop.drawShip(group, x, y);

        y -= 100;

        Ship destroyer = new Ship(2,3);
        ships.add(destroyer);
        destroyer.drawShip(group, x, y);

        y -= 100;

        Ship cruiser = new Ship(3,2);
        ships.add(cruiser);
        cruiser.drawShip(group, x, y);

        y -= 100;

        Ship battleship = new Ship(4,1);
        ships.add(battleship);
        battleship.drawShip(group, x, y);
    }
}

