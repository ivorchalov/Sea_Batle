package swing;
import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args){
        JFrame jFrame = getFrame();
        jFrame.add(new MyComponent());
    }
    static class MyComponent extends JComponent{
        @Override
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            g2.setPaint(Color.black);
            g2.drawRect(10,10,1240,860);

            int x1 = 80;
            int y1 = 220;
            int x2 = 530;
            int y2 = 220;
            int i = 0;
            int j = 0;
            char alphabet = 'a';

            while(i < 10 && alphabet <= 'k'){
                while (j < 10) {
                    g2.drawString(String.valueOf(j + 1), x1 + 16, 210);
                    g2.drawString(String.valueOf(j + 1), x2 + 16, 210);
                    g2.drawString(String.valueOf(alphabet), 60, y1 + 23);
                    g2.drawString(String.valueOf(alphabet), 510, y2 + 23);
                    g2.drawRect(x1,y1,40,40);
                    g2.drawRect(x2,y2,40,40);
                    j += 1;
                    x1 += 40;
                    x2 += 40;
                }
                alphabet += 1;
                j = 0;
                i += 1;
                x1 = 80;
                x2 = 530;
                y1 += 40;
                y2 += 40;
            }

            g2.drawRect(970,220,240,400);
        }
    }
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 640, dimension.height/2 - 460, 1280, 920);
        jFrame.setTitle("World of Warships");
        return jFrame;
    }
}
