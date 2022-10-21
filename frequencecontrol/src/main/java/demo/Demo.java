package demo;

/**
 * @author mucongcong
 * @date 2022/08/31 09:51
 * @since
 **/
public class Demo {
    public static void main(String[] args) {
        String s = "12312 1\\ 2\\/ 3\b 4\f 5\n 6\r 7\t 8\"";
        System.out.println(s);

        String ss = JSONUtils.formatJsonValue(s);
        System.out.println(ss);
    }

}
