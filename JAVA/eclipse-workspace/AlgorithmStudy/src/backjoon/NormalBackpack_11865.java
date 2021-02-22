/*
 * 문제: https://www.acmicpc.net/problem/12865
 * 
 * 풀이 참고: https://gumeum.tistory.com/25
 */

package backjoon;

import java.util.Scanner;

public class NormalBackpack_11865 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] backPack = new int[100001][101];
		int[][] item = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			item[i][0] = sc.nextInt();	// w
			item[i][1] = sc.nextInt();	// v
		}
		sc.close();
		
		System.out.println(solution(k, n, backPack, item));
	}
	
	public static int solution(int k, int n, int[][] backPack, int[][] item) {
		for (int i = 1; i <= n; i++) {
			int w = item[i][0];
			int v = item[i][1];
			for (int j = 1; j <= k; j++) {
				if (w > j) {
					backPack[j][i] = backPack[j][i - 1]; 
				} else {
					// 안넣을 경우 와 넣을 경우를 비교(backPack[j - w][i - 1] => 바로 위에서 물건의 무게 만큼 뺀 곳의 가치)
					backPack[j][i] = Math.max(backPack[j][i - 1], 
							                  backPack[j - w][i - 1] + v);
				}
			}
		}
		
		return backPack[k][n];
	}
	
}
