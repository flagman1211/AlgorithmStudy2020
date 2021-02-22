package backjoon;

import java.util.Scanner;

public class QuadTree_1992 {

	static int[][] page;
	
	public static int isSame(int n, int x, int y) {
		int result = page[x][y];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (result != page[x + i][y + j]) {
					result = 9;
					return result;
				}
			}
		}
		return result;
	}
	
	public static String QuadTree(int n, int x, int y) {
		if (n == 1) {
			return page[x][y] + "";
		} else {
			int r = isSame(n, x, y);
			if ((r == 0) || (r == 1)) {
				return r + "";
			} else {
				String result = "(";
				result += QuadTree(n / 2, x, y);
				result += QuadTree(n / 2, x, y + n / 2);
				result += QuadTree(n / 2, x + n / 2, y);
				result += QuadTree(n / 2, x + n / 2, y + n / 2);
				return result + ")";
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		page = new int[n][n];
		sc.nextLine(); 
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < input.length(); j++) {
				page[i][j] = input.charAt(j) - '0';
			}
		}
		sc.close();
		String r = QuadTree(n, 0, 0);
		System.out.println(r);
	}

}
