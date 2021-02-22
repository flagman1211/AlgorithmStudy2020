//	https://www.acmicpc.net/problem/2110
package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SettingRouter_2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr);
		
		int l = 1;
		int r = arr[n - 1] - arr[0];
		
		int result = -1;
		while (l <= r) {
			int m = (l + r) >> 1;
			
			int numOfRouter = GetNumOfRouter(arr, n, m);
			
			if (numOfRouter >= c) {
//			공유기의 개수가 c개 이상인 경우 c개까지 공유기를 없애도 와이파이를 쓰는것은 차이가 없기 때문에 c개 이상이면 상관없다.
				l = m + 1;
				if (m > result)
					result = m;
			} else
				r = m - 1;
		}
		
		System.out.println(result);
	}
	
	public static int GetNumOfRouter(int[] arr, int n, int m) {
//		최소 거리 m으로 최대한 많은 공유기를 설치한다.
//		최소 거리 m이상으로 공유기를 설치해도 됨!!! m = 2, {1, 4 ,5} 번 집이 있을 경우 1번과 4번 5번 집 모두 설치 할 수 있다. 최소만 맞춰주면 된다.
		int prev = arr[0];
		int numOfRouter = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] - prev >= m) {
				prev = arr[i];
				numOfRouter++;
			}
		}
		return numOfRouter;
	}

}
