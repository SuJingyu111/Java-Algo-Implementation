package DataStructures;

public class MinQueue extends PriorityQueue{

    public MinQueue(Integer[] array){ heap = new MinHeap(array); }

    @Override
    public void modifyKey(Integer pos, Integer val) {
        Integer original = heap.get(pos);
        heap.set(pos, val);
        if (val < original) {
            while (pos > 1 && heap.get(heap.parent(pos)) > heap.get(pos)) {
                heap.swap(pos, heap.parent(pos));
                pos = heap.parent(pos);
            }
        }
        else if (val > original && pos < heap.heapSize / 2) {
            while (pos < heap.heapSize / 2) {
                if (heap.get(heap.left(pos)) < heap.get(pos)) {
                    heap.swap(heap.left(pos), pos);
                    pos = heap.left(pos);
                }
                else if (heap.right(pos) < heap.heapSize && heap.get(heap.right(pos)) < heap.get(pos)) {
                    heap.swap(heap.right(pos), pos);
                    pos = heap.right(pos);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = {5, 234, 34, 67, 123, 76, 8, 38};
        MinQueue minQueue = new MinQueue(array);
        System.out.println(minQueue);
        System.out.println(minQueue.head());
        minQueue.insert(55);
        minQueue.modifyKey(2, 256);
        while (!minQueue.isEmpty()) {
            System.out.println(minQueue.extractHead());
        }
    }
}
