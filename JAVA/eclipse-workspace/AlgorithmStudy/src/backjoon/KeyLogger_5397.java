package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeyLogger_5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			char[] keylogger = br.readLine().toCharArray();
			for (int j = 0; j < keylogger.length; j++) {
				switch (keylogger[j]) {
					case '<': {
						if (!left.empty()) {
							right.push(left.pop());							
						}							
						break;
					}
					case '>': {
						if (!right.empty()) {
							left.push(right.pop());
						}
						break;
					}
					case '-': {
						if (!left.empty())
							left.pop();
						break;
					}					
					default: {
						left.push(keylogger[j]);
					}
					
				}
			}
			while (!left.empty())
				right.push(left.pop());
			while (!right.empty())
				sb.append(right.pop());
			if (i < n - 1)
				sb.append('\n');
		}
		System.out.println(sb);
	}

}
