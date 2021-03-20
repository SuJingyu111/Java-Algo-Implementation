package SortAlgos;

import java.util.Arrays;

public class HeapSort {
    protected MaxHeap buildMaxHeap(Integer[] array) {
        MaxHeap maxHeap =  new MaxHeap(array);
        System.out.println(Arrays.toString(maxHeap.getHeap()));
        return maxHeap;
    }

    public Integer[] heapSort(Integer[] array) {
        MaxHeap mHeap = buildMaxHeap(array);
        for (int i = array.length; i >= 2; i--) {
            mHeap.swap(1, i);
            mHeap.heapSize -= 1;
            mHeap.maxHeapify(1);
        }
        return Arrays.copyOfRange(mHeap.getHeap(), 1,
                mHeap.getHeap().length);
    }

    public static void main(String[] args) {
        Integer[] testArray = {15, 6, 7, 19, 23, 17, 36};
        HeapSort hs = new HeapSort();
        Integer[] resultArray = hs.heapSort(testArray);
        for (Integer i : resultArray) {
            System.out.print(i + " ");
        }
        SortTest.test(HeapSort.class);
    }
}

class MaxHeap{
    public int heapSize;
    private Integer[] heap;

    public MaxHeap(Integer[] array) {
        heapSize = array.length;
        heap = new Integer[array.length + 1];
        heap[0] = null;
        for (int i = 0; i < array.length; i++) {
            heap[i + 1] = array[i];
        }
        for (int i = heapSize/2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    protected void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= heapSize && heap[l] > heap[largest]) {
            largest = l;
        }
        if (r <= heapSize && heap[r] > heap[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public Integer[] getHeap(){
        return heap;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        return i / 2;
    }

    public void swap(int l, int r) {
        int temp = heap[l];
        heap[l] = heap[r];
        heap[r] = temp;
    }
}
