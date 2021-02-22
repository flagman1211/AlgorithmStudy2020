package backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class JosephusProblem_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		String msg = "<";
		while (list.size() > 1) {
			for (int i = 1; i < k; i++) {
				int temp = list.poll();
				list.add(temp);
			}
			msg += Integer.toString(list.poll()) + ", ";
		}
		msg += Integer.toString(list.poll()) + ">";
		System.out.println(msg);
	}

}
