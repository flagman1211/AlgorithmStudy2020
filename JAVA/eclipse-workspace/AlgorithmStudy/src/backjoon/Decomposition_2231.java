package backjoon;

import java.util.Scanner;

public class Decomposition_2231 {
	
	public static void solution(String n) {
		int x = n.length() - 1;
		x = x * 9 + (n.charAt(0) - '1');
		int nInt = Integer.parseInt(n);
		int min = nInt - x;
		while (min < nInt) {
			String minStr = Integer.toString(min);
			int sum = 0;
			for (int i = 0; i < minStr.length(); i++) {
				sum += (minStr.charAt(i) - '0');
			}
			if (min + sum == nInt)
				break;
			min++;
		}
		if (min < nInt)
			System.out.println(min);
		else
			System.out.println("0");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		sc.close();
		solution(n);
	}

}
