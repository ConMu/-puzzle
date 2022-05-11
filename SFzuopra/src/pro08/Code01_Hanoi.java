package pro08;

public class Code01_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

//汉诺塔嵌套
//	public static void LeftToRight(int N){
	//base case
//		if (N == 1){
//			System.out.println("Move left to right.");
//		}else{
//			LeftToMid(N-1);
//			System.out.println("Move" + N + "from left to right.");
//			MidToRight(N-1);
//		}
//	}
//
//	public static void LeftToMid(int N){
//		if (N == 1){
//			System.out.println("Move left to Mid.");
//		}else{
//			LeftToRight(N-1);
//			System.out.println("Move" + N + "from left to Mid.");
//			RightToMid(N-1);
//		}
//	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
