import java.util.*;

public class Q2 {
    
    static class LZWEncoding {

        public static Map<String, Integer> createDictionary(String input) {
            Map<String, Integer> dictionary = new HashMap<>();
            int index = 0;
            for (int i = 0; i < input.length(); i++) {
                String symbol = String.valueOf(input.charAt(i));
                if (!dictionary.containsKey(symbol)) {
                    dictionary.put(symbol, index++);
                }
            }
            return dictionary;
        }

        public static List<Integer> compress(String input, Map<String, Integer> dictionary) {
            List<Integer> compressedOutput = new ArrayList<>();
            StringBuilder currentSymbol = new StringBuilder();
            int index = 0;

            while (index < input.length()) {
                currentSymbol.append(input.charAt(index));
                if (!dictionary.containsKey(currentSymbol.toString())) {
                    // Add the index of the longest substring found in the dictionary
                    compressedOutput.add(dictionary.get(currentSymbol.substring(0, currentSymbol.length() - 1)));
                    // Add the new entry to the dictionary
                    dictionary.put(currentSymbol.toString(), dictionary.size());
                    // Reset the current symbol to the last character
                    currentSymbol = new StringBuilder(String.valueOf(input.charAt(index)));
                }
                index++;
            }
            // Add the index of the last substring found in the dictionary
            compressedOutput.add(dictionary.get(currentSymbol.toString()));

            return compressedOutput;
        }

        public static void main(String[] args) {
            // Task 1: Given a string to be encoded. Create the dictionary for LZW encoding algorithm.
            String inputString = "ABABABAABBABBAABCCCCEDD";
            Map<String, Integer> dictionary = createDictionary(inputString);
            System.out.println("Dictionary:");
            for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // Task 2: Given a string to be encoded. Create the array representing the compressed output of the string for LZW encoding algorithm.
            List<Integer> compressedOutput = compress(inputString, dictionary);
            System.out.println("\nCompressed Output:");
            for (int code : compressedOutput) {
                System.out.print(code + " ");
            }
        }
    }
}
