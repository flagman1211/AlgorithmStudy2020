// https://www.acmicpc.net/problem/2164
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Card2_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = n; i > 0; i--) {
			list.add(i);
		}
		while (list.size() > 1) {
			list.removeLast();
			int tmp = list.removeLast();
			list.addFirst(tmp);
		}
		System.out.println(list.pop());
	}

}
