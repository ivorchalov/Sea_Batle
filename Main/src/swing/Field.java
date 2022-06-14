import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Field {

    public static void drawFields(Group group){

        int x = 100;
        int y = 50;

        for(int i = 1; i < Main.allyField.length - 1; i++){
            for(int j = 1; j < Main.allyField.length - 1; j++){
                Cell cell = new Cell();
                cell.drawCell(group, x,y);
                cell.setI(i);
                cell.setJ(j);
                cell.setX(x);
                cell.setY(y);
                cell.setCurrentMatrixValue(Main.allyField[i][j]);
                Main.allyCellList.add(cell);
                x += 50;
            }
            x = 100;
            y += 50;
        }

        x = 700;
        y = 50;

        for(int i = 0; i < Main.enemyField.length; i++){
            for(int j = 0; j < Main.enemyField.length; j++){
                Cell cell = new Cell();
                cell.drawCell(group, x,y);
                cell.setI(i);
                cell.setJ(j);
                cell.setX(x);
                cell.setY(y);
                cell.setCurrentMatrixValue(Main.enemyField[i][j]);
                Main.enemyCellList.add(cell);
                x += 50;
            }
            x = 700;
            y += 50;
        }

        int x1 = 60;
        int x2 = 660;
        int y1 = 82;
        int y2 = 82;

        for(char i = 'A'; i <= 'J'; i++){
            Text text1 = new Text(Character.toString(i));
            text1.setX(x1);
            text1.setY(y1);
            text1.setFont(Font.font(28));
            group.getChildren().add(text1);
            y1 += 50;

            Text text2 = new Text(Character.toString(i));
            text2.setX(x2);
            text2.setY(y2);
            text2.setFont(Font.font(28));
            group.getChildren().add(text2);
            y2 += 50;
        }

        x1 = 115;
        x2 = 715;
        y = 38;

        for(int i = 1; i <= 10; i++){
            Text text1 = new Text(Integer.toString(i));
            text1.setX(x1);
            text1.setY(y);
            text1.setFont(Font.font(28));
            group.getChildren().add(text1);
            if(i == 9){
                x1 += 45;
            } else {
                x1 += 50;
            }

            Text text2 = new Text(Integer.toString(i));
            text2.setX(x2);
            text2.setY(y);
            text2.setFont(Font.font(28));
            group.getChildren().add(text2);
            if(i == 9){
                x2 += 45;
            } else {
                x2 += 50;
            }
        }
    }

    int[][] setEnemyField(){

        int index = (int)(Math.random() * 10);

        int[][] enemyField1 = {
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,0,0,0,0,0},
                {0,1,0,0,1,0,0,1,1,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,1,0,0},
                {1,0,0,1,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0,0},
                {0,1,1,0,0,0,0,0,0,0}
        };
        int[][] enemyField2 = {
                {1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,0,1,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,0},
                {0,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0}
        };
        int[][] enemyField3 = {
                {0,1,0,0,0,1,0,0,1,1},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,1},
                {0,0,0,0,0,1,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,1,0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0},
                {1,1,1,0,0,0,0,0,0,0}
        };
        int[][] enemyField4 = {
                {0,0,0,0,0,0,0,1,0,0},
                {0,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,1,0,0,0,0},
                {1,0,1,0,0,1,0,0,0,1},
                {0,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,1,1,1,0,0,0}
        };
        int[][] enemyField5 = {
                {1,0,1,0,0,1,1,0,0,1},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,1,0,0},
                {0,0,0,0,1,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,1},
                {0,0,1,1,1,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,1,1,0,0,0,0}
        };
        int[][] enemyField6 = {
                {0,0,0,0,1,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,1,0,0,0,1}
        };
        int[][] enemyField7 = {
                {0,0,0,1,0,0,1,0,0,0},
                {1,0,0,1,0,0,0,0,0,1},
                {0,0,0,1,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,0},
                {1,0,0,1,1,0,0,0,0,0},
                {1,0,0,0,0,0,0,1,1,1},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,0},
                {0,1,0,0,0,0,0,1,0,0}
        };
        int[][] enemyField8 = {
                {0,0,1,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,1,1,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,1,1,1},
                {0,0,0,0,1,0,0,0,0,0}
        };
        int[][] enemyField9 = {
                {0,0,0,0,0,1,1,0,0,0},
                {1,1,1,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,1},
                {0,0,1,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,1,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,0,0,0,1,0},
                {0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,1,0,0,0}
        };
        int[][] enemyField10 = {
                {0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,1},
                {0,1,0,0,0,1,1,0,0,1},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,1,1,1},
                {1,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,1,1,0,0,1,0},
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,1,0}
        };

        ArrayList<Object> fields = new ArrayList<>();
        fields.add(enemyField1);
        fields.add(enemyField2);
        fields.add(enemyField3);
        fields.add(enemyField4);
        fields.add(enemyField5);
        fields.add(enemyField6);
        fields.add(enemyField7);
        fields.add(enemyField8);
        fields.add(enemyField9);
        fields.add(enemyField10);

        int[][] buffField = (int[][]) fields.get(index);
        return buffField;
    }
}
