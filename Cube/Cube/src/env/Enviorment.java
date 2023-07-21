package env;

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

public class Enviorment extends JPanel {
    ArrayList<Wall> objects;
    Observert obsert;
    Graphics graphics;
    final int IMAGE_SIZE = 400;

    public Enviorment() {
        double aspect2 = 1.0;
        double fovy2 = .87;
        double near2 = .1;
        double far2 = 10;
        obsert = new Observert(5, 0, 5);
        obsert.setPerspectiveMatrix(fovy2, aspect2, near2, far2);
        objects = new ArrayList<>();
        Wall w = new Wall(0, 10, 200, 200);
        addObject(w);

    }

    public void addObject(Wall t) {
        objects.add(t);
    }

    public void visualize(Wall t) {
        ArrayList<Double[]> newP = new ArrayList<>();
        for (int i = 0; i < t.coords.size(); i++) {
            newP.add(obsert.perspectiveMatrixMultiply(t.coords.get(i)));
        }
        t.setPerspective(newP);
    }

    public void makeVisualize() {
        if (objects.size() != 0) {
            for (int i = 0; i <= objects.size(); i++) {
                visualize(objects.get(i));
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);
        for (int i = 0; i < objects.size(); i++) {
            visualize(objects.get(i));
            objects.get(i).drawWall(graphics);
        }
    }
}
