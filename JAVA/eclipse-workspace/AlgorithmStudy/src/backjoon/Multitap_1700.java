package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Multitap_1700 {
	
	
	public static int solution(int[] arr, int n, int k) {
		ArrayList<Integer> multi = new ArrayList<Integer>();
		int r = 0;
		for (int i=0; i<k; i++) {
			if (!multi.contains(arr[i])) {
				if (multi.size() == n) {
					int[] next = new int[n];
					for(int j=0; j<n; j++) {
						for (int l=i; l<k; l++) {
							if (arr[l] == multi.get(j)) {
								next[j] = l;
								break;
							}
						}
					}
					int idx = -1;
					int max = 0;
					for (int j=0; j<n; j++) {
						if(next[j] == 0) {
							idx = j;
							break;
						} else {
							if (max < next[j]) {
								idx = j;
								max = next[j];
							}
						}
					}
					if (idx >= 0) {
						r++;
						multi.remove(idx);
						multi.add(arr[i]);
					}
				} else {
					multi.add(arr[i]);
				}
			}	
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[k];
		
		for (int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println(solution(arr, n, k));
	}

}
