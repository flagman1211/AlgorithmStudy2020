/*
 * 문제: https://www.acmicpc.net/problem/2839
 * 설탕을 배달하는데 정확하게 Nkg을 배달해야 한다. 그리고 최대한 적은 봉지를 배달한다.
 * 5kg, 3kg 단위가 있고 (3 <= N <= 5000)
 * 
 * 
 * 
 * 
 * n = 5x + 3y
 * 0 = 5x + 3y - n
 * 처음엔 x를 증가시키다가 더 이상 증가시킬 수 없을때 y를 증가 y를 증가 시킬 수 없으면 x감소  
 * result = x + y
 */

package backjoon;

import java.util.Scanner;

public class SugarDelivery_2839 {
	
	public static int solution(int n) {
		int i, j = 0;	// 각각 5kg 봉지와 3kg 봉지의 개수
		i = n / 5;
		while (n != 5 * i + 3 * j) {
			j++;
			if (n < 5 * i + 3 * j) {
				i--;
				j = 0;
			}
			if (i < 0)
				break;
		}
						
		return i + j;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(solution(n));
	}

}
