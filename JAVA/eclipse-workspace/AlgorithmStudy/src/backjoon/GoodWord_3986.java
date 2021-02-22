// https://www.acmicpc.net/problem/3986
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord_3986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<Character>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			stack.clear();
			for (int j = 0; j < data.length(); j++) {
				char curr = data.charAt(j);
				if (stack.empty() || (stack.peek() != curr)) {
					stack.push(curr);
				} else {
					stack.pop();
				}
			}
			if (stack.size() <= 0) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
