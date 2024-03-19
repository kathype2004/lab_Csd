
import java.util.ArrayList;



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
    private static Validation va = new Validation();
    
    public static void main(String[] args) {
        ArrayList<Employees> array = new ArrayList<>();
        
        Employees[] employee = new Employees[5];
        employee[0] = new Employees("A05","Tran Quang",7);
        employee[1] = new Employees("A03","Nguyen An",7);
        employee[2] = new Employees("A01","Truong Phung",5);
        employee[3] = new Employees("A04","Pham Thi Lam",2);
        employee[4] = new Employees("A02","Do Trung Ton",5);
        
        for(Employees i : employee) {
            array.add(i);
        }
        
        System.out.println("Before sort: ");
        for(Employees i : employee) {
            System.out.print(i);
        }
        System.out.println("");
    //------------------------------------------------------------------//        
        System.out.println("Ascending Order by insert:");
        va.insertionSortAsc(array);
        System.out.println("Descending Order by insert:");
        va.insertionSortDesc(array);
    //------------------------------------------------------------------//
        
        System.out.println("Ascending Order by select:");
        va.selectionSortAsc(array);
        System.out.println("Descending Order by select:");
        va.selectionSortDesc(array);
    //------------------------------------------------------------------//
        
        System.out.println("Ascending Order by bubble:");
        va.bubbleSortAsc(array);
        System.out.println("Descending Order by bubble:");
        va.bubbleSortDesc(array);
    //------------------------------------------------------------------//
        
        System.out.println("Ascending Order by heap:");
        va.heapSortAsc(array);
        System.out.println("Descending Order by heap:");
        va.heapSortDesc(array);
    //------------------------------------------------------------------//
        
        System.out.println("Ascending Order by quickSort:");
        va.quickSortAsc(array, 0, array.size() - 1);
        for (Employees e : array) {
            System.out.print(e);
        }
        System.out.println("");
        System.out.println("Descending Order by quickSort:");
        va.quickSortDesc(array, 0, array.size() - 1);
        for (Employees e : array) {
            System.out.print(e);
        }
        System.out.println("");
    //------------------------------------------------------------------//
        System.out.println("Ascending Order by mergeSort:");
        va.mergeSortAsc(array, 0, array.size() - 1);
        for (Employees e : array) {
            System.out.print(e);
        }
        System.out.println("");
        
        System.out.println("Descending Order by mergeSort:");
        va.mergeSortDesc(array, 0, array.size() - 1);
        for (Employees e : array) {
            System.out.print(e);
        }
        System.out.println("");
    }
}
