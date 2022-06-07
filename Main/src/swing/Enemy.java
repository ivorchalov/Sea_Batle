import java.util.ArrayList;

public class Enemy {
    static int n = 100;
    static String way = "";
    private boolean isRandom = true;

    public void setIsNotRandom(){
        isRandom = false;
    }

    void hitField(int i, int j){
        if (isRandom){
            int index = (int)(Math.random() * n);
            int x = Main.allyCellList.get(index).getX();
            int y = Main.allyCellList.get(index).getY();
            int indI = Main.allyCellList.get(index).getI();
            int indJ = Main.allyCellList.get(index).getJ();
            System.out.println("Hit " + indI + " " + indJ);
            Main.allyCellList.get(index).setHitCell(true);
            Main.allyField[Main.allyCellList.get(index).getI()][Main.allyCellList.get(index).getJ()] -= 3;
            Main.allyCellList.get(index).update(Main.group, x, y, indI, indJ);
            Main.allyCellList.remove(index);
            n -= 1;
        } else {
            System.out.println("Not random " + i + " " + j);
            damagedShip(i, j);
        }
    }

    void damagedShip(int i, int j){
       //вниз
       if(i + 1 <= 10  && !Main.allyCellList.get((i+1)*10+j).isHitCell() && (way == "" || way == "down")){
          Main.allyField[i+1][j] -= 3;
          int index = (i-1)*10+j;
          Main.allyCellList.get(index).update(Main.group, Main.allyCellList.get(index).getX(), Main.allyCellList.get(index).getY(), i+1, j);
          Main.allyCellList.remove(index);
           System.out.println(index);
           if(Main.allyField[i+1][j] == 2){
               way = "down";
           } else if(Main.allyField[i-1][j] == 2){
               way = "up";
           } else if (Main.allyField[i][j+1] == 2){
               way = "right";
           } else if (Main.allyField[i][j-1] == 2){
               way = "left";
           } else {
               isRandom = true;
               way = "";
           }
       } else if (i - 1 >= 1 && !Main.allyCellList.get((i-1)*10+j).isHitCell() && (way == "" || way == "up")) {
          Main.allyField[i-1][j] -= 3;
          int index = (i-3)*10+j;
          Main.allyCellList.get(index).update(Main.group, Main.allyCellList.get(index).getX(), Main.allyCellList.get(index).getY(), i-1, j);
          Main.allyCellList.remove(index);
           System.out.println(index);
           if(Main.allyField[i-1][j] == 2){
               way = "up";
           } else if (Main.allyField[i+1][j] == 2){
               way = "down";
           } else if (Main.allyField[i][j+1] == 2){
               way = "right";
           } else if (Main.allyField[i][j-1] == 2){
               way = "left";
           } else {
               isRandom = true;
               way = "";
           }
       } else if (j + 1 <= 10 && !Main.allyCellList.get(i*10+j+1).isHitCell() && (way == "" || way == "right")) {
          Main.allyField[i][j+1] -= 3;
          int index = (i-1)*10+j+1;
          Main.allyCellList.get(index).update(Main.group, Main.allyCellList.get(index).getX(), Main.allyCellList.get(index).getY(), i, j+1);
          Main.allyCellList.remove(index);
           System.out.println(index);
           if(Main.allyField[i][j+1] == 2){
               way = "right";
           } if (Main.allyField[i+1][j] == 2){
               way = "down";
           } else if (Main.allyField[i-1][j] == 2){
               way = "up";
           } else if (Main.allyField[i][j-1] == 2){
               way = "left";
           } else {
               isRandom = true;
               way = "";
           }
       } else {
          Main.allyField[i][j-1] -= 3;
          int index = (i-1)*10+j-1;
          Main.allyCellList.get(index).update(Main.group, Main.allyCellList.get(index).getX(), Main.allyCellList.get(index).getY(), i, j-1);
          Main.allyCellList.remove(index);
           System.out.println(index);
           if(Main.allyField[i][j-1] == 2){
               way = "left";
           } else if(Main.allyField[i][j+1] == 2){
               way = "right";
           } else if (Main.allyField[i+1][j] == 2){
               way = "down";
           } else if (Main.allyField[i-1][j] == 2){
               way = "up";
           } else {
               isRandom = true;
               way = "";
           }
       }
        System.out.println("damaged func: " + way + " " + i + " " + j + " " + isRandom);
    }

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

