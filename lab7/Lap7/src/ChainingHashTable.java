
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class ChainingHashTable{
    private LinkedList<Student>[] table;
    private int size;

    public ChainingHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to transform the first letter of the name to an index
    private static int hashFunct(char c) {
        if (Character.isUpperCase(c)) {
            return (int) (c - 'A');
        } else if (Character.isLowerCase(c)) {
            return (int) (c - 'a');
        } else {
            return -1; // Invalid character
        }
    }

    private int hash(String key) {
        char firstChar = key.charAt(0);
        return hashFunct(firstChar);
    }

    public void insert(String name, int age, double mark) {
        int index = hash(name);
        table[index].add(new Student(name, age, mark));
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Student student : table[i]) {
                System.out.print("(" + student.name + ", " + student.age + ", " + student.mark + ") -> ");
            }
            System.out.println("null");
        }
    }
}
