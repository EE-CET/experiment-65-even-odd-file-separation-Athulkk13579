
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSeparator {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            PrintWriter evenWriter = new PrintWriter("even.txt");
            PrintWriter oddWriter = new PrintWriter("odd.txt");

            while (sc.hasNextInt()) {
                int number = sc.nextInt();

                if (number % 2 == 0) {
                    evenWriter.print(number + " ");
                } else {
                    oddWriter.print(number + " ");
                }
            }

            sc.close();
            evenWriter.close();
            oddWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error processing files.");
            return;
        }

        // Step 2: Read and display even.txt
        System.out.print("Even File: ");
        try {
            Scanner evenReader = new Scanner(new File("even.txt"));
            while (evenReader.hasNext()) {
                System.out.print(evenReader.next() + " ");
            }
            evenReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading even file.");
        }
        System.out.println();

        // Step 3: Read and display odd.txt
        System.out.print("Odd File: ");
        try {
            Scanner oddReader = new Scanner(new File("odd.txt"));
            while (oddReader.hasNext()) {
                System.out.print(oddReader.next() + " ");
            }
            oddReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading odd file.");
        }
        System.out.println();
    }
}
