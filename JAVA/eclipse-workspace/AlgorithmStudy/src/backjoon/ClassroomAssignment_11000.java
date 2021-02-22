package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClassroomAssignment_11000 {

	static int[][] arr;
	
	public static int classroomAssignment() {
		PriorityQueue<Integer> entry = new PriorityQueue<Integer>();
		entry.offer(arr[0][1]);
		for (int i = 1; i < arr.length; i++) {
			if (entry.peek() <= arr[i][0])
				entry.poll();
			entry.offer(arr[i][1]);
		}
		return entry.size();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
		System.out.println(classroomAssignment());
	}

}
