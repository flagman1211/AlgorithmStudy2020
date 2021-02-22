package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class EngineerHangseung_1449 {
	
	public static int solution(int[] arr, int n, int l) {
		int r = 1;
		int idx = 1;
		int st = 0;
		while (idx < n) {
			if (arr[idx] - arr[st] + 1 > l) {
				r++;
				st = idx;
			}
			idx++;
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		System.out.println(solution(arr, n, l));
	}

}
