package extraTask;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Output {
    public static String createSum(Matrix matrix1, Matrix matrix2, Matrix sumMatrix) {
        StringBuilder sb = new StringBuilder();
        try {
            if (matrix1.getX() != matrix2.getX() || matrix1.getY() != matrix2.getY()
                    || matrix1.getX() != sumMatrix.getX() || matrix1.getY() != sumMatrix.getY()) {
                throw new ParametersException();
            }
            String[][] toStringMatrix1 = Matrix.toStringArray(matrix1);
            String[][] toStringMatrix2 = Matrix.toStringArray(matrix2);
            String[][] toStringSumMatrix = Matrix.toStringArray(sumMatrix);
            for (int i = 0; i < matrix1.getX(); i++) {
                if (i == matrix1.getX() / 2) {
                    sb.append(Arrays.toString(toStringMatrix1[i]) + "\t+\t" + Arrays.toString(toStringMatrix2[i]) + "\t=\t" + Arrays.toString(toStringSumMatrix[i]) + "\n");
                } else {
                    sb.append(Arrays.toString(toStringMatrix1[i]) + "\t \t" + Arrays.toString(toStringMatrix2[i]) + "\t \t" + Arrays.toString(toStringSumMatrix[i]) + "\n");
                }
            }

        } catch (ParametersException e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    public static void outputSumInFile(String sumToString, String filePath) throws IOException {
        Path pathOfFile = Path.of(filePath);
        if (!Files.exists(pathOfFile)) {
            Files.createFile(pathOfFile);
        }
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = sumToString.getBytes();
            outputStream.write(buffer, 0, sumToString.length());
        }
    }
}
