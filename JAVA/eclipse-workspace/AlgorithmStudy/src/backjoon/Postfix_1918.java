package backjoon;

import java.util.Scanner;
import java.util.Stack;

public class Postfix_1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String m = sc.nextLine();
		sc.close();
		
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m.length(); i++) {
			char curr = m.charAt(i);
			int currPrior = getOperPrior(m.charAt(i)); 
			if (currPrior < 0) {
				sb.append(curr);
			} else {
				switch (curr) {
					case '(': {
						stack.push(curr);
						break;
					}
					case ')': {
						while (stack.peek() != '(')
							sb.append(stack.pop());
						stack.pop();
						break;
					}
					case '+': case '-':
					case '*': case '/': {
						while (!stack.empty() && (getOperPrior(stack.peek()) >= currPrior))
							sb.append(stack.pop());
						stack.push(curr);
						break;
					}
				}				
			}
		}
		while (!stack.empty())
			sb.append(stack.pop());
		System.out.println(sb);
	}
	
	public static int getOperPrior(char op) {
		int r = -1;
		switch (op) {
			case '*':
			case '/': {
				r = 5;
				break;
			}
			case '+':
			case '-': {
				r = 3;
				break;
			}
			case '(':
			case ')': {
				r = 1;
				break;
			}
		}
		return r;
	}

}
