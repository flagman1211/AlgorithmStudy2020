package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Homwork_13904 {
	static final int DATE = 0;
	static final int WORK = 1;
	
	public static int solution(int[][] arr, int n) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				return Integer.compare(o2[WORK], o1[WORK]);	// 이건 런타임 에러 안남
//				return o2[WORK] > o1[WORK] ? 1 : -1;		// 이건 런타임 에러 남 왜 ? 씨발놈들아? 0처리 때문에 ... 개새끼들
				return o2[WORK] > o1[WORK] ? 1 : (o2[WORK] == o1[WORK] ? 0 : -1);		// 이건 런타임 에러 안남
			}
		});
		
		// 날짜배열 생성
		int[] date = new int[1000];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = arr[i][DATE] - 1; j >= 0; j--) {
				if (date[j] == 0) {
					date[j] = arr[i][WORK];
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
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][DATE] = sc.nextInt();
			arr[i][WORK] = sc.nextInt();
		}
		sc.close();
		System.out.println(solution(arr, n));
	}
}
