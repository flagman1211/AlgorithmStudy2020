package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheTree_2805 {
	
	static int[] trees;
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		trees = new int[n];
		m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			trees[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(trees);
		
		System.out.println(solution());
	}
	
	public static int solution() {
		int r = 0;
		int low = 0;
		int high = trees[n - 1];
		while (true) {
			int mid = (low + high) >> 1;
			if (mid == low) {
				if (getLength(high) >= m) {
					r = high;
				} else {
					r = low;
				}
				break;
			}
			long midLen = getLength(mid); 
			if (Long.compare(midLen, m) < 0) {	// 조건 불만족
				high = mid - 1;
			} else {			// 조건 만족 그러나 더 나은 답이 있는지 찾아봐야함
				low = mid;
			}
		}
		
		return r;
	}
	
	public static long getLength(int h) {
		long r = 0;
		for (int i = 0; i < n; i++) {
			if (trees[i] > h) {
				r += trees[i] - h;
			}
		}
		return r;
	}

}
