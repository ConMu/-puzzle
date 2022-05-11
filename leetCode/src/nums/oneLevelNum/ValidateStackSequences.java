package nums.oneLevelNum;


import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> integers = new Stack<>();
        boolean res = isOK(pushed, popped, integers);
        return res;
    }

    private static boolean isOK(int[] pushed, int[] popped, Stack<Integer> integers) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }

        int count = 0;
        boolean res = false;
        for (int i = 0; i < pushed.length; i++) {
            integers.push(pushed[i]);
            while (!integers.isEmpty() &&integers.peek() == popped[count]) {
                integers.pop();
                count++;
            }
        }
        if (integers.isEmpty()) {
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{4,0,1,2,3};
        int[] poped = new int[]{4,2,3,0,1};
        System.out.println(validateStackSequences(pushed, poped));

    }
}
