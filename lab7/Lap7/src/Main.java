

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        ChainingHashTable hashTable = new ChainingHashTable(26);

        // Inserting some students
        hashTable.insert("Alice", 20, 85.5);
        hashTable.insert("Bob", 22, 78.2);
        hashTable.insert("Charlie", 21, 91.7);
        hashTable.insert("David", 23, 89.3);
        hashTable.insert("Eva", 19, 95.0);
        hashTable.insert("Zed", 23, 95.0);
        hashTable.insert("Ali", 20, 85.5);
        // Displaying the hash table
        hashTable.display();
    }
    
    

}
