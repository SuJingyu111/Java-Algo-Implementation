package SortAlgos;

public class InsertSort {
    public static Integer[] sort(Integer[] array) {
        for (int j = 0; j <= array.length - 1; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i -= 1;
            }
            array[i+1] = key;
        }
        return array;
    }

    public static void main (String[] args) {
        SortTest.test(InsertSort.class);
    }
}
