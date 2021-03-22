package SortAlgos;

import java.util.Arrays;

public class QuickSort {
    public static Integer[] quickSort(Integer[] array) {
        int q = partition(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        quickSortRecurse(array, 0, q - 1);
        quickSortRecurse(array, q + 1, array.length - 1);
        return array;
    }

    protected static void quickSortRecurse(Integer[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSortRecurse(array, p, q - 1);
            quickSortRecurse(array, q + 1, r);
        }
    }

    private static int partition(Integer[] array, int left, int right) {
        System.out.println("--------------------");
        int q = array[right];
        System.out.println(q);
        int pos = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] < q) {
                pos += 1;
                swap(array, pos, j);
            }
        }
        swap(array, pos + 1, right);
        System.out.println("--------------------");
        return pos + 1;
    }

    private static void swap(Integer[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
        SortTest.test(QuickSort.class);
    }
}
