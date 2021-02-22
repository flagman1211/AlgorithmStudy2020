package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Homwork_13904_1 {
	static class Homework implements Comparable<Homework> {
		int d;	// 남은 날짜
		int w;	// 과제의 점수
		
		public Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}
		
		@Override
		public int compareTo(Homework o) {
			// 점수의 내림차순 정렬
			return this.w < o.w ? 1 : -1;
		}
	}
	
	public static int solution(Homework[] arr, int n) {
		Arrays.sort(arr);
		
		// 날짜배열 생성
		int[] date = new int[1000];
		
		
		for (int i = 0; i < n; i++) {
			Homework hw = arr[i];
			for (int j = hw.d - 1; j >= 0; j--) {
				if (date[j] == 0) {
					date[j] = hw.w;
					break;
				}
			}
		}
		int r = 0;
		for (int i = 0; i < date.length; i++) {
			r += date[i];
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Homework[] arr = new Homework[n];
		for (int i = 0; i < n; i++) {
			int d = sc.nextInt();
			int w = sc.nextInt();
			arr[i] = new Homework(d, w);
		}
		sc.close();
		System.out.println(solution(arr, n));
	}
}
