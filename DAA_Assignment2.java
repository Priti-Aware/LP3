/*
LP-III DAA: Group A
2. Title: Write a program to implement Huffman Encoding using a greedy strategy.

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/

import java.util.Scanner;

// A Huffman Tree Node
class Node {
    int freq; // frequency of symbol
    String symbol; // symbol name (character)
    Node left; // left child
    Node right; // right child
    String huff; // tree direction (0/1)

    public Node(int freq, String symbol) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = null;
        this.right = null;
        this.huff = "";
    }
}

public class DAA_Assignment2 {

    // Utility function to print Huffman codes for all symbols in the newly created Huffman tree
    public static void printNodes(Node node, String val) {
        // Huffman code for current node
        String newVal = val + node.huff;

        // If node is not an edge node then traverse inside it
        if (node.left != null) {
            printNodes(node.left, newVal);
        }
        if (node.right != null) {
            printNodes(node.right, newVal);
        }

        // If node is an edge node then display its Huffman code
        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + ": " + newVal);
        }
    }

    public static void main(String[] args) {
        // Characters for Huffman tree
        String[] chars = { "a", "b", "c", "d", "e", "f" };

        // Frequency of characters
        int[] freq = { 5, 9, 12, 13, 16, 45 };

        // Number of characters
        int n = chars.length;

        // Array to hold nodes
        Node[] nodes = new Node[n];

        // Converting characters and frequencies into Huffman tree nodes
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(freq[i], chars[i]);
        }

        while (n > 1) {
            // Find the two nodes with the smallest frequency
            int min1Index = -1;
            int min2Index = -1;

            for (int i = 0; i < n; i++) {
                if (min1Index == -1 || nodes[i].freq < nodes[min1Index].freq) {
                    min2Index = min1Index;
                    min1Index = i;
                } else if (min2Index == -1 || nodes[i].freq < nodes[min2Index].freq) {
                    min2Index = i;
                }
            }

            // Assign directional value to these nodes
            nodes[min1Index].huff = "0";
            nodes[min2Index].huff = "1";

            // Combine the two smallest nodes to create a new node as their parent
            Node newNode = new Node(nodes[min1Index].freq + nodes[min2Index].freq,
                                    nodes[min1Index].symbol + nodes[min2Index].symbol);
            newNode.left = nodes[min1Index];
            newNode.right = nodes[min2Index];

            // Remove the two smallest nodes and add their parent as a new node
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (i != min1Index && i != min2Index) {
                    nodes[j++] = nodes[i];
                }
            }
            nodes[j] = newNode; // Add the new node at the end
            n--; // Reduce the count of active nodes
        }

        // Huffman Tree is ready!
        printNodes(nodes[0], "");
    }
}

/* OUTPUT
f: 0
c: 100
d: 101
a: 1100
b: 1101
e: 111
*/


// Time Complexity	
// Summary
// The time complexity of 
// 𝑂
// (
// 𝑛
// 2
// )
// O(n 
// 2
//  ) is mainly due to the repeated linear searches for the smallest nodes.
// The space complexity is 
// 𝑂
// (
// 𝑛
// )
// O(n) because we store the characters and their frequencies as nodes in an array.