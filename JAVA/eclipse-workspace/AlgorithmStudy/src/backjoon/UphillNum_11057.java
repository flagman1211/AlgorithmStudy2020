package backjoon;

import java.util.Scanner;

public class UphillNum_11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		long[] nums = new long[10];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			long[] nextNums = new long[10];
			for (int j = 0; j < nums.length; j++) {
				for (int j2 = j; j2 < nums.length; j2++) {
					nextNums[j2] = (nextNums[j2] + nums[j]) % 10007;
				}
			}
			
			for (int j = 0; j < nextNums.length; j++) {
				nums[j] = nextNums[j];
			}
		}
		
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		return sum % 10007;
	}

}
