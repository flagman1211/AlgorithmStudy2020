package backjoon;

import java.util.Scanner;

public class KstNum_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		int l = 1;
		int r = k;	// n * n 으로 하면 왜 틀릴까 ?
		
		int result = r;
		while (l <= r) {
			int m = (r + l) >> 1;
			if (orLess(n, m) >= k) {
				result = m;	// result = Math.min(m, result);	// 이건 왜 틀릴까?
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		System.out.println(result);
	}
	
	public static int orLess(int n, int m) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += Math.min(m / i, n);	// 이 식이 어떻게 맞는걸까... 이런식은 어떻게 생각하는걸까...
		}
		return sum;
	}
}
