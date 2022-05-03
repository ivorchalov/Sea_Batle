package swing;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cell{

    private int currentMatrixValue;
    private int i;
    private int j;
    private int x;
    private int y;
    private boolean hitCell = false;

    public int getCurrentMatrixValue() {
        return currentMatrixValue;
    }
    public void setCurrentMatrixValue(int currentMatrixValue) {
        this.currentMatrixValue = currentMatrixValue;
    }

    public int getI(){
        return i;
    }
    public void setI(int i){
        this.i = i;
    }

    public int getJ(){
        return j;
    }
    public void setJ(int j){
        this.j = j;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isHitCell() { return hitCell; }

    public void update(Group group, int x, int y){
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.DARKGREY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        group.getChildren().add(rectangle);
    }

    public void drawCell(Group group, int x, int y, boolean ally){
        Rectangle rectangle = new Rectangle(x, y, 50, 50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        group.getChildren().add(rectangle);
        mouseEvent(rectangle, ally);
    }

    private void mouseEvent(Rectangle rectangle, boolean ally){
        if(ally){
            rectangle.setOnDragOver(new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent event) {
                    rectangle.setFill(Color.DARKGREY);
                    hitCell = true;
                    System.out.println("Ok");
                }
            });
//            rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
////
////                    if(count.getCountOfTypes() < 5) {
////                        if (Main.ships.get(count.getCountOfTypes()).getCount() == 0) {
////                            count.setCountOfTypes(count.getCountOfTypes() + 1);
////                            System.out.println("Количество типов кораблей: " + count.getCountOfTypes());
////                        }
////                        if (Main.ships.get(count.getCountOfTypes()).getCount() > 0) {
////                            // Уменьшаем количество кораблей одного типа, которые нужно выставить на поле
////                            Main.ships.get(count.getCountOfTypes()).setCount(
////                                    Main.ships.get(count.getCountOfTypes()).getCount() - 1
////                            );
////                            Ship ship = new Ship(
////                                    Main.ships.get(count.getCountOfTypes()).getHealth(),
////                                    Main.ships.get(count.getCountOfTypes()).getCount()
////                            );
////
////                            System.out.println("Количество кораблей одного типа, которые нужно ещё выставить на поле: " + Main.ships.get(count.getCountOfTypes()).getCount());
////                            ship.setShip(i, j);
////                        }
////                    }
//                }
//            });
        } else {
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        }
    }
}
