package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Editor_1406 {

	public static void main(String[] args) throws IOException {
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// bufferedreader 사용하기
		
		char[] init = br.readLine().toCharArray();
		for (int i = 0; i < init.length; i++) {
			left.push(init[i]);
		}
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();	// 따로 String array 에 담지 말고 바로바로 꺼내 쓰기
			
			if ((input.charAt(0) == 'L') && (!left.isEmpty())) {
				right.push(left.pop());
			} else if ((input.charAt(0) == 'D') && (!right.isEmpty())) {
				left.push(right.pop());
			} else if ((input.charAt(0) == 'B') && (!left.isEmpty())) {
				left.pop();
			} else if (input.charAt(0) == 'P') {
				left.push(input.charAt(2));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (left.size() > 0) {
			right.push(left.peek());
			left.pop();
		}
		while (right.size() > 0) {
			sb.append(right.peek());
			right.pop();
		}
		System.out.println(sb);
	}
}
