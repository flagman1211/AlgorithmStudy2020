package backjoon;

import java.util.Scanner;

public class BalloonPop_2346 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] nums = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
				
		String msg = "";
		int cnt = 0;
		int idx = 1; 
		while (cnt < n - 1) {
			cnt++;
			msg += Integer.toString(idx) + " ";
			int num = nums[idx];
			nums[idx] = 0;
			if (num > 0) {
				while(num > 0) {
					idx++;
					if (idx > n)
						idx = 1;
					if (nums[idx] != 0)
						num--;
				}
			} else {
				while(num < 0) {
					idx--;
					if (idx < 1)
						idx = n;
					if (nums[idx] != 0)
						num++;
				}
			}
		}
		msg += Integer.toString(idx);
		System.out.println(msg);
	}

}
