package academy.learnprogramming;

import java.util.Random;

import static academy.learnprogramming.algorithms.Sorting.selectionSort;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int[] intArray = random.ints(5, -50, 50).toArray();
        System.out.println("Unsorted array: ");
        printArray(intArray);
        System.out.println();

//        bubbleSort(intArray);
        selectionSort(intArray);
        System.out.println("Sorted array: ");
        printArray(intArray);
    }

    /**
     * This method print the current array
     *
     * @param intArray array to be printed
     */
    public static void printArray(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + " ");
        }
    }
}
