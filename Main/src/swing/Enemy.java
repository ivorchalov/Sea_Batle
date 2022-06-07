import java.util.ArrayList;

public class Enemy {
    static int n = 100;
    static String way = "";

    void hitField(){
        int index = (int)(Math.random() * n);
        int x = Main.allyCellList.get(index).getX();
        int y = Main.allyCellList.get(index).getY();
        int i = Main.allyCellList.get(index).getI();
        int j = Main.allyCellList.get(index).getJ();
        Main.allyCellList.get(index).setHitCell(true);
        Main.allyField[Main.allyCellList.get(index).getI()][Main.allyCellList.get(index).getJ()] -= 3;
        Main.allyCellList.get(index).update(Main.group, x, y, i, j);
        Main.allyCellList.remove(index);
        n -= 1;
    }

//    void damagedShip(int i, int j){
//       //вниз
//       if(i + 1 <= 10  && !Main.allyCellList.get((i+1)*10+j).isHitCell() && (way == "" || way == "down")){
//          if(Main.allyField[i+1][j] == 1){
//             way = "down";
//          } else {
//             way = "";
//          }
//          Main.allyField[i+1][j] -= 2;
//          Main.allyCellList.get((i+1)*10+j).update(Main.group, Main.allyCellList.get((i+1)*10+j).getX(), Main.allyCellList.get((i+1)*10+j).getY());
//          Main.allyCellList.remove((i+1)*10+j);
//       } else if (i - 1 >= 1 && !Main.allyCellList.get((i-1)*10+j).isHitCell() && (way == "" || way == "up")) {
//          if(Main.allyField[i-1][j] == 1){
//             way = "up";
//          } else {
//             way = "";
//          }
//          Main.allyField[i-1][j] -= 2;
//          Main.allyCellList.get((i-1)*10+j).update(Main.group, Main.allyCellList.get((i-1)*10+j).getX(), Main.allyCellList.get((i-1)*10+j).getY());
//          Main.allyCellList.remove((i-1)*10+j);
//       } else if (j + 1 <= 10 && !Main.allyCellList.get(i*10+j+1).isHitCell() && (way == "" || way == "right")) {
//          if(Main.allyField[i][j+1] == 1){
//             way = "right";
//          } else {
//             way = "";
//          }
//          Main.allyField[i][j+1] -= 2;
//          Main.allyCellList.get(i*10+j+1).update(Main.group, Main.allyCellList.get(i*10+j+1).getX(), Main.allyCellList.get(i*10+j+1).getY());
//          Main.allyCellList.remove(i*10+j+1);
//       } else {
//          if(Main.allyField[i][j-1] == 1){
//             way = "left";
//          } else {
//             way = "";
//          }
//          Main.allyField[i][j-1] -= 2;
//          Main.allyCellList.get(i*10+j-1).update(Main.group, Main.allyCellList.get(i*10+j-1).getX(), Main.allyCellList.get(i*10+j-1).getY());
//          Main.allyCellList.remove(i*10+j-1);
//       }
//    }

    int[][] setField(){

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

