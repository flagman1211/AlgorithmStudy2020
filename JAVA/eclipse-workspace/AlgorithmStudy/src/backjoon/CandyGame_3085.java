package backjoon;

import java.util.Scanner;

public class CandyGame_3085 {
	static char[][] candyBox;
	
	public static void swap(int x1, int y1, int x2, int y2) {
		char tmp = candyBox[x1][y1];
		candyBox[x1][y1] = candyBox[x2][y2];
		candyBox[x2][y2] = tmp;
	}
	
	public static int getMaxlen(int i, int j, boolean isVertical) {
		int max = 1;
		int r = 1;
		if (isVertical) {
			char curr = candyBox[0][j];
			for (int k = 1; k < candyBox.length; k++) {
				if (curr == candyBox[k][j])
					r++;
				else {
					if (r > max)
						max = r;
					if (max >= candyBox.length - k)
						break;
					r = 1;
					curr = candyBox[k][j];
				}
			}
			if (r > max)
				max = r;
		} else {
			char curr = candyBox[i][0];
			for (int k = 1; k < candyBox.length; k++) {
				if (curr == candyBox[i][k])
					r++;
				else {
					if (r > max)
						max = r;
					if (max >= candyBox.length - k)
						break;
					r = 1;
					curr = candyBox[i][k];
				}
			}
			if (r > max)
				max = r;
		}
		return max;
	}
	
	public static void solution(int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int c = getMaxlen(i, 0, false);
			if (c > max)
				max = c;
			if (max == n)
				break;
		}
		if (max != n) {
			for (int i = 0; i < n; i++) {
				int c = getMaxlen(0, i, true);
				if (c > max)
					max = c;
				if (max == n)
					break;
			}
			if (max != n) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - 1; j++) {
						if (candyBox[i][j] != candyBox[i][j + 1]) {
							 swap(i, j, i, j + 1);
							 int c = getMaxlen(i, j, true);
							 if (c > max)
								 max = c;
							 c = getMaxlen(i, j + 1, true);
							 if (c > max)
								 max = c;
							 c = getMaxlen(i, j, false);
							 if (c > max)
								 max = c;
							 swap(i, j, i, j + 1);
						}
						if ((i < n - 1) && (candyBox[i][j] != candyBox[i + 1][j])) {
							 swap(i, j, i + 1, j );
							 int c = getMaxlen(i, j, true);
							 if (c > max)
								 max = c;
							 c = getMaxlen(i, j, false);
							 if (c > max)
								 max = c;
							 c = getMaxlen(i + 1, j, false);
							 if (c > max)
								 max = c;
							 swap(i, j, i + 1, j );
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		candyBox = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			candyBox[i] = str.toCharArray();
		}
		sc.close();
		solution(n);
	}

}
