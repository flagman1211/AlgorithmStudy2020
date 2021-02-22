/*
 * https://www.acmicpc.net/problem/1931
 */
package backjoon;

import java.util.Scanner;

public class MeetingRoomAssignment_1931 {
	public static int compare(int[][] arr, int i, int j) {
		if (arr[i][1] < arr[j][1]) {
			return -1;
		} else if (arr[i][1] > arr[j][1]) {
			return 1;
		} else {
			if (arr[i][0] < arr[j][0]) {
				return -1;
			} else if (arr[i][0] > arr[j][0]) {
				return 1;
			}
			return 0;
		}
	}
	
	public static void quickSort(int[][] arr, int l, int r) {
		int i, j, p = 0;
		do {
			i = l;
			j = r;
			p = (l + r)  >> 1;
			do {
				while (compare(arr, i, p) < 0)
					i++;
				while (compare(arr, j, p) > 0)
					j--;
				if (i <= j) {
					int[] tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					if (p == i)
						p = j;
					else if (p == j)
						p = i;
					i++;
					j--;
				}
			} while (i <= j);
			if (l < j)
				quickSort(arr, l, j);
			l = i;
		} while (i < r);
	}
	
	public static int solution(int n, int[][] schedules) {
		quickSort(schedules, 0, n - 1);
		int result = 1;
		int confirmedEd = schedules[0][1];
		for (int i = 1; i < n; i++) {
			if (schedules[i][0] >= confirmedEd) {
				confirmedEd = schedules[i][1];
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		sc.close();
		System.out.println(solution(n, arr));		
	}

}
