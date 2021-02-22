// https://www.acmicpc.net/problem/1966
package backjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PrinterQueue_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		LinkedList<Point> list = new LinkedList<Point>();
		for (int i = 0; i < testCount; i++) {
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			arr = br.readLine().split(" ");
			
			list.clear();
			for (int j = 0; j < n; j++) {
				list.add(new Point(j, Integer.parseInt(arr[j])));
			}
			int cnt = 0;
			while (list.size() > 1) {
				int currPriority = list.getFirst().y;
				boolean chk = false;
				for (int j = 1; j < list.size(); j++) {
					chk = list.get(j).y > currPriority;
					if (chk)
						break;
				}
				if (chk) {
					Point tmp = list.removeFirst();
					list.addLast(tmp);
				} else {
					if (list.getFirst().x == m)
						break;
					list.removeFirst();
					cnt++;
				}
			}
			sb.append((cnt + 1) + "\n");
		}
		
		System.out.println(sb);
	}

}
