package elsething;

public class sumNums {
    public int sumNums(int n) {
        boolean flag = n>0 && (n +=sumNums(n-1))>0;
        return n;
    }
}
