// https://www.acmicpc.net/problem/10845
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue_10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<String> list = new LinkedList<String>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			if (arr.length <= 0)
				continue;
			
			if (arr[0].equals("push")) {
				list.push(arr[1]);
			} else if (arr[0].equals("pop")) {
				if (!list.isEmpty()) {
					sb.append(list.removeLast() + "\n");
				} else {
					sb.append("-1\n");					
				}
			} else if (arr[0].equals("size")) {
				sb.append(list.size() + "\n");
			} else if (arr[0].equals("empty")) {
				if (list.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if (arr[0].equals("front")) {
				if (!list.isEmpty()) {
					sb.append(list.getLast() + "\n");
				} else {
					sb.append("-1\n");					
				}
			} else if (arr[0].equals("back")) {
				if (!list.isEmpty()) {
					sb.append(list.getFirst() + "\n");
				} else {
					sb.append("-1\n");					
				}
			}
		}
		System.out.println(sb);
	}

}
