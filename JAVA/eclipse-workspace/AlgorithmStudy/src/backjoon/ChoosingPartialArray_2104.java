package backjoon;

import java.util.Scanner;

public class ChoosingPartialArray_2104 {
	static int[] arr;
	
	public static long partition(int st, int ed) {
		if (st == ed) {
			return (long) arr[st] * arr[st]; 
		} else {
			int mid = st + ed >> 1;
			long result = Math.max(partition(st, mid), partition(mid + 1, ed));
			
			int l = mid;
			int r = mid;
			long tmp = arr[mid];
			int min = arr[mid];
			while(r - l <= ed - st) {
				long lSum = (l <= st) ? 0 : arr[l - 1] + tmp;
				int lMin = (lSum == 0) ? 0 : Math.min(min, arr[l - 1]);
				
				long rSum = (r >= ed) ? 0 : arr[r + 1] + tmp;
				int rMin = (rSum == 0) ? 0 : Math.min(min, arr[r + 1]);
				
				if (Long.compare(lSum * lMin, rSum * rMin) > 0) {
					l--;
					tmp = lSum;
					min = lMin;
				} else {
					r++;
					tmp = rSum;
					min = rMin;
				}
				result = Math.max(result, tmp * min);
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(partition(0, n - 1));
	}
}
