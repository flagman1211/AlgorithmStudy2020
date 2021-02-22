package backjoon;

import java.util.Scanner;

public class MakeOne_1463 {
	
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		arr = new int[n + 1];
		arr[1] = 0;
		for (int i = 2; i < n + 1; i++) {
			int div3 = 1000000;
			if (i % 3 == 0)
				div3 = arr[i / 3];
			
			int div2 = 1000000;
			if (i % 2 == 0)
				div2 = arr[i / 2];
			
			int minu1 = arr[i - 1];
			
			arr[i] =  Math.min(div3, Math.min(div2, minu1)) + 1;
		}
		System.out.println(arr[n]);
	}

}
