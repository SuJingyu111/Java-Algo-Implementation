package SortAlgos;

import SelectAlgos.RandomizedSelect;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {

    public static Integer[] randomizedQuickSort(Integer[] array) {
        int q = partition(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + " " + q);
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

    public static int partition(Integer[] array, int left, int right) {
        int rPos = new Random().nextInt(right - left + 1) + left;
        swap(array, rPos, right);
        int q = array[right];
        int pos = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] < q) {
                pos += 1;
                swap(array, pos, j);
            }
        }
        swap(array, pos + 1, right);
        return pos + 1;
    }

    private static void swap(Integer[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    public static void main(String[] args) {
        Integer[] array = {4, 49, 62, 70, 46, 75, 69, 93, 17, 45};
        RandomizedQuickSort.randomizedQuickSort(array);
        System.out.println(Arrays.toString(array));
        SortTest.test(RandomizedQuickSort.class);
    }
}
