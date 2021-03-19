package SortAlgos;

public class InsertSort {
    private static Integer[] sort(Integer[] array) {
        for (int j = 0; j <= array.length - 1; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i -= 1;
            }
            System.out.println("i is: " + i);
            array[i+1] = key;
            for (Integer e:array) {
                System.out.print(e);
                System.out.print(' ');
            }
            System.out.println();
        }
        return array;
    }

    public static void main (String[] args) {
        /*
        Integer[] array = {5, 7, 1, 18, 25, 56, 17, 3};
        array = sort(array);
        for (Integer e:array) {
            System.out.print(e);
            System.out.print(' ');
        }
        */
        SortTest.test(InsertSort.class);

    }
}
