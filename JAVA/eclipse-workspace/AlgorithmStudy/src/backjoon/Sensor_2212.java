package backjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sensor_2212 {
	static class SensorInfo implements Comparable<SensorInfo>{
		int r;
		int l;
		int dis;
		
		public SensorInfo(int r, int l, int dis) {
			this.r = r;
			this.l = l;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(SensorInfo o) {
			return this.dis < o.dis ? 1 : -1;
		}
	}
	
	public static int solution(int[] arr, int n, int k) {
		Arrays.sort(arr);
		PriorityQueue<SensorInfo> infoPQueue = new PriorityQueue<SensorInfo>();
		for (int i = n - 1; i > 0; i--) {
			infoPQueue.offer(new SensorInfo(i, i - 1, arr[i] - arr[i - 1]));
		}
		for (int i = 0; i < k - 1; i++) {
			infoPQueue.poll();
		}
		int r = 0;
		while (!infoPQueue.isEmpty()) {
			r += infoPQueue.poll().dis;
		}
		
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(solution(arr, n, k));
	}

}
