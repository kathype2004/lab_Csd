
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
public class Validation {
    //------------------------------------------------------------------//
    void insertionSortAsc(ArrayList<Employees> list) {
        for (int i = 1; i < list.size(); i++) {
            Employees key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getID().compareTo(key.getID()) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        for (Employees e : list) {
            System.out.print(e);
        }
        System.out.println("");
    }

    void insertionSortDesc(ArrayList<Employees> list) {
        for (int i = 1; i < list.size(); i++) {
            Employees key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getID().compareTo(key.getID()) < 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        for (Employees e : list) {
            System.out.print(e);
        }
        System.out.println("");
    }
    
    
    //selection sort
    //------------------------------------------------------------------//
    void selectionSortAsc(ArrayList<Employees> list) { 
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getID().compareTo(list.get(min).getID()) < 0) {
                    min = j;
                }
            }
            if(min != i) {
                Employees temp = list.get(min);
                list.set(min, list.get(i));
                list.set(i, temp);
            }

            
        }
        for(Employees i : list) {
                System.out.print(i);
            }
        System.out.println("");
    }
    
    void selectionSortDesc(ArrayList<Employees> list) {
        int n = list.size();
        for(int i = 0; i < n - 1;i++) {
            int max = i;
            for(int j = i + 1;j<n;j++) {
                if(list.get(j).getID().compareTo(list.get(max).getID()) < 0) {
                    max = j;
                }
            }
            
            if(max != i) {
                Employees emp = list.get(max);
                list.set(max, list.get(i));
                list.set(i, emp);
            }
        }
        for(Employees i : list) {
            System.out.print(i);
        }
        System.out.println("");
    }
    
    //bubble sort
    //------------------------------------------------------------------//
    void bubbleSortAsc(ArrayList<Employees> list)        
    {   
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getID().compareTo(list.get(j + 1).getID()) > 0) {
                    Employees temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    
        for (Employees e : list) {
            System.out.print(e);
        }
        System.out.println("");
    }
    
    void bubbleSortDesc(ArrayList<Employees> list) {
        int n = list.size();
        for(int i = 0; i < n-1;i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(list.get(j).getID().compareTo(list.get(j+1).getID()) < 0) {
                    Employees temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
            }
            }
        }
        for (Employees e : list) {
            System.out.print(e);
        }
        System.out.println("");
    }
    
    //heap sort
    //------------------------------------------------------------------//
    void heapify(ArrayList<Employees> arr, int n, int i, boolean asc) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (asc) {
            if (leftChild < n && arr.get(leftChild).compareTo(arr.get(largest)) > 0)
                largest = leftChild;

            if (rightChild < n && arr.get(rightChild).compareTo(arr.get(largest)) > 0)
                largest = rightChild;
        } else {
            if (leftChild < n && arr.get(leftChild).compareTo(arr.get(largest)) < 0)
                largest = leftChild;

            if (rightChild < n && arr.get(rightChild).compareTo(arr.get(largest)) < 0)
                largest = rightChild;
        }

        if (largest != i) {
            Employees temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            heapify(arr, n, largest, asc);
        }
    }

    void heapSort(ArrayList<Employees> arr, boolean asc) {
        int n = arr.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, asc);

        for (int i = n - 1; i > 0; i--) {
            Employees temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            heapify(arr, i, 0, asc);
        }

        for (Employees e : arr) {
            System.out.print(e);
        }
        System.out.println("");
    }

    void heapSortAsc(ArrayList<Employees> arr) {
        heapSort(arr, true);
    }

    void heapSortDesc(ArrayList<Employees> arr) {
        heapSort(arr, false);
    }
    
    //quick sort
    //------------------------------------------------------------------//
    int partition(ArrayList<Employees> arr, int low, int high, boolean asc) {
        Employees pivot = arr.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (asc) {
                if (arr.get(j).compareTo(pivot) <= 0) {
                    i++;
                    Employees temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            } else {
                if (arr.get(j).compareTo(pivot) >= 0) {
                    i++;
                    Employees temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        Employees temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1;
    }

    void quickSort(ArrayList<Employees> arr, int low, int high, boolean asc) {
        if (low < high) {
            int pi = partition(arr, low, high, asc);
            quickSort(arr, low, pi - 1, asc);
            quickSort(arr, pi + 1, high, asc);
        }
    }

    void quickSortAsc(ArrayList<Employees> arr, int low, int high) {
        quickSort(arr, low, high, true);
    }

    void quickSortDesc(ArrayList<Employees> arr, int low, int high) {
        quickSort(arr, low, high, false);
    }
    
    //merge sort
    //------------------------------------------------------------------//
    void merge(ArrayList<Employees> arr, int l, int m, int r, boolean asc) {
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Employees> L = new ArrayList<>();
        ArrayList<Employees> R = new ArrayList<>();

        for (int i = 0; i < n1; ++i)
            L.add(arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(arr.get(m + 1 + j));

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (asc) {
                if (L.get(i).compareTo(R.get(j)) <= 0) {
                    arr.set(k, L.get(i));
                    i++;
                } else {
                    arr.set(k, R.get(j));
                    j++;
                }
            } else {
                if (L.get(i).compareTo(R.get(j)) >= 0) {
                    arr.set(k, L.get(i));
                    i++;
                } else {
                    arr.set(k, R.get(j));
                    j++;
                }
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    void mergeSort(ArrayList<Employees> arr, int l, int r, boolean asc) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m, asc);
            mergeSort(arr, m + 1, r, asc);

            merge(arr, l, m, r, asc);
        }
    }

    void mergeSortAsc(ArrayList<Employees> arr, int l, int r) {
        mergeSort(arr, l, r, true);
    }

    void mergeSortDesc(ArrayList<Employees> arr, int l, int r) {
        mergeSort(arr, l, r, false);
    }
}
