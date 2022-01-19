package academy.learnprogramming.algorithms;

import academy.learnprogramming.utils.Utils;

public class Sorting {


    /**
     * Implementation of Bubble sort algorithm
     * Stable Sort
     *
     * @param array array to be sorted
     */
    public static void bubbleSort(int[] array) {
        for (int u = array.length - 1; u > 0; u--) {
            for (int i = 0; i < u; i++) {
                if (array[i] > array[i + 1]) {
                    Utils.swap(array, i, i + 1);
                }
            }
        }
    }

    /**
     * Implementation of Selection Sort Algorithm
     * Unstable Sort
     *
     * @param array array to be sorted
     */
    public static void selectionSort(int[] array) {
        for (int u = array.length - 1; u > 0; u--) {
            int largest = 0;
            for (int i = 0; i <= u; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }
            Utils.swap(array, u, largest);
        }
    }

}
