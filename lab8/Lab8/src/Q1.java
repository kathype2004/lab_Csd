import java.util.*;

public class Q1 {
    static class Node implements Comparable<Node> {
        char data;
        int frequency;
        Node left, right;

        public Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }

    static class HuffmanCoding {

        public static Node buildHuffmanTree(Map<Character, Integer> frequencies) {
            PriorityQueue<Node> pq = new PriorityQueue<>();

            // Create a priority queue of Nodes
            for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
                pq.offer(new Node(entry.getKey(), entry.getValue()));
            }

            // Build Huffman tree
            while (pq.size() > 1) {
                Node left = pq.poll();
                Node right = pq.poll();

                Node parent = new Node('$', left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;

                pq.offer(parent);
            }

            return pq.poll(); // Root of Huffman tree
        }

        public static Map<Character, Integer> calculateFrequencies(String text) {
            Map<Character, Integer> frequencies = new HashMap<>();
            for (char c : text.toCharArray()) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
            return frequencies;
        }

        public static void printHuffmanCodes(Node root, String code) {
            if (root == null)
                return;

            // If the node is a leaf node, print the character and its code
            if (root.left == null && root.right == null) {
                System.out.println(root.data + ": " + code);
                return;
            }

            // Recursively traverse the tree
            printHuffmanCodes(root.left, code + "0");
            printHuffmanCodes(root.right, code + "1");
        }

        public static void main(String[] args) {
            // Task 1: Given a set of characters with frequencies
            Map<Character, Integer> frequencies = new HashMap<>();
            frequencies.put('a', 5);
            frequencies.put('b', 9);
            frequencies.put('c', 12);
            frequencies.put('d', 13);
            frequencies.put('e', 16);
            frequencies.put('f', 45);

            Node root = buildHuffmanTree(frequencies);
            System.out.println("Huffman Codes:");
            printHuffmanCodes(root, "");

            // Task 2: Calculate frequencies from text file and build Huffman tree
            String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
            Map<Character, Integer> textFrequencies = calculateFrequencies(text);
            Node textRoot = buildHuffmanTree(textFrequencies);
            System.out.println("\nHuffman Codes from Text File:");
            printHuffmanCodes(textRoot, "");
        }
    }
}
