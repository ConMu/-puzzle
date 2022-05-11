package nums.oneLevelNum;
/*https://leetcode-cn.com/problems/random-pick-with-weight/*/
public class PickRandomSolution {
    public static int[] w;
    public static int sum;
    public static double[] rand;
    public PickRandomSolution(int[] w) {
        this.w = w;
        for(int i : w){
            this.sum += i;
        }
        this.rand = new double[w.length + 1];
        double initNum = 0;
        for(int i = 1; i < rand.length; ++i){
            initNum += (double)w[i-1] / (double)sum;
            rand[i] = initNum;
        }
    }

    public static int pickIndex() {
        double randNum = Math.random();
        int index = getIndex(randNum,rand);
        return index;
    }

    public static int getIndex(double randNum, double[] rand){
        int index = 0;
        while(index < rand.length && randNum > rand[index]){
            index++;
        }
        return index-1;
    }

    public static void main(String[] args) {
        int[] w = {1,3};
        PickRandomSolution pickRandomSolution = new PickRandomSolution(w);
        int count = 10;
        while(count > 0){
            System.out.println(pickRandomSolution.pickIndex());
            count--;
        }


    }
}
