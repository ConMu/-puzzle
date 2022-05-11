package pro14;

public class Code03_AddMinusMultiDivideByBit {
	//如果a+b溢出，无关程序的错误
	public static int add(int a, int b) {
		int sum = a;
//		while (b != 0) {//当进位信息为0，停止
//			sum = a ^ b;
//			b = (a & b) << 1;
//			a = sum;
//		}
		while(b != 0) {
			sum = a ^ b;
			b = (a & b)<<1;
			a = sum;
		}
		return sum;
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}
	//减法为 a +(b的相反数)
	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int multi(int a, int b) {
		int res = 0;
//        //b右移没了
//		while (b != 0) {
//			if ((b & 1) != 0) {
//				res = add(res, a);
//			}
//			a <<= 1;
//			b >>>= 1;//无符号右移
//		}
//		return res;
        while (b !=0){
            if ((b & 1) != 0) {
                res = add(a,res) ;
            }
            a <<= 1;
            b >>>=1;

        }return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	public static int div(int a, int b) {
		int x = isNeg(a) ? negNum(a) : a;
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		for (int i = 31; i > -1; i = minus(i, 1)) {
		    //x右移i位后看是否大于y(为了数据安全，防止y右移溢出变成负数)，如果大于，则将y左移，并用x减掉
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("divisor is 0");
		}
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			int res = div(add(a, 1), b);
			return add(res, div(minus(a, multi(res, b)), b));
		} else {
			return div(a, b);
		}
	}

	public static void main(String[] args) {
		int a = (int) (Math.random() * 100000) - 50000;
		int b = (int) (Math.random() * 100000) - 50000;
		System.out.println("a = " + a + ", b = " + b);
		System.out.println(add(a, b));
		System.out.println(a + b);
		System.out.println("=========");
		System.out.println(minus(a, b));
		System.out.println(a - b);
		System.out.println("=========");
		System.out.println(multi(a, b));
		System.out.println(a * b);
		System.out.println("=========");
		System.out.println(divide(a, b));
		System.out.println(a / b);
		System.out.println("=========");

		a = Integer.MIN_VALUE;
		b = 32;
		System.out.println(divide(a, b));
		System.out.println(a / b);

	}

}
