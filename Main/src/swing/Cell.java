import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Cell{

    private int i;
    private int j;
    private int x;
    private int y;
    private boolean hitCell = false;
    private boolean ally = true;

    Rectangle cell = new Rectangle();

    public void setAlly(boolean ally) {
        this.ally = ally;
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

    public void update(int i, int j){
        Enemy enemy = new Enemy();
        if (Main.allyField[i][j] == -1) {
            cell.setFill(Color.RED);
            Ship.allyShipsHealth--;
            if(Ship.allyShipsHealth == 0){
                Main main = new Main();
                main.showWhoIsWin();
                Platform.exit();
            }
            enemy.hitField();
        } else if (Main.allyField[i][j] == 2) {
            cell.setFill(Color.CYAN);
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

    private void mouseEvent(Rectangle cell){
        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!ally && Ship.countOfShips == 0){
                    if (hitCell) return;
                    Enemy enemy = new Enemy();
                    hitCell = true;
                    Main.countOfSteps++;
                    if (Main.enemyField[i][j] == 1) {
                        cell.setFill(Color.RED);
                        Ship.enemyShipsHealth--;
                        if(Ship.enemyShipsHealth == 0){
                            Main main = new Main();
                            main.showWhoIsWin();
                            Platform.exit();
                        }
                        return;
                    } else {
                        enemy.hitField();
                        cell.setFill(Color.DARKGREY);
                    }
                }
            }
        });
    }
}



