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
    private boolean ally;
    Rectangle cell = new Rectangle();

    public void setAlly(boolean ally) {
        this.ally = ally;
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

    public void update(Group group, int x, int y, int indI, int indJ){
        Enemy enemy = new Enemy();

        if (Main.allyField[indI][indJ] == -1) {
            cell.setFill(Color.RED);
            enemy.hitField();
        } else if (Main.allyField[indI][indJ] == 2) {
            cell.setFill(Color.BLUE);
        } else {
            cell.setFill(Color.DARKGREY);
        }
    }

    public void drawCell(Group group, int x, int y){
        cell.setFill(Color.WHITE);
        cell.setStroke(Color.BLACK);
        cell.setX(x);
        cell.setY(y);
        cell.setWidth(50);
        cell.setHeight(50);
        group.getChildren().add(cell);
        mouseEvent(cell);
    }

    private void mouseEvent(Rectangle rectangle){
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!ally){
                    if (hitCell) return;
                    Enemy enemy = new Enemy();
                    hitCell = true;
                    if (Main.enemyField[i][j] == 1) {
                        rectangle.setFill(Color.RED);
                        return;
                    } else {
                        enemy.hitField();
                        rectangle.setFill(Color.DARKGREY);
                    }
                }
            }
        });
    }
}

