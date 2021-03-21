package DataStructures;

public class MaxHeap extends AbstractHeap {

    public MaxHeap(Integer[] array) {
        super(array);
    }

    protected void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= heapSize && this.heap.get(l) > heap.get(largest)) {
            largest = l;
        }
        if (r <= heapSize && heap.get(r) > heap.get(largest)) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }
}
