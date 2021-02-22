package backjoon;

import java.util.Scanner;

public class NumberBaseball_2503 {
	static char[][] nums;
	static int[] s;
	static int[] b;
	
	public static int solution(int n) {
		int r = 0;
		char[] num = new char[3];
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if ((i == j) || (i == k) || (j == k))
						continue;
					boolean chk = true;
					for (int l = 0; l < n; l++) {
						num[0] = (char) (i + 48);
						num[1] = (char) (j + 48);
						num[2] = (char) (k + 48);
						chk = ((numOfSame(num, nums[l]) == s[l] + b[l]) && 
								(numOfStrike(num, nums[l]) == s[l]));
						if (!chk)
							break;
					}
					if (chk)
						r++;
				}
			}
		}
		
		return r;
	}

	private static int numOfStrike(char[] num, char[] cs) {
		int r = 0;
		for (int i = 0; i < cs.length; i++) {
			if (num[i] == cs[i])
				r++;
		}
		return r;
	}

	private static int numOfSame(char[] num, char[] cs) {
		int r = 0;
		for (int i = 0; i < cs.length; i++) {
			for (int j = 0; j < cs.length; j++) {
				if (num[i] == cs[j]) {
					r++;
					break;
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new char[n][3];
		s = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.next().toCharArray();
			s[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(solution(n));
//		char[] c1 = new char[3];
//		c1[0] = '9';
//		c1[1] = '8';
//		c1[2] = '7';
//		char[] c2 = new char[3];
//		c2[0] = '1';
//		c2[1] = '2';
//		c2[2] = '3';
//		System.out.println(numOfSame(c1, c2));
//		System.out.println(numOfStrike(c1, c2));
	}

}
