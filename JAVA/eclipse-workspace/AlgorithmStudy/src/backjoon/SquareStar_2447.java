package backjoon;

import java.util.Scanner;

public class SquareStar_2447 {	
	public static void partition(char arr[][], int n, int x, int y) {
		if (n == 1) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 1 || j != 1)
						arr[x * 3 + i][y * 3 + j] = '*';
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != 1 || j != 1)
						partition(arr, n / 3, x * 3 + i, y * 3 + j);
				}
			}			
		}
	}
	
	public static void printStar(int n) {
		char arr[][] = new char[n][n];
		// 비교해서 ' '를 넣어주는 것보다 처음 ' '로 초기화 시키고 ' '를 넣을 때를 continue 내지 로직으로 제외 시키는 것이 더 빠르다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}
		partition(arr, n/3, 0, 0);

		StringBuffer sb = new StringBuffer(); 
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		printStar(n);
	}

}
