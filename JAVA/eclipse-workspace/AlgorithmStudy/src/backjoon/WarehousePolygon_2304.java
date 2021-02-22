package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WarehousePolygon_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr= new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);	// 위치 
			arr[i][1] = Integer.parseInt(tmp[1]);	// 높이
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		int lArea = 0;
		int h = arr[0][1];
		int lIdx = arr[0][0];
		for (int i = 1; i < n; i++) {
			if (arr[i][1] > h) {
				lArea += h * (arr[i][0] - lIdx);
				lIdx = arr[i][0];
				h = arr[i][1];
			}
		}
		int rArea = 0;
		h = arr[n - 1][1];
		int rIdx = arr[n - 1][0] + 1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i][1] > h) {
				rArea += h * (rIdx - (arr[i][0] + 1));
				rIdx = arr[i][0] + 1;
				h = arr[i][1];
			}
		}
		System.out.println(lArea + rArea + ((rIdx - lIdx) * h));
	}

}
