package backjoon;

import java.util.Scanner;

public class CountOfPaper_1780 {
	static int[][] paper = null;
	static int[] cnts = {0, 0, 0};	// -1, 0, 1 의  개수
	
	public static void addCnts(int k) {
		switch (k) {
		case -1 : cnts[0]++; break;
		case  0 : cnts[1]++; break;
		case  1 : cnts[2]++; break;
		}	
	}
	
	public static int isSame(int n, int x, int y) {
		int result = paper[x][y];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (result != paper[i + x][j + y]) {
					result = 9;
					return result;
				}
			}
		}
		return result;
	}
	
	public static void partition(int n, int x, int y) {
		if (n == 1) {
			addCnts(paper[x][y]);
		} else {
			int k = isSame(n, x, y);
			if (k == -1 || k == 0 || k == 1) {
				addCnts(k);
			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						partition(n / 3, i * (n / 3) + x, j * (n / 3) + y);	// 이거 설정하는데서 오래걸렸다...
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		sc.close();

		partition(n, 0, 0);
		
		for (int i = 0; i < cnts.length; i++) {
			System.out.println(cnts[i]);
		}
	}

}
