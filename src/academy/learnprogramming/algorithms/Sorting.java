package academy.learnprogramming.algorithms;

import static academy.learnprogramming.utils.Utils.swap;

public class Sorting {


    /**
     * Implementation of Bubble sort algorithm
     * Stable Sort
     *
     * @param array array to be sorted
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * Implementation of Selection Sort Algorithm
     * Unstable Sort
     *
     * @param a array to be sorted
     */
    public static void selectionSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int l = 0;
            for (int j = 0; j <= i; j++) {
                if (a[j] > a[l]) {
                    l = j;
                }
            }
            swap(a, i, l);
        }
    }

    /**
     * Implements insertion sort algorithm
     *
     * @param a array to be sorted
     */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }

    }
}
