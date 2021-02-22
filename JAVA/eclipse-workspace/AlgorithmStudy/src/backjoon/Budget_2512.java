package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Budget_2512 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		long r = sc.nextLong();
		
		sc.close();
		
		
		Arrays.sort(arr);
		
		int result = 0;
		int l = 0;
		int h = arr[n - 1];
		
		while(l <= h) {
			int mid = (l + h) >> 1;
			long midBudget = calcBudget(arr, mid);
			
			if (Long.compare(midBudget, r) > 0) {
				h = mid - 1;
			} else {
				l = mid + 1;
				result = mid;
			}
			
		}
		System.out.println(result);
	}
	
	public static long calcBudget(int[] arr, int r) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Math.min(arr[i], r);
		}
		return sum;
	}

}
