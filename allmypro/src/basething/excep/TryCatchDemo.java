package basething.excep;

public class TryCatchDemo {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("再执行");
    }
}
