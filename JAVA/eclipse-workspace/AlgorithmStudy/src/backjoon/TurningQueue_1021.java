package backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class TurningQueue_1021 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[m];
		for (int i = 0; i < m; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			int num = nums[i];
			int size = list.size();
			int numIdx = list.indexOf(num);
			cnt += Math.min(size - numIdx, numIdx);
			while (list.peek() != num) {
				int tmp = list.poll();
				list.add(tmp);
			}
			list.pop();
		}
		System.out.println(cnt);
	}

}
