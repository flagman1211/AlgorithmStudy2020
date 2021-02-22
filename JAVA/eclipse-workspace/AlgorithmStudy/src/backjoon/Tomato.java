package backjoon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Tomato {
	public static void RipenTomato(int[][] box) {
		ArrayList<Point> currs = new ArrayList<Point>();
		LinkedList<Point> queue = new LinkedList<Point>();
		ArrayList<Point> zeros = new ArrayList<Point>();
		int numOfRound = -1;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (box[i][j] == 1) {
					queue.add(new Point(i, j));
				} else if (box[i][j] == 0) {
					zeros.add(new Point(i, j));
				}
			}
		}
		while (true) {
			if (queue.size() == 0)
				break;
			currs.addAll(queue);
			queue.clear();
			while (currs.size() > 0) { 
				Point curr = currs.remove(0);
				if (curr.x - 1 >= 0) {
					if (box[curr.x - 1][curr.y] == 0) {
						box[curr.x - 1][curr.y] = 1;
						queue.add(new Point(curr.x - 1, curr.y));
					}
				}
				if (curr.x + 1 < box.length) {
					if (box[curr.x + 1][curr.y] == 0) {
						box[curr.x + 1][curr.y] = 1;
						queue.add(new Point(curr.x + 1, curr.y));
					}
				}
				if (curr.y - 1 >= 0) {
					if (box[curr.x][curr.y - 1] == 0) {
						box[curr.x][curr.y - 1] = 1;
						queue.add(new Point(curr.x, curr.y - 1));
					}
				}
				if (curr.y + 1 < box[0].length) {
					if (box[curr.x][curr.y + 1] == 0) {
						box[curr.x][curr.y + 1] = 1;
						queue.add(new Point(curr.x, curr.y + 1));
					}
				}
			}
			numOfRound++;
		}
		if (numOfRound == -1) {
			System.out.println(-1);
		} else {
			boolean isRemain = false;
			for (Point p : zeros) {
				isRemain = box[p.x][p.y] == 0;
				if (isRemain)
					break;
			}
			if (isRemain)
				System.out.println(-1);
			else
				System.out.println(numOfRound);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] box = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		// 여기서 solution 함수를 불러라
		RipenTomato(box);
		
		sc.close();
	}

}
