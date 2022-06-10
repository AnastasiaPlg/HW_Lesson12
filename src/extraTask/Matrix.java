package extraTask;

public class Matrix {
    private int x;
    private int y;

    private int[][] matrix;


    public Matrix(int x, int y) {
        this.x = x;
        this.y = y;
        matrix = new int[x][y];
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sb.append(matrix[i][j]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void fillMatrixWithRandom() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = (int) (10 * Math.random());
            }
        }
    }

    public Matrix findMatricesSum(Matrix matrix) {
        Matrix sumMatrix = new Matrix(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sumMatrix.getMatrix()[i][j] = this.matrix[i][j] + matrix.getMatrix()[i][j];
            }
        }
        return sumMatrix;
    }

    public static String[][] toStringArray(Matrix matrix) {
        StringBuilder sb = new StringBuilder();
        String[][] stringMatrix = new String[matrix.getX()][1];
        for (int i = 0; i < matrix.getX(); i++) {
            for (int j = 0; j < matrix.getY() - 1; j++) {
                sb.append(matrix.getMatrix()[i][j] + "\t");
            }
            sb.append(matrix.getMatrix()[i][matrix.getY() - 1]);
            stringMatrix[i][0] = sb.toString();
            sb.delete(0, sb.length());
        }
        return stringMatrix;
    }
}
