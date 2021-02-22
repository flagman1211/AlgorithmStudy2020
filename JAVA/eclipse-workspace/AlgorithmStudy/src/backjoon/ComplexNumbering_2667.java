package backjoon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ComplexNumbering_2667 {
	public static Point findNext(int[][] map) {
		Point result = null;
		int x = 0;
		int y = 0;
		while (true) {
			if (map[x][y] == 1) {
				result = new Point(x, y);
				break;
			}
			x++;
			if (x >= map.length) {
				x = 0;
				y++;
			}
			if (y >= map[0].length)
				break;
		}
		return result;
	}
	
	public static boolean isin(LinkedList<Point> queue, int x, int y) {
		boolean result = false;
		for (int i = 0; i < queue.size(); i++) {
			result = (queue.get(i).x == x) && (queue.get(i).y == y);
			if (result)
				break;
		}
		return result;
	}
	
	public static void complexNumbering(int[][] map)  {
		ArrayList<Integer> complexs = new ArrayList<Integer>();
		LinkedList<Point> queue  = new LinkedList<Point>();
		queue.add(findNext(map));
		Point curr = null;
		int cnt = 0;
		
		while (true) {
			curr = queue.poll();
			if (curr == null)
				break;
			map[curr.x][curr.y] = 0;
			cnt++;
			if (curr.x - 1 >= 0) {
				if ((map[curr.x - 1][curr.y] == 1) && !isin(queue, curr.x - 1, curr.y)) {
					queue.add(new Point(curr.x - 1, curr.y));
				}
			}
			if (curr.x + 1 < map.length) {
				if ((map[curr.x + 1][curr.y] == 1) && !isin(queue, curr.x + 1, curr.y)) {
					queue.add(new Point(curr.x + 1, curr.y));
				}
			}			
			if (curr.y - 1 >= 0) {
				if ((map[curr.x][curr.y - 1] == 1) && !isin(queue, curr.x, curr.y - 1)) {
					queue.add(new Point(curr.x, curr.y - 1));
				}
			}
			if (curr.y + 1 < map[0].length) {
				if ((map[curr.x][curr.y + 1] == 1) && !isin(queue, curr.x, curr.y + 1)) {
					queue.add(new Point(curr.x, curr.y + 1));
				}
			}
			if (queue.size() == 0) {
				complexs.add(cnt);
				cnt = 0;
				queue.add(findNext(map));;
			}
		}
		Collections.sort(complexs);
		String msg = complexs.size() + "\n";
		for (int i = 0; i < complexs.size(); i++) {
			msg += complexs.get(i);
			if (i < complexs.size() - 1)
				msg += "\n";
		}
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j)- '0';
			}
		}
		complexNumbering(map);
		sc.close();
	}

}
