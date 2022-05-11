package pro08;

public class Code06_ConvertToLetterString {

	public static int number(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		return process(str.toCharArray(), 0);
	}
	//i之前的位置，如何转化已经做过决定了，不用在关心
	//str[i...]有多少种转化的结果
	public static int process(char[] chs, int i) {
		if (i == chs.length) {
			return 1;//当i来到终止为止，说明这是一种有效的转化结果
		}

		//没到终止位置，但该位置是0，两个决定都做不了
		if (chs[i] == '0') {
			return 0;
		}

		if (chs[i] == '1') {
			int res = process(chs, i + 1);
			if (i + 1 < chs.length) {
				//如果有i+1位置
				res += process(chs, i + 2);
			}
			return res;
		}
		if (chs[i] == '2') {
			int res = process(chs, i + 1);
			if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
				res += process(chs, i + 2);
			}
			return res;
		}
		return process(chs, i + 1);
	}

	public static void main(String[] args) {
		System.out.println(number("11111"));
	}

}
