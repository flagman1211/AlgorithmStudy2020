package backjoon;

import java.util.Scanner;

public class RepaintTheChessboard_1018 {
	public static char toggle(char before) {
		if (before == 'B')
			return 'W';
		else
			return 'B';
	}
	
	public static int numOfRepaint(char[][] chessboard, int n, int m) {
		int min = n * m;
		for (int r = 0; r <= n - 8; r++) {
			for (int c = 0; c <= m - 8; c++) {
				for (int toggle = 0; toggle < 2; toggle++) {	// lefttop이 B일때 W일때 둘 다 검사 해주자
					int curr = 0;
					for (int i = r; i < r + 8; i++) {
						char l;
						if (i == r)
							l = chessboard[r][c];
						else {
							if ((i - r) % 2 == 0) {
								l = chessboard[r][c];
							} else {
								l = toggle(chessboard[r][c]);
							}
						}
						if (toggle != 0)
							l = toggle(l);
						for (int j = c; j < c + 8; j++) {
							if (((j - c) % 2 == 0) && (chessboard[i][j] != l))
								curr++;
							else if (((j - c) % 2 != 0) && (chessboard[i][j] == l))
								curr++;
						}
					}
					if (curr < min)
						min = curr;
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// row
		int m = sc.nextInt();	// col
		char[][] chessboard = new char[n][m];
		
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			chessboard[i] = line.toCharArray();
		}
		sc.close();
		System.out.println(numOfRepaint(chessboard, n, m));
	}

}
