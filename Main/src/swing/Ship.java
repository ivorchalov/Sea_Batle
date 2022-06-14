import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Ship {
    private int health;
    private int count;
    static int countOfShips = 10;
    boolean isSetOnField = false;

    Ship(int health, int count) {
        this.health = health;
        this.count = count;
    }

    private boolean vertical = false;

    public int getHealth() {
        return health;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void hitShip() {
        health--;
    }

    public void drawShip(Group group, int x, int y) {
        int a = 1;
        int b = 1;
        if (vertical) {
            b = health;
        } else {
            a = health;
        }
        for (int i = 0; i < count; i++) {
            Rectangle rectangle = new Rectangle(x, y, a * 50, b * 50);
            rectangle.setFill(Color.BLUE);
            rectangle.setStroke(Color.BLACK);
            group.getChildren().add(rectangle);
            MouseDragged(rectangle, group);
            x += 100 + 50 * (health - 1);
        }
    }

    public void rotate(Scene scene, Rectangle rectangle) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.SPACE) {
                if (vertical) {
                    rectangle.setWidth(health * 50);
                    rectangle.setHeight(50);
                } else {
                    rectangle.setWidth(50);
                    rectangle.setHeight(health * 50);
                }
                vertical = !vertical;
                System.out.println(vertical);
            }
        });
    }

    public void MouseDragged(Rectangle rectangle, Group group) {
        rectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rectangle.setX(mouseEvent.getX() - 25);
                rectangle.setY(mouseEvent.getY() - 25);
            }
        });
        rectangle.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rotate(rectangle.getScene(), rectangle);
            }
        });

        rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int x0_field = 100;
                int y0_field = 50;
                if (event.getX() <= x0_field + 50 * 10 && event.getY() <= y0_field + 50 * 10) {
                    int x0_cell = (int) (event.getX() - (event.getX() % 50));
                    int y0_cell = (int) (event.getY() - (event.getY() % 50));
                    int j = (x0_cell - x0_field) / 50 + 1;
                    int i = (y0_cell - y0_field) / 50 + 1;
                    setShip(i, j, rectangle);
                }
            }
        });

        rectangle.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("Over");
            }
        });
    }


    public void setShip(int i, int j, Rectangle rectangle){

        Cell cell = new Cell();
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
                int x = Main.allyCellList.get((i + index - 1) * 10 + j - 1).getX();
                int y = Main.allyCellList.get((i + index - 1) * 10 + j - 1).getY();
                cell.update(Main.group, x, y, i, j);
            } else {
                for(int ind1 = i-1; ind1 <= (i+1); ind1++){
                    for(int ind2 = j-1; ind2 <= j+health; ind2++){
                        if(ind1 >= 1 && ind1 <= 10 && ind2 >=1 && ind2 <= 10 && Main.allyField[ind1][ind2] != 2){
                            Main.allyField[ind1][ind2] = 1;
                        }
                    }
                }
                Main.allyField[i][j + index] = 2;
                int x = Main.allyCellList.get((i - 1) * 10 + j + index - 1).getX();
                int y = Main.allyCellList.get((i - 1) * 10 + j + index - 1).getY();
                cell.update(Main.group, x, y, i, j);
            }
        }
        Main.group.getChildren().remove(rectangle);

        for (int index1 = 1; index1 < Main.allyField.length - 1; index1++) {
            for (int index2 = 1; index2 < Main.allyField.length - 1; index2++) {
                System.out.print(Main.allyField[index1][index2] + " ");
            }
            System.out.println();
        }
    }
}




























