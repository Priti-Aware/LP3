/*
LP-III DAA: Group A
1. Title: Write a program non-recursive and recursive program to calculate Fibonacci numbers and
analyze their time and space complexity.

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/

import java.util.Scanner;

public class DAA_Assignment1 {

    // Iterative (Non-Recursive) Method to Print Fibonacci Series
    public static void printFibonacciIterative(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series (Iterative): ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }

    // Recursive Method to Print Fibonacci Series
    public static void printFibonacciRecursive(int n) {
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    // Helper Method for Recursive Fibonacci Calculation
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of terms for the Fibonacci series: ");
        int n = scanner.nextInt();

        // Print Fibonacci series using the iterative method
        printFibonacciIterative(n);

        // Print Fibonacci series using the recursive method
        printFibonacciRecursive(n);
    }
}


/*OUTPUT
Fibonacci Series (Iterative): 0 1 1 2 3 5 8 13 21 34 
Fibonacci Series (Recursive): 0 1 1 2 3 5 8 13 21 34 
*/


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DAA_Assignment1 {

    // Iterative (Non-Recursive) Method to Generate Fibonacci Series
    public static String getFibonacciIterative(int n) {
        int a = 0, b = 1;
        StringBuilder result = new StringBuilder("Fibonacci Series (Iterative): ");
        for (int i = 0; i < n; i++) {
            result.append(a).append(" ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        return result.toString();
    }

    // Recursive Method to Generate Fibonacci Series
    public static String getFibonacciRecursive(int n) {
        StringBuilder result = new StringBuilder("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            result.append(fibonacciRecursive(i)).append(" ");
        }
        return result.toString();
    }

    // Helper Method for Recursive Fibonacci Calculation
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        // Define file names
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            // Read number of terms from input file
            Scanner scanner = new Scanner(new File(inputFileName));
            int n = scanner.nextInt();
            scanner.close();

            // Generate Fibonacci series
            String iterativeResult = getFibonacciIterative(n);
            String recursiveResult = getFibonacciRecursive(n);

            // Write results to output file
            FileWriter writer = new FileWriter(outputFileName);
            writer.write(iterativeResult + "\n");
            writer.write(recursiveResult + "\n");
            writer.close();

            System.out.println("Fibonacci series have been written to " + outputFileName);

        } catch (IOException e) {
            System.out.println("An error occurred with file handling.");
            e.printStackTrace();
        }
    }
}
