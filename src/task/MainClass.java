package task;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Path path = Path.of(scanner.nextLine());
        try (FileReader reader = new FileReader(path.toString())) {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println(e);
        }
        String rightNumbers = "src\\task\\rightNumbers.txt";
        String wrongNumbers = "src\\task\\wrongNumbers.txt";
        try (FileWriter fileWriter1 = new FileWriter(wrongNumbers);
             FileWriter fileWriter2 = new FileWriter(rightNumbers)) {
            fileWriter1.write("");
            fileWriter2.write("");
        } catch (IOException e) {
            System.out.println(e);
        }
        for (String line : list) {
            if (line.length() != 15 || !(line.startsWith("docnum") || line.startsWith("contract")) || !line.matches("[a-zA-Z0-9]+")) {
                try (FileWriter fileWriter = new FileWriter(wrongNumbers, true)) {
                    fileWriter.write(line + "\n");
                    fileWriter.write(DocNumberException.controlDocNumber(line) + "\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else {
                try (FileWriter fileWriter = new FileWriter(rightNumbers, true)) {
                    fileWriter.write(line + "\n");
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
