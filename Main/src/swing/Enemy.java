import java.util.ArrayList;

public class Enemy {
    static int n = 100;
//    static String way = "";

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
//       if(i + 1 <= 10  && !Main.allyCellList.get(((i+1)-1)*10+j).isHitCell() && (way == "" || way == "down")){
//           System.out.println(((i+1)-1)*10+j);
//          if(Main.allyField[i+1][j] == 2){
//             way = "down";
//          } else {
//             way = "";
//          }
//          Main.allyField[i+1][j] -= 3;
//          Main.allyCellList.get(((i+1)-1)*10+j).update(Main.group,Main.allyCellList.get(((i+1)-1)*10+j).getX(), Main.allyCellList.get(((i+1)-1)*10+j).getY(),i,j);
//          Main.allyCellList.remove(((i+1)-1)*10+j);
//       } else if (i - 1 >= 1 && !Main.allyCellList.get(((i-1)-1)*10+j).isHitCell() && (way == "" || way == "up")) {
//           System.out.println(((i-1)-1)*10+j);
//          if(Main.allyField[i-1][j] == 2){
//             way = "up";
//          } else {
//             way = "";
//          }
//          Main.allyField[i-1][j] -= 3;
//          Main.allyCellList.get(((i-1)-1)*10+j).update(Main.group, Main.allyCellList.get(((i-1)-1)*10+j).getX(), Main.allyCellList.get(((i-1)-1)*10+j).getY(),i,j);
//          Main.allyCellList.remove(((i-1)-1)*10+j);
//       }
//       else if (j + 1 <= 10 && !Main.allyCellList.get(i*10+j+1).isHitCell() && (way == "" || way == "right")) {
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
}

