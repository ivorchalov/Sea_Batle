
public class Enemy {
    static int n = 100;

    void hitField(){
        int index = (int)(Math.random() * n);
        if (!Main.allyCellList.get(index).isHitCell()){
            int x = Main.allyCellList.get(index).getX();
            int y = Main.allyCellList.get(index).getY();
            int i = Main.allyCellList.get(index).getI();
            int j = Main.allyCellList.get(index).getJ();
            Main.allyCellList.get(index).setHitCell(true);
            Main.allyField[Main.allyCellList.get(index).getI()][Main.allyCellList.get(index).getJ()] -= 3;
            Main.allyCellList.get(index).update(i, j);
        } else {
            hitField();
        }
    }
}

