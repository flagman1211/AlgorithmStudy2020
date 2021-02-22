package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class EurekaTheory_10448 {

	public static String solution(int k) {
		ArrayList<Integer> tri = new ArrayList<Integer>();
		int n = 1;
		while (n * (n + 1) / 2 <= k) {
			tri.add(n * (n + 1) / 2);
			n++;
		}
		for (int i = 0; i < tri.size(); i++) {
			for (int j = 0; j < tri.size(); j++) {
				for (int l = 0; l < tri.size(); l++) {
					if (k == tri.get(i) + tri.get(j) + tri.get(l)) {
						return "1";
					}
				}
			}
		}
		return "0";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String msg = "";
		for (int i = 0; i < n; i++) {
			msg += solution(sc.nextInt()) + "\n";
		}
		sc.close();
		System.out.println(msg);
	}

}
