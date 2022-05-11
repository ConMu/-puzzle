package pro11;

public class Code01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = m.toCharArray();
		int i1 = 0; //str1中比对位置
		int i2 = 0;//str2中比对位置
		int[] next = getNextArray(str2);
		//O(N)
		while (i1 < str1.length && i2 < str2.length) {
			if (str1[i1] == str2[i2]) {
				i1++;
				i2++;
			} else if (next[i2] == -1) {//i2来到0位置，无法匹配
				i1++;//str1换个开头
			} else {
				i2 = next[i2];//str2还能往前跳
			}
		}
		//i1越界或者i2越界
		return i2 == str2.length ? i1 - i2 : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int cn = 0;//与i-1位置字符比的位置，也代表当前位置的信息（前缀长度）
		while (i < next.length) {
			if (ms[i - 1] == ms[cn]) {
				next[i++] = ++cn;
			} else if (cn > 0) {//当前跳到cn位置的字符，和i-1位置的字符配不上
				cn = next[cn];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
