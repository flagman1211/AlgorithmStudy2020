package backjoon;

import java.util.Scanner;

public class Histogram_1725 {
	static int[] arr;
	
	public static int solution(int st, int ed) {
		if (st == ed) {
			return arr[st];
		} else {
			int mid = (st + ed) >> 1;
			int result = Math.max(solution(st, mid), solution(mid + 1, ed));
			int l = mid;
			int r = mid;
			int minHeight = arr[mid];
			while (r - l <= ed - st) {
				int lHeight = (l > st) ? Math.min(arr[l - 1], minHeight) : 0;
				int rHeight = (r < ed) ? Math.min(arr[r + 1], minHeight) : 0;
				int width = r - l + 2;
				if (Integer.compare(lHeight * width, rHeight * width) > 0) {
					l--;
					minHeight = lHeight;
				} else {
					r++;
					minHeight = rHeight;
				}
				result = Math.max(minHeight * width, result);
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
		System.out.println(solution(0, n - 1));
	}

}
