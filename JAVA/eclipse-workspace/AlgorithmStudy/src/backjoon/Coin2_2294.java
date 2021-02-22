/*
 * https://www.acmicpc.net/problem/2294
 * 
 * 그리드로 풀 수 없기 때문에 1부터 k까지 최소값을 구해나간다.
 * 1. 1 ~ k 의 배열을 만들고 들어갈 수 없는 최대값인 100001으로 초기화 한다.
 * 
 * 2. 동전의 가치가 입력된 인덱스에 1을 넣어준다.
 * 
 * 3. k까지의 최소 동전 개수는
 *  홀수의 경우 k - 1 ~ k / 2 + 1의 동전 개수와 k - (k - 1 ~ k / 2 + 1) 동전 개수의 합
 *  짝수의 경우 k - 1 ~ k / 2의 동전 개수와 k - (k - 1 ~ k / 2) 동전 개수의 합
 * 위 식을 k까지 반복하며 최소 개수를 인덱스에 넣는다.
 * k번째 값이 초기화 된 100001이면 -1을 리턴하고 아니면 그 값을 리턴한다.
 * 
 */
package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Coin2_2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(arr);
		System.out.println(solution(arr, n, k));
	}

	private static int solution(int[] arr, int n, int k) {
		int[] tmp = new int[k + 1];
		for (int i = 0; i < k + 1; i++) {
			tmp[i] = 100001;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] > k)		
				break;
			tmp[arr[i]] = 1;
		}
		for (int i = 2; i < k + 1; i++) {
			if (tmp[i] == 1)
				continue;
			int end;
			if (i % 2 == 0) {
				end = i / 2;
			} else {
				end = i / 2 + 1;
			}
			for (int l = i - 1; l >= end; l--) {
				int r = i - l;
				if ((tmp[l] > 0) && (tmp[r] > 0)) {
					tmp[i] = Math.min(tmp[l] + tmp[r], tmp[i]);
				}
			}
		}
		if (tmp[k] > 100000)
			return -1;
		else
			return tmp[k];
	}

}
