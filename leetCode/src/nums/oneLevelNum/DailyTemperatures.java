package nums.oneLevelNum;

import java.util.Stack;

public class DailyTemperatures {
    static class TwoNum{
        int[] tuple2;
        TwoNum(int a, int b) {
            this.tuple2 = new int[]{a, b};
        }

        Integer get(int i) {
            return this.tuple2[i];
        }

    }


    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length < 1 ) {
            return null;
        }
        int len = temperatures.length;
        int[] res = new int[len];
        /*Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curNum = temperatures[i];
            while (!stack.isEmpty() && curNum > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }*/
        Stack<TwoNum> stack = new Stack<>();


        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek().get(1) < temperatures[i]) {
                TwoNum pop = stack.pop();
                res[pop.get(0)] = i - pop.get(0);
            }
            stack.push(new TwoNum(i, temperatures[i]));
        }
        return res;
    }

    public static void main(String[] args) {

        int[] test = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(test);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
