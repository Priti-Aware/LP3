/*
LP-III DAA: Group A
3. Title: Write a program to solve a fractional Knapsack problem using a greedy method.

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/
import java.util.Scanner;

class Item {
    int weight;
    int profit;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }

    public double getRatio() {
        return (double) profit / weight;
    }
}

public class DAA_Assignment3 {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Bubble sort items by value-to-weight ratio in descending order without optimization
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length - 1; j++) {
                if (items[j].getRatio() < items[j + 1].getRatio()) {
                    // Swap items[j] and items[j + 1]
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                // Take the whole item
                totalValue += item.profit;
                capacity -= item.weight;
            } else {
                // Take a fraction of the item
                totalValue += item.getRatio() * capacity;
                capacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter the value and weight of each item:");
        for (int i = 0; i < n; i++) {
            int profit = scanner.nextInt();
            int weight = scanner.nextInt();
            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value: " + maxValue);

        scanner.close();
    }
}




/* OUTPUT
Enter the number of items: 3
Enter the value and weight of each item:
60 10
100 20
120 30
Enter the maximum capacity of the knapsack: 50
The maximum value in the knapsack is: 240.00
*/