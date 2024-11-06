/*
LP-III DAA: Group A
4. Title: Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and
bound strategy.

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/

import java.util.Scanner;

public class DAA_Assignment4 {

    // Method for solving the knapsack problem
    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Building the DP table
        for (int item = 1; item <= n; item++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[item - 1] <= weight) {
                    dp[item][weight] = Math.max(dp[item - 1][weight - weights[item - 1]] + values[item - 1], dp[item - 1][weight]);
                } else {
                    dp[item][weight] = dp[item - 1][weight];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press Ctrl+C to terminate...");
            System.out.print("Enter number of items: ");
            int n = scanner.nextInt();

            int[] values = new int[n];
            int[] weights = new int[n];

            System.out.print("Enter values of items: ");
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }

            System.out.print("Enter weights of items: ");
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }

            System.out.print("Enter maximum weight: ");
            int capacity = scanner.nextInt();

            int maximumValue = knapsack(values, weights, capacity);
            System.out.println("The maximum value of items that can be carried: " + maximumValue);
        }
    }
}


/* OUTPUT
Enter number of items: 3
Enter values of items: 60 100 200
Enter weights of items: 10 20 30
Enter maximum weight: 50
The maximum value of items that can be carried: 300
Press Ctrl+C to terminate...
*/