package DataStructures;

public class MinHeap extends AbstractHeap {

    public MinHeap(Integer[] array) {
        super(array);
    }

    protected void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l <= heapSize && this.heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }
        if (r <= heapSize && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

}
