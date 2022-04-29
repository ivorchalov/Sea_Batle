package swing;

import javafx.scene.Group;
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

    public void updateCell(Group group, int x, int y){
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
        MouseClickedOnCell(rectangle, ally);
    }

    private void MouseClickedOnCell(Rectangle rectangle, boolean ally){
        rectangle.setOnMouseClicked(event -> {
            if(ally){
                hitCell = true;
                Ship count = new Ship();

                if(count.getCountOfTypesOfShips() < 5){
                    if(count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips() == 0){
                        count.setCountOfTypesOfShips(count.getCountOfTypesOfShips() + 1);
                        System.out.println("Количество типов кораблей: " + count.getCountOfTypesOfShips());
                    }
                    if(count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips() > 0){
                        // Уменьшаем количество кораблей одного типа, которые нужно выставить на поле
                        count.getShips().get(count.getCountOfTypesOfShips()).setCountOfShips(
                                count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips() - 1
                        );
                        Ship ship = new Ship(
                                count.getShips().get(count.getCountOfTypesOfShips()).getHealth(),
                                count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips()
                        );

                        System.out.println("Количество кораблей одного типа, которые нужно ещё выставить на поле: " + count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips());
                        ship.setShip(i, j);
                    }
                }
            } else {
                hitCell = true;
                rectangle.setFill(Color.RED);
                if(currentMatrixValue == 1){
                    rectangle.setFill(Color.BLUE);
                }
            }
        });
    }
}
