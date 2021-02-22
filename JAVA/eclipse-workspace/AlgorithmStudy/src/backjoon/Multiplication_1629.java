package backjoon;

import java.util.Scanner;

public class Multiplication_1629 {
	
	public static long solution(long a, long b, long c) {
		if (b == 1)
			return a;
		long tmp = solution(a, b / 2, c);
		if (b % 2 == 0)
			return tmp * tmp % c;
		else
			return (tmp * tmp % c * a) % c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		sc.close();
		
		System.out.println(solution(a, b, c));
		
	}

}
