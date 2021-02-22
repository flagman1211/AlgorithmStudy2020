package backjoon;

import java.util.Scanner;

public class HiddingAcorn_15732 {
	
	static final int START = 0;
	static final int END__ = 1;
	static final int STEP_ = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		long d = sc.nextLong();

		int[][] rules = new int[k + 1][3];
		
		int l = n;
		int r = n;
		for (int i = 1; i <= k; i++) {
			rules[i][START] = sc.nextInt();
			rules[i][END__] = sc.nextInt();
			rules[i][STEP_] = sc.nextInt();
			l = Math.min(rules[i][START] , l);
		}
		sc.close();
		
		
		int result = l;
		while (l <= r) {
			int mid = (l + r) >> 1;
			if (isThere(rules, d, mid)) {
				result = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(result);
	}
	
	// 판별식이 중요하다!!
	public static boolean isThere(int[][] rules, long d, int boxIdx) {
		long sum = 0;
		for (int i = 1; i < rules.length; i++) {
			if (boxIdx >= rules[i][END__]) {
				sum += (rules[i][END__] - rules[i][START]) / rules[i][STEP_] + 1; 
			} else if ((boxIdx < rules[i][END__]) && (boxIdx >= rules[i][START])) {
				sum += (boxIdx - rules[i][START]) / rules[i][STEP_] + 1;
			}
		}
		
		return sum >= d;
	}

}
