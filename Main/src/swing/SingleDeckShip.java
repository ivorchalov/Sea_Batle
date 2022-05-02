package swing;

import javafx.scene.Group;
import javafx.scene.Scene;

public class SingleDeckShip extends Ship{

    SingleDeckShip(int health, int count) {
        super(health, count);
    }

    @Override
    public void rotate(Scene scene) {
        super.rotate(scene);
    }

    @Override
    public void draw(Group group, int x, int y) {
        super.draw(group, x, y);
    }
}
