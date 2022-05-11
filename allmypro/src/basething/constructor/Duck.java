package basething.constructor;

public class Duck {
    private static int count;
//    int count;
    public Duck(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
