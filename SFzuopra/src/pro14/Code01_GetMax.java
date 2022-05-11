package pro14;

public class Code01_GetMax {
	//请保证参数N,不是1就是0的情况下  1->0  0->1
	public static int flip(int n) {
		return n ^ 1;
	}
	//n是非负数，返回1；n是负数，返回0
	public static int sign(int n) {
		return flip((n >> 31) & 1);
	}
	//采用加法两端互斥实现if ... else
	public static int getMax1(int a, int b) {
		//问题：a - b可能会溢出
		int c = a - b;
		int scA = sign(c);//a-b为非负数，sca为1；否则为0
		int scB = flip(scA);//sca为0，scb为1；否则相反
		return a * scA + b * scB;//sca为0，scb必为1；否则想反
	}

	public static int getMax2(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb;//a、b符号不一样，为1；否则为0
		int sameSab = flip(difSab);//a、b符号一样，为1；否则为1
		int returnA = difSab * sa + sameSab * sc;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

	public static void main(String[] args) {
		int a = -16;
		int b = 1;
		System.out.println(getMax1(a, b));
		System.out.println(getMax2(a, b));
		a = 2147483647;
		b = -2147480000;
		System.out.println(getMax1(a, b)); // wrong answer because of overflow
		System.out.println(getMax2(a, b));

	}

}
