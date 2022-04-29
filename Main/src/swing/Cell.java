package swing;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cell{

    private final int width = 50;
    private final int height = 50;
    private int currentMatrixValue;
    private int line;
    private int column;
    private boolean hitCell = false;

    public int getCurrentMatrixValue() {
        return currentMatrixValue;
    }

    public void setCurrentMatrixValue(int currentMatrixValue) {
        this.currentMatrixValue = currentMatrixValue;
    }

    public int getLine(){
        return line;
    }

    public void setLine(int line){
        this.line = line;
    }

    public int getColumn(){
        return column;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public boolean isHitCell() { return hitCell; }

    public void drawCell(int x, int y, Group group, boolean ally){
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        group.getChildren().add(rectangle);
        MouseClickedOnCell(rectangle, ally);
    }

    private void MouseClickedOnCell(Rectangle rectangle, boolean ally){
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(ally == true){
                    hitCell = true;
                    rectangle.setFill(Color.DARKGREY);
                    Ship count = new Ship();
                    if(count.getCountOfTypesOfShips() < 4){
                        if(count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips() > 0){

                            Ship ship = new Ship(
                                    count.getShips().get(count.getCountOfTypesOfShips()).getHealth(),
                                    count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips()
                            );

                            // Уменьшаем количество кораблей одного типа, которые нужно выставить на поле
                            count.getShips().get(count.getCountOfTypesOfShips()).setCountOfShips(
                                    count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips() - 1
                            );
                            System.out.println("Количество кораблей одного типа, которые нужно ещё выставить на поле: " + count.getShips().get(count.getCountOfTypesOfShips()).getCountOfShips());
                            ship.setShip(line, column);
                        } else {
                            count.setCountOfTypesOfShips(count.getCountOfTypesOfShips() + 1);
                            System.out.println("Количество типов кораблей: " + count.getCountOfTypesOfShips());
                        }
                        return;
                    }
                } else {
                    hitCell = true;
                    rectangle.setFill(Color.RED);
                    if(currentMatrixValue == 1){
                        rectangle.setFill(Color.BLUE);
                    }
                }
            }
        });
    }
}
