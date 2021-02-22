package backjoon;

import java.util.Scanner;

public class PowerSum_1699 {
	
	static int[] arr = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		for (int i = 1; i < 316; i++) {
			arr[(int) Math.pow(i, 2)] = 1;
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 1)
				continue;
			int min = 100001;
			if (i % 2 == 0) {
				for (int j = i - 1; j >= i / 2; j--) {
					if (min > arr[j] + arr[i - j]) {
						min = arr[j] + arr[i - j];
					}
				}
			} else {
				for (int j = i - 1; j >= i / 2 + 1; j--) {
					if (min > arr[j] + arr[i - j]) {
						min = arr[j] + arr[i - j];
					}
				}
			}
			arr[i] = min;			
		}
		return arr[n];
	}

}
