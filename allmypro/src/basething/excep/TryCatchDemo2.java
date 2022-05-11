package basething.excep;

public class TryCatchDemo2 {

    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println("是否执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("再执行");
    }
}
