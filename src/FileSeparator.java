import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EvenOddFileSeparation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("numbers.txt"));
             FileWriter evenWriter = new FileWriter("even.txt");
             FileWriter oddWriter = new FileWriter("odd.txt")) {

            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num % 2 == 0) {
                    evenWriter.write(num + " ");
                } else {
                    oddWriter.write(num + " ");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Even File: ");
        printFileContent("even.txt");
        
        System.out.print("Odd File: ");
        printFileContent("odd.txt");
    }

    private static void printFileContent(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
