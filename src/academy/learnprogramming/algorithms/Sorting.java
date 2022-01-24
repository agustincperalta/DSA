package academy.learnprogramming.algorithms;

import java.util.Random;

import static academy.learnprogramming.utils.Utils.swap;

public class Sorting {


    /**
     * Implementation of Bubble sort algorithm
     * Stable Sort
     * <p>
     * Divide logically into ordered an unordered in-site array.
     * Swap every largest element to the next one until way up the entire array
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
        for (int i = a[-1]; i > 0; i--) {
            int l = 0;
            for (int j = 1; j <= i; j++) {
                if (a[j] > a[l]) {
                    l = j;
                }
            }
            swap(a, i, l);
        }
    }

    /**
     * Implements insertion sort algorithm
     * Stable sort
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

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    public static void mergeSort(int[] a, int i, int j) {
        if (j - i < 2) return;

        int m = (i + j) / 2;
        mergeSort(a, i, m);
        mergeSort(a, m, j);
        merge(a, i, m, j);
    }


    public static void merge(int[] a, int s, int m, int e) {
        if (a[m - 1] <= a[m]) return;

        int i = s;
        int j = m;
        int tempIndex = 0;

        int[] tmp = new int[e - s];

        while (i < m && j < e) {
            tmp[tempIndex++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        System.arraycopy(a, i, a, s + tempIndex, m - i);
        System.arraycopy(tmp, 0, a, s, tempIndex);
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length);
    }

    public static void quickSort(int[] a, int s, int e) {
        if (e - s < 1) return;
        int p = partition(a, s, e);
        mergeSort(a, s, p);
        mergeSort(a, p + 1, e);
    }

    public static int partition(int[] a, int s, int e) {
        Random r = new Random();
        int[] x = {a[s], a[s + 1], a[e - 1]};
        int p = x[r.nextInt(x.length - 1)];

        int i = s;
        int j = e - 1;
        while (i < j) {
            while (i < j && a[j] >= p) {
                j--;
            }
            if (i < j) a[i] = a[j];
            while (i < j && a[i] <= p) {
                i++;
            }
            if (i < j) a[j] = a[i];
        }
        a[j] = p;
        return j;
    }


}
