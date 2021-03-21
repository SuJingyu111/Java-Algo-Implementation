package DataStructures;

import SortAlgos.HeapSort.*;

public abstract class PriorityQueue {
    AbstractHeap heap;

    public void insert(Integer val) {
        heap.insert(val);
    };

    public Integer head() {
        return heap.get(1);
    };

    public Integer extractHead() {
        Integer head = heap.get(1);
        heap.remove(1);
        return head;
    };

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Content of this queue is: ");
        if (heap.getHeap().isEmpty()) {
            stringBuilder.append("empty");
            return stringBuilder.toString();
        }
        for (Integer i : heap.getHeap()){
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty() {
        return heap.getHeap().size() == 1 && heap.getHeap().get(0) == null;
    }

    public abstract void modifyKey(Integer pos, Integer val);
}

