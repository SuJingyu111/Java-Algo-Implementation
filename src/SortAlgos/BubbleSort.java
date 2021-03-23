package SortAlgos;

import java.util.Arrays;

public class BubbleSort {
    public static Integer[] bubbleSort(Integer[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    private static void swap(Integer[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        BubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        SortTest.test(BubbleSort.class);
    }
}
