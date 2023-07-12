import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This Class Contains all the information of the Objectes that are in the
 * enviorment.
 * Currently all the Objects are orthogonal planes.
 * <p>
 * TODO: Make that observer be able to Move
 * </p>
 */
public class Enviorment {
    Observer obs = new Observer(5, 0, 5);
    ArrayList<Wall> objects = new ArrayList<>();


    public void addObject(Wall t) {
        objects.add(t);
    }

    public void visualize(Wall t) {

        ArrayList<Double[]> newP = new ArrayList<>();
        t.setPerspective(newP);
    }

    public void makeVisualize() {
        if (objects.size() != 0) {
            for (int i = 0; i < objects.size(); i++) {
                visualize(objects.get(i));
            }
        }
    }

}
