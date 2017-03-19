package kalkulator;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
    
}
