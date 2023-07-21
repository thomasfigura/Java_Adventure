package env;

import java.lang.Math;

public class Observert {
    protected int xcoord;
    protected int ycoord;
    protected int zcoord;
    public double[][] projectionMatrix;

    public Observert(int x, int y, int z) {
        xcoord = x;
        ycoord = y;
        zcoord = z;
        projectionMatrix = new double[4][4];
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

    public void setOrthogonalMatrix(double left, double right, double top, double bottom, double near, double far) {
        projectionMatrix = new double[4][4];
        projectionMatrix[0][0] = 2.0 / (right - left);
        projectionMatrix[1][1] = 2.0 / (bottom - top);
        projectionMatrix[2][2] = 1.0 / (far - near);
        projectionMatrix[3][0] = -(right + left) / (right - left);
        projectionMatrix[3][1] = -(bottom + top) / (bottom - top);
        projectionMatrix[3][2] = -near / (far - near);
    }

    public void setPerspectiveMatrix(double fovy, double aspect, double near, double far) {
        double tanHalfFovy = Math.tan(fovy / 2.0);
        projectionMatrix = new double[4][4];
        projectionMatrix[0][0] = 1.0 / (aspect * tanHalfFovy);
        projectionMatrix[1][1] = 1.0 / (tanHalfFovy);
        projectionMatrix[2][2] = far / (far - near);
        projectionMatrix[2][3] = 1.0;
        projectionMatrix[3][2] = -(far * near) / (far - near);
    }

    public Double[] perspectiveMatrixMultiply(Double[] coords) {
        Double[] n = new Double[4];
        for (int i = 0; i <= 3; i++) {
            double sum = 0.0;
            for (int j = 0; j <= 3; j++) {
                sum += (projectionMatrix[i][j] * coords[j]);
            }
            n[i] = sum;
        }
        return n;
    }
}
