import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Wall Class Depicts the Objects that are in the enviorment.
 * At the moment, each wall object is a plane determined by 1 set of coords and
 * the origin.
 * <p>
 * TODO, add non origin specification.
 * </p>
 * TODO 2: Add the abilitiy to have a diagonal Plane, not just an orthogonal
 * one.
 */
public class Wall {
    protected double xcoord;
    protected double ycoord;
    final double zcoord;
    protected int width;
    protected int height;
    ArrayList<Double[]> coords;
    ArrayList<Double[]> newPerspective;

    public Wall(int x, int y, int width, int height) {
        xcoord = x;
        ycoord = y;
        zcoord = 10;
        this.width = width;
        this.height = height;
        coords = new ArrayList<>();

        ArrayList<Double[]> newPerspective = new ArrayList<>();

        for (int i = 0; i < xcoord; i++) {
            for (int j = 0; j < ycoord; j++) {
                for (int k = 0; k < zcoord; k++) {
                    Double[] values = { (double) i, (double) j, (double) k };
                    coords.add(values);
                }
            }
        }
    }

    public double getXCoord() {
        return xcoord;
    }

    public double getYCoord() {
        return ycoord;
    }

    public double getZCoord() {
        return zcoord;
    }

    public ArrayList<Double[]> coordinates() {
        return coords;
    }

    public void setPerspective(ArrayList<Double[]> t) {
        newPerspective = t;
    }
}
