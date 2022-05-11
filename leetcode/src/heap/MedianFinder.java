package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    Queue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });//大根堆,存前一半数据
    Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });//小根堆，存后一半数据
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(num);
        } else if (queue2.isEmpty()) {
            Integer peek = queue1.peek();
            if (peek > num) {
                queue1.poll();
                queue2.add(peek);
                queue1.add(num);
            } else {
                queue2.add(num);
            }
        } else {
            if (!queue1.isEmpty() && num < queue1.peek()) {
                queue1.add(num);
            } else if (num > queue2.peek()) {
                queue2.add(num);
            } else {
                queue1.add(num);
            }
            resize(queue1, queue2);
        }
    }

    private void resize(Queue<Integer> queue1, Queue<Integer> queue2) {
        if (queue1.size() == queue2.size() || queue1.size() == queue2.size() + 1) {
            return;
        } else {
            Integer poll = queue1.poll();
            queue2.add(poll);
            if (queue1.size() > queue2.size()) {
                resize(queue1, queue2);
            } else {
                resize(queue2, queue1);
            }
        }
    }

    public double findMedian() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return 0;
        } else if (queue2.isEmpty()) {
            return queue1.peek();
        } else {
            if (queue1.size() == queue2.size()) {
                return ((double) queue1.peek() + (double) queue2.peek()) / 2;
            } else {
                return queue1.size() > queue2.size() ? queue1.peek() : queue2.peek();
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
