import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Ship {
    private int health;
    private int count;
    static int allyShipsHealth = 20;
    static int enemyShipsHealth = 20;
    static int countOfShips = 10;

    Ship(int health, int count) {
        this.health = health;
        this.count = count;
    }

    private boolean vertical = false;

    public void drawShip(Group group, int x, int y) {
        int a = 1;
        int b = 1;
        if (vertical) {
            b = health;
        } else {
            a = health;
        }
        for (int i = 0; i < count; i++) {
            Rectangle ship = new Rectangle(x, y, a * 50, b * 50);
            ship.setFill(Color.CYAN);
            ship.setStroke(Color.BLACK);
            group.getChildren().add(ship);
            MouseDragged(ship);
            x += 100 + 50 * (health - 1);
        }
    }

    public void rotate(Scene scene, Rectangle ship) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.SPACE) {
                if (vertical) {
                    ship.setWidth(health * 50);
                    ship.setHeight(50);
                } else {
                    ship.setWidth(50);
                    ship.setHeight(health * 50);
                }
                vertical = !vertical;
            }
        });
    }

    public void MouseDragged(Rectangle ship) {

        ship.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ship.setX(mouseEvent.getX() - 25);
                ship.setY(mouseEvent.getY() - 25);
            }
        });
        ship.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate(ship.getScene(), ship);
            }
        });

        ship.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x0_field = 100;
                int y0_field = 50;
                if (event.getX() <= x0_field + 50 * 10 && event.getY() <= y0_field + 50 * 10) {
                    int x0_cell = (int) (event.getX() - (event.getX() % 50));
                    int y0_cell = (int) (event.getY() - (event.getY() % 50));
                    int j = (x0_cell - x0_field) / 50 + 1;
                    int i = (y0_cell - y0_field) / 50 + 1;
                    setShip(i, j, ship);
                    vertical = false;
                }
            }
        });
    }


    public void setShip(int i, int j, Rectangle ship){

        if(vertical){
            for(int ind = i; ind < i+health; ind++){
                if (ind >= 1 && ind <= 10 && Main.allyField[ind][j] >= 1) return;
            }
        } else {
            for(int ind = j; ind < j+health; ind++){
                if (ind >= 1 && ind <= 10 && Main.allyField[i][ind] >= 1) return;
            }
        }


        for (int index = 0; index < health; index++) {
            if (vertical) {
                Main.allyField[i + index][j] = 2;
                for(int ind1 = i-1; ind1 <= (i+health); ind1++){
                    for(int ind2 = j-1; ind2 <= j+1; ind2++){
                        if(ind1 >= 1 && ind1 <= 10 && ind2 >=1 && ind2 <= 10 && Main.allyField[ind1][ind2] != 2){
                            Main.allyField[ind1][ind2] = 1;
                        }
                    }
                }
                Main.allyCellList.get((i+index-1)*10+j-1).update(i + index, j);
            } else {
                for(int ind1 = i-1; ind1 <= (i+1); ind1++){
                    for(int ind2 = j-1; ind2 <= j+health; ind2++){
                        if(ind1 >= 1 && ind1 <= 10 && ind2 >=1 && ind2 <= 10 && Main.allyField[ind1][ind2] != 2){
                            Main.allyField[ind1][ind2] = 1;
                        }
                    }
                }
                Main.allyField[i][j + index] = 2;
                Main.allyCellList.get((i-1)*10+j-1+index).update(i, j + index);
            }
        }
        countOfShips -= 1;
        Main.group.getChildren().remove(ship);
    }
}
