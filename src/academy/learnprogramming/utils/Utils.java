package academy.learnprogramming.utils;

public class Utils {
    /**
     * Method to swap elements on an array
     *
     * @param array array that contains elements to be swapped
     * @param i     index of first element to be swapped
     * @param j     index of the second element to be swapped
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return;
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }
}
