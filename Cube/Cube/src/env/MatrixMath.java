package env;

public class MatrixMath {

    public static Double magnitude(Double[] x) {
        double sum = 0;
        for (int i = 0; i <= x.length - 1; i++) {
            sum += Math.pow(x[i], 2);
        }
        return Math.sqrt(sum);
    }

    public static Double[] normailize(Double[] x) {
        Double[] re = new Double[x.length];
        double mag = magnitude(x);

        for (int i = 0; i < x.length; i++) {
            re[i] = x[i] / mag;
        }
        re[3] = 1.0;
        return re;
    }

    public static Double[] crossProduct3D(Double[] a, Double[] b) {
        Double[] re = new Double[a.length];
        re[3] = 1.0;
        re[0] = (a[1] * b[2] - a[2] * b[1]);
        re[1] = (a[2] * b[0] - a[0] * b[3]);
        re[2] = (a[0] * b[1] - a[1] * b[0]);
        return re;
    }

    /**
     * a and b are the same length
     * 
     * @param a
     * @param b
     * @return Sum
     */
    public static double dotProduct(Double[] a, Double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    public static Double[] subtract(Double[] a, Double[] b) {
        Double[] re = new Double[a.length];
        for (int i = 0; i < a.length - 1; i++) {
            re[i] = a[i] - b[i];
        }
        re[3] = 1.0;
        return re;
    }

    public static Double[][] matrixMultiply(Double[][] a, Double[][] b) {
        Double[][] n = new Double[4][4];

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                n[i][j] = 0.0;
                for (int k = 0; k <= 3; k++)
                    n[i][j] += a[i][k] * b[k][j];
            }
        }
        return n;
    }
}
