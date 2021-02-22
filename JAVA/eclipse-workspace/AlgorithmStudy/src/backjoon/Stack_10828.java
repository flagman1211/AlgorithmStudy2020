package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder result = new StringBuilder();
		String[] data = new String[2];
		for (int i = 0; i < n; i++) {
			data = br.readLine().split(" ");
			switch (data[0]) {
				case "push": {
					stack.push(Integer.parseInt(data[1]));
					break;
				}
				case "pop": {
					if (!stack.empty())
						result.append(stack.pop() + "\n");
					else
						result.append("-1\n");					
					break;
				}
				case "size": {					
					result.append(stack.size() + "\n");
					break;
				}
				case "empty": {
					if (stack.empty())
						result.append("1\n");
					else
						result.append("0\n");
					break;
				}
				case "top": {
					if (!stack.empty())
						result.append(stack.peek() + "\n");
					else
						result.append("-1\n");					
				}
			}
		}
		System.out.println(result);
	}

}
