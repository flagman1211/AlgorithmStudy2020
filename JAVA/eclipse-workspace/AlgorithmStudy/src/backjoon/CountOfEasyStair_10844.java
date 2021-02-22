package backjoon;

import java.util.Scanner;

public class CountOfEasyStair_10844 {
	
	static final long MOD = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		long[] counts = new long[10];
		counts[0] = 0;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			long[] nextCounts = new long[10];
			nextCounts[1] = counts[0];
			nextCounts[8] = counts[9];
			for (int j = 1; j < counts.length - 1; j++) {
				nextCounts[j - 1] = (nextCounts[j - 1] + counts[j]) % MOD;
				nextCounts[j + 1] = (nextCounts[j + 1] + counts[j]) % MOD;
			}
			for (int j = 0; j < counts.length; j++) {
				counts[j] = nextCounts[j];
			}
		}
		
		long sum = 0;
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
		}
		System.out.println(sum % MOD);
	}

}
