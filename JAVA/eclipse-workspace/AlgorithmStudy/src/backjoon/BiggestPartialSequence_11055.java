/*
 * 문제: https://www.acmicpc.net/problem/11055
 * 풀이 참조: https://m.blog.naver.com/occidere/220793914361
 */

package backjoon;

import java.util.Scanner;

public class BiggestPartialSequence_11055 {
		
	static int[][] arr = new int[1001][2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			arr[i][0] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			arr[i][1] = arr[i][0];
			
			for (int j = 1; j < i; j++) {
				if (arr[j][0] < arr[i][0]) {
					// 이전번째까지의 합 + 자신의 값과 자신번째의 합 중 큰 값을 넣어준다. ### 중요
					arr[i][1] = Math.max(arr[j][1] + arr[i][0], arr[i][1]);
				}
			}
			
			max = Math.max(arr[i][1], max);
		}
		
		return max;
	}

}
