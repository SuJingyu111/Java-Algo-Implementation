package SelectAlgos;

import SortAlgos.RandomizedQuickSort;
import SortAlgos.RandomizedQuickSort.*;

import java.util.Arrays;

public class RandomizedSelect {
    public static Integer select(Integer[] array, int i) {
        if (array.length == 0) {
            System.err.println("Empty array!");
            return null;
        }
        else if (array.length < i) {
            System.err.println("Invalid order!");
            return null;
        }
        //System.out.println(1);
        int q = RandomizedQuickSort.partition(array, 0, array.length - 1);
        int k = q + 1;
        if (k == i)
            return array[q];
        else if (k > i) {
            return recurseSelect(array, 0, q, i);
        }
        else
            return recurseSelect(array, q + 1, array.length - 1, i - k);
    }

    private static int recurseSelect(Integer[] array, int p, int r, int i) {
        if (p == r) {
            return array[p];
        }
        int q = RandomizedQuickSort.partition(array, p, r);
        int k = q - p + 1;
        if (k == i)
            return array[q];
        else if (k > i) {
            return recurseSelect(array, p, q, i);
        }
        else
            return recurseSelect(array, q + 1, r, i - k);
    }

    public static void main(String[] args) {
        Integer[] array = {5, 1, 345, 3, 76, 233, 6, 14, 79, 68, 9, 11, 23};
        System.out.println(RandomizedSelect.select(array, 5));
    }
}
