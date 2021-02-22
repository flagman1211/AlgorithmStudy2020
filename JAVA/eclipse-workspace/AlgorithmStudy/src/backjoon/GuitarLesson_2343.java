package backjoon;

import java.util.Scanner;

public class GuitarLesson_2343 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println(solution(arr, n, m));
	}
	
	public static long solution(int[] arr, int n, int m) {
		long l = 0;
		long r = 0;
		for (int i = 0; i < arr.length; i++) {
			l = Math.max(l, arr[i]);
			r += arr[i];
		} 
		long min = r;
		while (l <= r) {
			long v = (l + r) >> 1;
			
			if (getBlurayCnt(arr, v) <= m) {	// m보다 작으면 나뉘어져서 들어갈 수 있음
				min = Math.min(v, min);
				r = --v;
			} else {
				l = ++v;
			} 
		}
		
		return min;
	}
	
	// 주어진 크기(vol)로 나올 수 있는 블루레이의 개수를 리턴
	public static long getBlurayCnt(int[] arr, long vol) {
		long sum = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] > vol) {				
				sum = 0;
				cnt++;
			}
			sum += arr[i];
		}
		if (sum > 0) {
			cnt++;
		}
		
		return cnt;
	}

}
