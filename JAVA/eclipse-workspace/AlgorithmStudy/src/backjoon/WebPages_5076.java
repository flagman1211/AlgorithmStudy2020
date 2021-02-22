// https://www.acmicpc.net/problem/5076
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WebPages_5076 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data;
		
		StringBuffer sb = new StringBuffer();
		while (true) {
			data = br.readLine();
			if (data.equals("#"))
				break;
			if (isValid(data)) {
				sb.append("legal\n");
			} else {
				sb.append("illegal\n");
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static boolean isValid(String data) {
		Stack<String> stack = new Stack<String>();
		int idx = 0;
		while (idx < data.length()) {
			if (data.charAt(idx) == '<') {
				boolean isClose = data.charAt(idx + 1) == '/';
				int tagEnd = data.indexOf('>', idx);
				if (tagEnd < 0)
					return false;
				String tagName;
				tagName = data.substring(idx + (isClose ? 2 : 1), tagEnd).trim();
				if (isClose) {
					if (stack.empty() || !stack.peek().equals(tagName)) {
						return false;
					} else {
						stack.pop();
					}
				} else {
					if (tagName.charAt(0) == 'a') {
						stack.push("a");
					} else if ((tagName.length() < 2) || !tagName.substring(0, 2).equals("br")) {
						stack.push(tagName);
					}
				}
				idx = tagEnd + 1;
			} else {
				idx++;
			}
		}
		
		return stack.empty();
	}
	
	

}
