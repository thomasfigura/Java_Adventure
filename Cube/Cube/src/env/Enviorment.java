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
public class Enviorment extends JPanel{
    Observert obsert = new Observert(5, 0, 5);
    double aspect2 = 1.0;
    double fovy2 = .87;
    double near2 = .1;
    double far2 = 10;

    obsert.setPerspectiveMatrix(fovy2, aspect2, near2, far2);
    
    ArrayList<Wall> objects = new ArrayList<>();
    
    public void addObject(Wall t) {
        objects.add(t);
    }

    public void visualize(Wall t) {
        for(int i = 0; i < objects.size(); i++){

        }

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

    @Override
    public void paintComponent(Graphics graphics){
        for(int i = 0; i<objects.size(); i++){
            objects.get(i).drawWall(graphics);
        }
    }

}
