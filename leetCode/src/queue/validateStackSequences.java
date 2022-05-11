package queue;

import java.util.Stack;

public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for(int num:pushed){
            s.push(num);
            while(!s.empty() && s.peek() == popped[i]){
                s.pop();
                i++;
            }
        }
        return s.isEmpty();
    }
}
