package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> A ;//用于维护的队列
    Deque<Integer> B ;//用于查看最大值的队列
    public MaxQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public int max_value() {
        if(B.isEmpty())return -1;
        return B.peekFirst();

    }

    public void push_back(int value) {
        while(!B.isEmpty() && B.peekLast() < value){
            B.pollLast();
        }
        B.offerLast(value);
        A.offer(value);
    }

    public int pop_front() {
        if(A.isEmpty())return -1;

        // if(B.peekFirst() == A.peek()) {
        //     B.pollFirst();
        // }
        // return A.poll();
        int res = A.poll();
        if(res == B.peekFirst()){
            B.pollFirst();
        }
        return res;
    }
}
