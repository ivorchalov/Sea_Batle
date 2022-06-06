import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

class Ship {

    private int health;
    private int count;
    static int countOfTypes = 0;
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

    public int getCountOfTypes() {
        return countOfTypes;
    }

    public void setCountOfTypes(int countOfTypes) {
        Ship.countOfTypes = countOfTypes;
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
                Rotate rotate = new Rotate();
                if (vertical) {
                    rotate.setAngle(-90);
                } else {
                    rotate.setAngle(90);
                }
                vertical = !vertical;
                rotate.setPivotX(rectangle.getX() + 25);
                rotate.setPivotX(rectangle.getY() + 25);
                rectangle.getTransforms().add(rotate);
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
                System.out.println("Xdet = " + event.getX() + " Ydet = " + event.getY());
            }
        });

        rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("over");
                int x0_field = 100;
                int y0_field = 50;
                if (event.getX() <= x0_field + 50 * 10 && event.getY() <= y0_field + 50 * 10) {
                    int x0_cell = (int) (event.getX() - (event.getX() % 50));
                    int y0_cell = (int) (event.getY() - (event.getY() % 50));
                    int j = (x0_cell - x0_field) / 50 + 1;
                    int i = (y0_cell - y0_field) / 50 + 1;
                    System.out.println("X = " + event.getX() + " Y = " + event.getY());
                    System.out.println("x0_cell = " + x0_cell + " y0_cell = " + y0_cell);
                    System.out.println("reli = " + i);
                    System.out.println("relj = " + j);
                    setShip(i, j);
                    group.getChildren().remove(rectangle);
                    vertical = false;
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

    public void setShip(int i, int j){

        Cell cell = new Cell();

        for (int index = 0; index < health; index++) {
            if (vertical) {
                Main.allyField[i + index][j] = 1;
                int x = Main.allyCellList.get((i + index - 1) * 10 + j - 1).getX();
                int y = Main.allyCellList.get((i + index - 1) * 10 + j - 1).getY();
                cell.update(Main.group, x, y);
            } else {
                Main.allyField[i][j + index] = 1;
                int x = Main.allyCellList.get((i - 1) * 10 + j + index - 1).getX();
                int y = Main.allyCellList.get((i - 1) * 10 + j + index - 1).getY();
                cell.update(Main.group, x, y);
            }
        }

        for (int index1 = 1; index1 < Main.allyField.length - 1; index1++) {
            for (int index2 = 1; index2 < Main.allyField.length - 1; index2++) {
                System.out.print(Main.allyField[index1][index2] + " ");
            }
            System.out.println();
        }
    }
}




























