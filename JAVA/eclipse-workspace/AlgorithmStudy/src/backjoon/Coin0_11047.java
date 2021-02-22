package backjoon;

import java.util.Scanner;

public class Coin0_11047 {
	static int[] coins;
	
	public static int getCoinCount(int k) {
		int r = 0;
		// 이분탐색 써서 시작점 잡아도 좋겠다.
		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] > k)
				continue;
			int c = k / coins[i];
			k -= coins[i] * c;
			r += c;
			if (k == 0)
				break;
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		coins = new int[n];
		int k = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(getCoinCount(k));
	}

}
