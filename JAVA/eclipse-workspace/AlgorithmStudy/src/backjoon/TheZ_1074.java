package backjoon;

import java.util.Scanner;

public class TheZ_1074 {
	static long r;
	static long c;
	public static int where(long k, long y, long x) {
		if ((k / 2 + y > r) && (k / 2 + x > c)) {
			return 0;
		} else if ((k / 2 + y > r) && (k / 2 + x <= c)) {
			return 1;
		} else if ((k / 2 + y <= r) && (k / 2 + x > c)) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public static long TheZ(long l, long y, long x) {
		if (l == 1) {
			return 0;
		} else {
			int quadrant = where(l, y, x);
			switch (quadrant) {
			case 0 : 
				return TheZ(l / 2, y, x);
			case 1 : 
				return Math.round(Math.pow(l / 2, 2)) + TheZ(l / 2, y, x + l / 2);
			case 2 : 
				return Math.round(Math.pow(l / 2, 2)) * 2 + TheZ(l / 2, y + l / 2, x);
			default: 
				return Math.round(Math.pow(l / 2, 2)) * 3 + TheZ(l / 2, y + l / 2, x + l / 2);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		sc.close();
		
		System.out.println(TheZ(Math.round(Math.pow(2, n)), 0, 0));
		
	}

}