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
        for (int i = a[0]; i > 0; i--) {
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
     * Implements insertion sort algorithm using loops
     * Stable sort
     *
     * @param a array to be sorted
     */

    public static void insertionSortLoop(int[] a) {
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

    public static void insertionSortRecursive(int[] a) {
        insertionSortRecursive(a, 1);
    }

    /**
     * Implements insertion sort algorithm recursion
     * Stable sort
     *
     * @param a array to be sorted
     */
    public static void insertionSortRecursive(int[] a, int i) {
        // Simplest case is not about length, but traversing the unsorted array
        if (i < a.length) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
            insertionSortRecursive(a, i + 1);
        }

    }

    /**
     * Sort using merge sort algorithm, it is used as access point to overloaded method
     * who takes different arguments
     *
     * @param a Array to be sorted
     */
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    /**
     * Sort using merge sort algorithm. It uses recursive calls to first,
     * divide the array and then merging results into a sorted array
     *
     * @param a Array to be sorded
     * @param s start index to be sorted
     * @param e end index to be sorted
     */
    public static void mergeSort(int[] a, int s, int e) {
        if (e - s < 2) return;

        int m = (s + e) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m, e);
        merge(a, s, m, e);
    }

    /**
     * @param a array to be sorted
     * @param s start left index
     * @param m start right index
     * @param e end index
     */
    public static void merge(int[] a, int s, int m, int e) {
        if (a[m - 1] >= a[m]) return;
        int i = s;
        int j = m;
        int x = 0;
        int[] b = new int[e - s];
        while (i < m && j < e) {
            b[x++] = a[i] >= a[j] ? a[i++] : a[j++];
        }
        System.arraycopy(a, i, a, s + x, m - i);
        System.arraycopy(b, 0, a, s, x);
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
////// CHALLENGE 3 Sort strings with radix sort


    public static void radixSort(String[] input, int radix, int width) {
        // Recorre cada elemento del array desde el valor mas a la derecha
        // en cada elemento se llama al proceso de ordenamiento de un solo digito
        for (int i = width; i > 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {

        // Creamos el array para contar los elementos con la longitud de la base (radix)
        int[] countArray = new int[radix];

        // Recuperamos la letra con charAt en la posicion mas a la derecha -1 (0 index based)
        // y le restamos el rango del codigo regresado (97 - 122) que corresponde a los numeros
        // de unicode para letras minusculas.
        // Contamos dentro countArray las coincidencias
        for (String value : input) {
            countArray[value.charAt(position - 1) - 97]++;
        }
        // Hace el ajuste del array para llevar el conteo de elementos anteriores
        // Esto nos ayudará para que al aplicar counting sort sea
        // estable
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }
        // Guardamos en una variable los elementos que vamos a ordenar
        // del array original
        int numItems = input.length;
        String[] temp = new String[numItems];

        // Recorremos tempIndex que tiene la misma longitud de nuestro array
        // original, para ir ordenando los elementos con el array de conteo
        // ajustado, empezando de derecha a izquierda
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[input[tempIndex].charAt(position - 1) - 97]] = input[tempIndex];
        }
        // Copiamos el nuevo orden del array temp dentro del array original para esta
        // iteración
        for (int i = 0; i < numItems; i++) {
            input[i] = temp[i];
        }


    }

}



