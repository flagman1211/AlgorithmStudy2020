package backjoon;

import java.util.Scanner;

public class Quadrant_1891 {
	static StringBuilder sb;
	
	// out: 앞자리 검사여부 true이면 앞자리 검사 해야함
	public static boolean xMove(int idx, boolean isInc) {
		if (sb.charAt(idx) == '1') {
			sb.setCharAt(idx, '2');
		} else if (sb.charAt(idx) == '2') {
			sb.setCharAt(idx, '1');
		} else if (sb.charAt(idx) == '3') {
			sb.setCharAt(idx, '4');
		} else if (sb.charAt(idx) == '4') {
			sb.setCharAt(idx, '3');
		}
		if (isInc) {
			return ((sb.charAt(idx) == '2') || (sb.charAt(idx) == '3'));
		} else {
			return ((sb.charAt(idx) == '1') || (sb.charAt(idx) == '4'));
		}
	}
	
	// out: 앞자리 검사여부 true이면 앞자리 검사 해야함
	public static boolean yMove(int idx, boolean isInc) {
		if (sb.charAt(idx) == '1') {
			sb.setCharAt(idx, '4');
		} else if (sb.charAt(idx) == '2') {
			sb.setCharAt(idx, '3');
		} else if (sb.charAt(idx) == '3') {
			sb.setCharAt(idx, '2');
		} else if (sb.charAt(idx) == '4') {
			sb.setCharAt(idx, '1');
		}
		if (isInc) {
			return ((sb.charAt(idx) == '3') || (sb.charAt(idx) == '4'));
		} else {
			return ((sb.charAt(idx) == '1') || (sb.charAt(idx) == '2'));
		}
	}
	
	public static void quadrantMove(long x, long y) {
		while (x != 0) {
			boolean r = false;
			for (int i = sb.length() - 1; i >= 0 ; i--) {
				r = xMove(i, x > 0);
				if (!r)
					break;
			}
			if (r) {
				sb.setLength(0);
				return;
			}
			if (x > 0)
				x--;
			else
				x++;
		}
		
		while (y != 0) {
			boolean r = false;
			for (int i = sb.length() - 1; i >= 0 ; i--) {
				r = yMove(i, y > 0);
				if (!r)
					break;
			}
			if (r) {
				sb.setLength(0);
				return;
			}
			if (y > 0)
				y--;
			else
				y++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		int d = sc.nextInt();
		sb = new StringBuilder(sc.next());
		long x = sc.nextLong();
		long y = sc.nextLong();
		sc.close();
		
		quadrantMove(x, y);
		
		if (sb.length() == 0)
			System.out.println("-1");
		else
			System.out.println(sb);
		
	}

}
