package basething.comparething;

import java.util.Set;
import java.util.TreeSet;

public class CompareToC implements Comparable<CompareToC> {

    public int value;

    public CompareToC(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(CompareToC o) {
        if (this.value > o.value) {
            return 1;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        CompareToC a = new CompareToC(1);
        CompareToC b = new CompareToC(3);
        CompareToC c = new CompareToC(2);
        Set<CompareToC> com = new TreeSet<>();
        com.add(a);
        com.add(b);
        com.add(c);
        for (CompareToC compareToC : com) {
            System.out.println(compareToC.value);
        }
    }
}
