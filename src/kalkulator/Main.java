package kalkulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Kuba
 */
public class Main {

    public static void main(String[] args) {
//        fromConsole();
        fromFile();
    }

    private static void fromConsole() {

        Scanner scanner = new Scanner(System.in);
        String text;
        Calculator calculator = new Calculator();
        while (true) {
            text = scanner.next();
            if (text.equals("koniec")) {
                break;
            }
            System.out.println(calculator.count(text));

        }
    }

    private static void fromFile() {
        String fileName = "temp.txt";

        Calculator calculator = new Calculator();
        String line = null;

        try {
            FileReader fileReader
                    = new FileReader(fileName);

            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.println(calculator.count(line));
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
        }
    }

}
