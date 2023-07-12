public class Observer {
    protected int xcoord;
    protected int ycoord;
    protected int zcoord;

    public Observer(int x, int y, int z) {
        xcoord = x;
        ycoord = y;
        zcoord = z;
    }

    public int getXCoord() {
        return xcoord;
    }

    public int getYCoord() {
        return ycoord;
    }

    public int getZCoord() {
        return zcoord;
    }
}
