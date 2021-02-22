/*
 * https://www.acmicpc.net/problem/2193
 * 
 * 
 * 이전께 0으로 끝나면 0, 1 모두 올 수 있음
 * 이전께 1로 끝나면 0만 와야함
 * ===>
 * 현재꺼의 총 가지 수: 이전꺼의 1로 끝나는 개수 + (이전꺼의 0으로 끝나는 개수 * 2) 개이고
 * 현개꺼의 0으로 끝나는 가지 수: 이전꺼의 1로 끝나는 개수 + 이전꺼의 0으로 끝내는 개수 => 이전꺼의 개수이다.
 * 이를 이용해 이전이 존재하는 2부터 n까지 재귀함수를 수행하며 구한다. 
 * 
 */

package backjoon;

import java.util.Scanner;

public class PinaryNumber_2193 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		if (n == 1)
			System.out.println(1);
		else
			System.out.println(solution(n, 2, 1, 0));
	}


	private static long solution(int n, int curr, long total, long endZero) {
		if (curr == n) {
			return total - endZero + (endZero * 2);
		}
		return solution(n, curr + 1, total - endZero + (endZero * 2), total);
	}

}