import javafx.event.EventHandler;
import javafx.scene.Group;
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

    public void setHitCell(boolean hitCell) {
        this.hitCell = hitCell;
    }

    public void update(Group group, int x, int y, int indI, int indY){
        Enemy enemy = new Enemy();
        Rectangle rectangle = new Rectangle();
        if (Main.allyField[indI][indY] == -1) {
            rectangle.setFill(Color.RED);
            enemy.hitField();
        } else if (Main.allyField[indI][indY] == 2) {
            rectangle.setFill(Color.BLUE);
        } else {
            rectangle.setFill(Color.DARKGREY);
        }
        rectangle.setStroke(Color.BLACK);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        group.getChildren().add(rectangle);
    }

    public void drawCell(Group group, int x, int y){
        Rectangle rectangle = new Rectangle(x, y, 50, 50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        group.getChildren().add(rectangle);
        mouseEvent(rectangle);
    }

    private void mouseEvent(Rectangle rectangle){
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (hitCell) return;
                Enemy enemy = new Enemy();
                hitCell = true;
                if (Main.enemyField[i][j] == 2) {
                    rectangle.setFill(Color.RED);
                    return;
                } else {
                    enemy.hitField();
                    rectangle.setFill(Color.DARKGREY);
                }
            }
        });
    }
}

