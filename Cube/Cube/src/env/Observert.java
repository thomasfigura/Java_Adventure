package env;

import java.lang.Math;
import env.MatrixMath;

public class Observert {
    protected int xcoord;
    protected int ycoord;
    protected int zcoord;
    public double[][] projectionMatrix;
    public double[][] viewMatrix;

    public Observert(int x, int y, int z) {
        xcoord = x;
        ycoord = y;
        zcoord = z;
        projectionMatrix = new double[4][4];
        viewMatrix = new double[4][4];
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

    public void setViewDirection(Double[] position, Double[] direction, Double[] up) {
        Double[] up2 = { 0.0, -1.0, 0.0, 1.0 };
        Double[] w = MatrixMath.normailize(direction);
        Double[] u = MatrixMath.normailize(MatrixMath.crossProduct3D(w, up2));
        Double[] v = MatrixMath.crossProduct3D(w, u);

        viewMatrix[0][0] = u[0];
        viewMatrix[0][1] = u[1];
        viewMatrix[0][2] = u[2];
        viewMatrix[1][0] = v[0];
        viewMatrix[1][1] = v[1];
        viewMatrix[1][2] = v[2];
        viewMatrix[2][0] = w[0];
        viewMatrix[2][1] = w[1];
        viewMatrix[2][2] = w[2];
        viewMatrix[0][3] = -MatrixMath.dotProduct(u, position);
        viewMatrix[1][3] = -MatrixMath.dotProduct(v, position);
        viewMatrix[2][3] = -MatrixMath.dotProduct(w, position);
        viewMatrix[3][3] = 1.0;
    }

    public void setViewTarget(Double[] position, Double[] target, Double[] up) {
        setViewDirection(position, MatrixMath.subtract(target,position), up);
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
