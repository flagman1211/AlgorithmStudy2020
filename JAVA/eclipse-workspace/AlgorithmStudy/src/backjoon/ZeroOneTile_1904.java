package backjoon;

import java.util.Scanner;

public class ZeroOneTile_1904 {
	
	
	public static int solution(int n) {
		if (n <= 2) {
			return n % 15746;
		}
		int a = 1;
		int b = 2;
		int c = 0;
		for (int i = 3; i <= n; i++) {
			c = (a + b) % 15746;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		sc.close();
						
		System.out.println(solution(n));
	}

}
