package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Homwork_13904_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();	
		int[][] work = new int[N][2];
		for(int i=0; i<N; i++) {
			work[i][0] = scan.nextInt();	// 과제 마감기한
			work[i][1] = scan.nextInt();	// 과제 점수
		}
		
		// 과제 점수 높은순으로 정렬
		Arrays.sort(work, new Comparator<int[]>() {
			@Override	
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[1], o1[1]);
			}
		});
		
		int[] scores = new int[1001];	// 정수 N의 범위 - 1~1000
		for(int i=0; i<N; i++) {		// 과제 점수가 높은 순
			for(int j=work[i][0]; j>0; j--) {	// 과제의 마감일로부터 최대한 늦게 과제 하기
				if(scores[j] == 0) {
					scores[j] = work[i][1];
					break;
				}
			}
		}
		
        	/*
		for(int i=0; i<N; i++) {
			System.out.print(work[i][0] + " " + work[i][1]);
			System.out.println();
		} 
       		 */
		
		int maxScores = 0;	//과제 점수 최댓값
		for(int i=0; i<scores.length; i++) 
			maxScores += scores[i];
			

		System.out.println(maxScores);
		scan.close();
	}

}