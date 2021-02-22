package backjoon;

import java.util.Scanner;

public class Sticker_9465 {
	public static int solution(int[][] arr, int n) {
		arr[1][0] += arr[0][1];
		arr[1][1] += arr[0][0];
		
		for (int i = 2; i < n; i++) {
			arr[i][0] += Math.max(arr[i - 1][1], arr[i - 2][1]);
			arr[i][1] += Math.max(arr[i - 1][0], arr[i - 2][0]);
		}
		
		return Math.max(arr[n - 1][0], arr[n - 1][1]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][2];
			
			for (int j = 0; j < n; j++)
				arr[j][0] = sc.nextInt();
			for (int j = 0; j < n; j++)
				arr[j][1] = sc.nextInt();
			
			sb.append(solution(arr, n));
			if (i < t - 1)
				sb.append("\n");
		}
		sc.close();
		System.out.println(sb);
	}
}
