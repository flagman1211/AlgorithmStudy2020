package backjoon;

import java.util.Scanner;

public class BinomialCoefficient_11051 {
	
	static long[][] arr = new long[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		long r = solution(n, k);
		System.out.println(r);
	}

	private static long solution(int n, int k) {
		if (arr[n][k] > 0)
			return arr[n][k];
		
		long r = 0;
		if (k == 1) {
			r = n;
		} else if ((n == k) || (k < 1)) {
			r = 1;
		} else {
			r = (solution(n - 1, k) + solution(n - 1, k - 1)) % 10007;
			arr[n][k] = r;
		}
		return r;
	}

}
