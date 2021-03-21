package DataStructures;

import java.util.*;

public abstract class AbstractHeap {
    public int heapSize;
    protected List<Integer> heap;

    public AbstractHeap(Integer[] array) {
        heapSize = array.length;
        heap = new ArrayList<Integer>();
        heap.add(null);
        heap.addAll(Arrays.asList(array));
        for (int i = heapSize/2; i >= 1; i--) {
            heapify(i);
        }
    }

    protected abstract void heapify(int i);

    public List<Integer> getHeap(){
            return heap;
        }

    protected int left(int i) {
            return 2 * i;
        }

    protected int right(int i) {
            return 2 * i + 1;
        }

    protected int parent(int i) {
            return i / 2;
        }

    public void swap(int l, int r) {
        int temp = heap.get(l);
        heap.set(l, heap.get(r));
        heap.set(r, temp);
    }

    public void insert(int val) {
        heap.add(val);
        heapSize += 1;
        int pos = heap.size() - 1;
        heapify(parent(pos));
    }

    public Integer get(int pos) {
        return heap.get(pos);
    }

    public void remove(int pos) {
        heap.set(1, heap.get(heapSize));
        heap.remove(heapSize);
        heapSize -= 1;
        heapify(1);
    }

    public void set(int pos, int val) {
        heap.set(pos, val);
        //heapify(pos);
    }
}
