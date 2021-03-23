package SortAlgos;

import java.util.*;

public class RadixSort {
    public static Integer[] radixSort(Integer[] array) {
        Integer maxVal = array[0];
        for (Integer i : array){
            maxVal = Math.max(i, maxVal);
        }
        int digits = maxVal.toString().length();
        for (int d = 0; d < digits; d++) {
            stable(array, d);
        }
        return array;
    }

    private static void stable(Integer[] array, int d) {
        ArrayList< LinkedList<Integer> > digits = new ArrayList< LinkedList<Integer> >();
        for (int i = 0; i < 10; i++) {
            digits.add(new LinkedList<Integer>());
        }
        for (Integer i : array) {
            int pos = d > i.toString().length() - 1 ? 0 : (int) i.toString().charAt(i.toString().length() - 1 - d) - 48;
            digits.get(pos).add(i);
        }
        int arrayPos = 0;
        digits.removeIf(AbstractCollection::isEmpty);
        for (LinkedList<Integer> list : digits) {
            while (!list.isEmpty()) {
                array[arrayPos++] = list.remove(0);
            }
        }
    }
    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        RadixSort.radixSort(array);
        System.out.println(Arrays.toString(array));
        SortTest.test(RadixSort.class);
    }
}
