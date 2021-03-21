package DataStructures;

public class MaxQueue extends PriorityQueue{

    public MaxQueue(Integer[] array){ heap = new MaxHeap(array); }

    @Override
    public void modifyKey(Integer pos, Integer val) {
        Integer original = heap.get(pos);
        heap.set(pos, val);
        if (val > original) {
            while (pos > 1 && heap.get(heap.parent(pos)) < heap.get(pos)) {
                heap.swap(pos, heap.parent(pos));
                pos = heap.parent(pos);
            }
        }
        else if (val < original && pos < heap.heapSize / 2) {
            while (pos < heap.heapSize / 2) {
                if (heap.get(heap.left(pos)) > heap.get(pos)) {
                    heap.swap(heap.left(pos), pos);
                    pos = heap.left(pos);
                }
                else if (heap.right(pos) < heap.heapSize && heap.get(heap.right(pos)) > heap.get(pos)) {
                    heap.swap(heap.right(pos), pos);
                    pos = heap.right(pos);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        MaxQueue maxQueue = new MaxQueue(array);
        System.out.println(maxQueue);
        System.out.println(maxQueue.head());
        maxQueue.insert(55);
        maxQueue.modifyKey(2, 256);
        while (!maxQueue.isEmpty()) {
            System.out.println(maxQueue.extractHead());
        }
    }
}
