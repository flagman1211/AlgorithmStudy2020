/*
 * https://steady-coding.tistory.com/14
 * �̻�� Ǯ�� ����
 */

package backjoon;

import java.util.Scanner;

public class FillTheBox_1493 {
	
	static final int LEN = 0;
	static final int CNT = 1;
	
	public static long solution(int l, int w, int h, int n, long[][] cubes) {
		long before = 0;
		long r = 0;
		for (int i = n - 1; i >= 0; i--) {
			before <<= 3;
			long cnt = (long) (l >> cubes[i][LEN]) * (w >> cubes[i][LEN]) * (h >> cubes[i][LEN]) - before;
			long realCnt = Math.min(cnt, (long) cubes[i][CNT]);
			before += realCnt;
			r += realCnt;
		}
//		if (before == (long) l * w * h)				// �̰� �� - �̹� long���� ��ȯ�� int ���� �Ѿ ����
//		if (Long.compare(before, l * w * h) == 0)	// �̰͵� �ȉ� ����
		if (before == (long) (l * w * h))			// �̰� �ȵ� ���߻����� - ������, ��ü ���ϴٰ� int ���� ������ ������
			return r;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int n = sc.nextInt();
		
		long[][] cubes = new long[n][2];
		
		for (int i = 0; i < n; i++) {
			cubes[i][LEN] = sc.nextInt();
			cubes[i][CNT] = sc.nextInt();
		}
		sc.close();
		System.out.println(solution(l, w, h, n, cubes));
		
	}

}
