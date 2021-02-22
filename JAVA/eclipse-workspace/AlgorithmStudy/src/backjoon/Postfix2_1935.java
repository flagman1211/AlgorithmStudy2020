package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Postfix2_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String exp = br.readLine();
		double[] nums = new double[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < exp.length(); i++) {
			char curr = exp.charAt(i);
			if ((curr >= 'A') && (curr <= 'Z')) {
				stack.push(nums[curr - 'A']);
			} else {
				double r = stack.pop();
				double l = stack.pop();
				switch (curr) {
					case '+': {
						stack.push(l + r);
						break;
					}
					case '-': {
						stack.push(l - r);
						break;
					}
					case '*': {
						stack.push(l * r);
						break;
					}
					case '/': {
						stack.push(l / r);
						break;
					}
				}
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
	}

}
