/*
 * 문제: https://www.acmicpc.net/problem/16500
 * 풀이 참조: https://huiung.tistory.com/117
 */
package backjoon;

import java.util.Scanner;

public class StringDiscrimination_16500 {
	
	public static boolean[] wordBool;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		wordBool = new boolean[s.length() + 1];
		int n = sc.nextInt();
		sc.nextLine();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLine();
		}
		sc.close();
		
		solution(s, n, a, 0);
		
		if (wordBool[s.length()])
			System.out.println('1');
		else
			System.out.println('0');
	}

	private static void solution(String s, int n, String[] a, int startPos) {
		for (int i = 0; i < n; i++) {
			int nextPos = startPos + a[i].length();
			if ((wordBool.length <= nextPos) || wordBool[nextPos])	// nextPos에서 시작하는 차수가 이미 있다면 검사하지 않는다.
				continue;
			
			if (compare(s, a[i], startPos)) {
				wordBool[nextPos] = true;							// nextPos에서 시작하는 차수가 있음을 표시한다.
				
				if (nextPos == s.length()) {
					break;
				} else if (nextPos < s.length()) {
					solution(s, n, a, nextPos);
				}
			}
		}
	}
	
	private static boolean compare(String s, String word, int idx) {
		for (int i = 0; i < word.length(); i++) {
			if (i + idx >= s.length())
				return false;
			boolean r = word.charAt(i) == s.charAt(i + idx);
			if (!r)
				return r;
		}
		return true;
	}

}
