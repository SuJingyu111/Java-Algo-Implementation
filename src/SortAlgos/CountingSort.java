package SortAlgos;

import java.util.Arrays;

public class CountingSort {
    public static Integer[] countingSort(Integer[] array) {
        Integer[] resultArray = new Integer[array.length];
        Integer maxVal = array[0];
        for (Integer i : array) {
            maxVal = Math.max(maxVal, i);
        }
        Integer[] countingArray = new Integer[maxVal];
        Arrays.fill(countingArray, 0);
        for (Integer i : array) {
            countingArray[i] += 1;
        }
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i - 1];
        }
        for (Integer integer : array) {
            resultArray[countingArray[integer]] = integer;
            countingArray[integer] -= 1;
        }
        return resultArray;
    }
    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
        SortTest.test(QuickSort.class);
    }
}
