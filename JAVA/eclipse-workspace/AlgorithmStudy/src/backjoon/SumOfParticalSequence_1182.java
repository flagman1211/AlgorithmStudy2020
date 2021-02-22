package backjoon;

import java.util.Scanner;

public class SumOfParticalSequence_1182 {
	static int s;
	
	/*
	 * 부분집합 구하는걸 몰라서 헤멨다...
	 * https://siyoon210.tistory.com/61 감사...
	 */
	public static int solution(int[] arr, boolean[] flag, int n, int idx) {
		if (idx == n) {
			int sum = 0;
			boolean isEmptySet = true;
			for (int i = 0; i < n; i++) {
				if (flag[i]) {
					sum += arr[i];
					isEmptySet = false;
				}
			}
			if (isEmptySet)
				return 0;
			if (sum == s) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int r = 0;
			flag[idx] = true;
			r += solution(arr, flag, n, idx + 1);
			flag[idx] = false;
			r += solution(arr, flag, n, idx + 1);
			return r;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		int[] arr = new int[n];
		boolean[] flag = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(solution(arr, flag, n, 0));
	}

}
