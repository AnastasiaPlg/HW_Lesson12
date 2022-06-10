package extraTask;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(5, 5);
        matrix1.fillMatrixWithRandom();
        Matrix matrix2 = new Matrix(5, 5);
        matrix2.fillMatrixWithRandom();
        Matrix sumMatrix = null;
        try {
            if (matrix1.getX() != matrix2.getX() || matrix1.getY() != matrix2.getY()) {
                throw new SumMatricesException();
            } else {
                sumMatrix = matrix1.findMatricesSum(matrix2);
            }
        } catch (SumMatricesException e) {
            System.out.println(e);
        }
        try {
            Output.outputSumInFile(Output.createSum(matrix1, matrix2, sumMatrix), "src\\extraTask\\sumOfMatrices.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
