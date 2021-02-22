package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class TriangleStar_2448 {
	
	static int n;
	
	public static String makeSpace(int n) {
		String r = "";
		for (int i = 0; i < n; i++) {
			r += " ";
		}
		return r;
	}
	
	public static ArrayList<String> makeStar(int k) {
		if (k == 3) {
			ArrayList<String> r = new ArrayList<String>();
			r.add("  *  ");
			r.add(" * * ");
			r.add("*****");
			return r;
		} else {
			ArrayList<String> r = new ArrayList<String>();
			ArrayList<String> rSub = makeStar(k / 2);
			for (int i = 0; i < rSub.size(); i++) {
				r.add(makeSpace(k / 2) + rSub.get(i) + makeSpace(k / 2));
			}
			for (int i = 0; i < rSub.size(); i++) {
				r.add(rSub.get(i) + " " + rSub.get(i));
			}
			return r;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		ArrayList<String> r = makeStar(n); 
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r.size(); i++) {
			sb.append(r.get(i) + "\n");
		}
		System.out.println(sb.toString());
		// Stringbuilder 말고 String 으로 + 연산 해주면 통과 못한다...
	}

}
