/*
LP-III DAA: Group A
6. Title: Write a program for analysis of quick sort by using deterministic and randomized variant.

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/

import java.util.Random;
import java.util.Scanner;

public class DAA_Assignment6 {
    private int[] array;

    public DAA_Assignment6(int[] array) {
        this.array = array;
    }

    // Deterministic method to find pivot
    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Randomized method to select a pivot
    private int partitionRandom(int low, int high) {
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        
        // Swap random pivot with the high element
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;

        return partition(low, high);
    }

    // Deterministic variant of QuickSort
    public void sortDeterministic(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            sortDeterministic(low, pivot - 1);
            sortDeterministic(pivot + 1, high);
        }
    }

    // Randomized variant of QuickSort
    public void sortRandomized(int low, int high) {
        if (low < high) {
            int pivot = partitionRandom(low, high);
            sortRandomized(low, pivot - 1);
            sortRandomized(pivot + 1, high);
        }
    }

    // Print array
    public void printArray() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press Ctrl+C to exit...");
            System.out.print("Enter array: ");
            String[] input = scanner.nextLine().split(" ");
            int[] array = new int[input.length];
            
            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
            }

            // Deterministic sort
            DAA_Assignment6 sort1 = new DAA_Assignment6(array.clone());
            System.out.println("Deterministic variant of sort:");
            sort1.sortDeterministic(0, array.length - 1);
            sort1.printArray();

            // Randomized sort
            DAA_Assignment6 sort2 = new DAA_Assignment6(array.clone());
            System.out.println("Randomized variant of sort:");
            sort2.sortRandomized(0, array.length - 1);
            sort2.printArray();
        }
    }
}


/* OUTPUT
Enter array: 8 7 5 3 1 9 6 2 4
Deterministic variant of sort:
1 2 3 4 5 6 7 8 9
Randomized variant of sort:
1 2 3 4 5 6 7 8 9
Press Ctrl+C to exit...
*/