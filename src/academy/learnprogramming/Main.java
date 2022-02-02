package academy.learnprogramming;

import static academy.learnprogramming.algorithms.Sorting.radixSort;

public class Main {

    public static void main(String[] args) {
//        Random random = new Random();
//      int[] intArray = random.ints(5, -50, 50).toArray();
        String[] radixArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        System.out.println("Unsorted array: ");
        printArray(radixArray);
        System.out.println();
        // Se llama el metodo con el array a ordenar
        // la longitud de posibles valores (base o radix)
        // y la longitud de cada valor
        radixSort(radixArray, 25, 5);
//        Sorting.mergeSort(intArray);
        //  Sorting.insertionSortRecursive(stringsArray);

        System.out.println("Sorted array: ");
        printArray(radixArray);


    }

    /**
     * This method print the current array
     *
     * @param intArray array to be printed
     */
    public static void printArray(String[] intArray) {
        for (String i : intArray) {
            System.out.print(i + " ");
        }
    }
}
