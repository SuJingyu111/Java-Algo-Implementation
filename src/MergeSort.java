import java.util.*;
import java.io.*;

public class MergeSort {
    public static Integer[] mergeSort (Integer[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        else if (array.length == 2) {
            return array[0] <= array[1]? array : new Integer[]{array[1], array[0]};
        }
        else {
            int boundary = array.length / 2;
            return merge(mergeSort(Arrays.copyOfRange(array, 0, boundary)),
                    mergeSort(Arrays.copyOfRange(array, boundary, array.length)));
        }
    }

    private static Integer[] merge (Integer[] leftArray, Integer[] rightArray) {
        Integer[] mergedArray = new Integer[leftArray.length + rightArray.length];
        List<Integer> leftList = new ArrayList<Integer> (Arrays.asList(leftArray));
        List<Integer> rightList = new ArrayList<Integer> (Arrays.asList(rightArray));
        int pos = 0;
        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            mergedArray[pos++] = Math.min(leftList.get(0), rightList.get(0));
            if (leftList.get(0) <= rightList.get(0))
                leftList.remove(0);
            else
                rightList.remove(0);
        }
        if (!leftList.isEmpty()) {
            for (Integer i : leftList) {
                mergedArray[pos++] = i;
            }
        }
        else if (!rightList.isEmpty()) {
            for (Integer j : rightList) {
                mergedArray[pos++] = j;
            }
        }
        return mergedArray;
    }

    private static <T> void printArray (T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main (String[] args) {
        SortTest.test(MergeSort.class);
    }
}

