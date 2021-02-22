// https://www.acmicpc.net/problem/5430

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AC_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<String> list = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();		
		for (int i = 0; i < n; i++) {
			char[] cmd = br.readLine().toCharArray();
			br.readLine();
			String[] arr = parseArr(br.readLine());
			
			list.clear();
			for (int j = 0; j < arr.length; j++) {
				list.addLast(arr[j]);
			}
			boolean isReverse = false;
			boolean isError = false;
			for (int j = 0; j < cmd.length; j++) {
				switch (cmd[j]) {
					case 'R': {
						isReverse = !isReverse;
						break;
					}
					case 'D': {
						isError = list.isEmpty();
						if (isError)
							break;
						if (!isReverse) {
							list.removeFirst();
						} else {
							list.removeLast();
						}
						break;
					}
				}
			}
			if (isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				while (!list.isEmpty()) {
					if (!isReverse)
						sb.append(list.removeFirst());
					else
						sb.append(list.removeLast());
					if (list.size() > 0)
						sb.append(",");
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
	
	public static String[] parseArr(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(0);
		if (sb.length() > 0)		
			return sb.toString().split(",");
		else
			return new String[0];
	}

}
