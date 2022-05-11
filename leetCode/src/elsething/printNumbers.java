package elsething;

public class printNumbers {
    public int[] printNumbers(int n) {
        int count = n;
        int mostValue = 9;
        for(int i = 1;i < n ;i ++) {
            mostValue *= 10;
            mostValue += 9;
        }
        int[] num = new int[mostValue];
        for(int i = 0;i < mostValue ;i++) {
            num[i] = i + 1;
        }
        return num;

    }
}
