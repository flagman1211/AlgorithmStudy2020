package backjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Snake_3190 {
	
	static class Info {
		int sec;
		char cmd;

		public Info(int sec, char cmd) {
			this.sec = sec;
			this.cmd = cmd;	// L: 왼쪽, D: 오른쪽
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		LinkedList<Point> snake = new LinkedList<Point>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] apples = new int[m][2];
		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			apples[i][1] = Integer.parseInt(temp[0]);
			apples[i][0] = Integer.parseInt(temp[1]);
		}
		
		int l = Integer.parseInt(br.readLine());
		LinkedList<Info> infos = new LinkedList<Info>();
		for (int i = 0; i < l; i++) {
			String[] temp = br.readLine().split(" ");
			int sec = Integer.parseInt(temp[0]);
			char cmd = temp[1].charAt(0);
			infos.add(new Info(sec, cmd));
		}
		
		Point curr = new Point(1, 1);
		char udlr = 'r';	// 뱀이 보는 방향 u: up, d: down, l: left, r: right
		int gameTime = 0;
		snake.add((Point) curr.clone());
		while (isOk(curr, n)) {
			gameTime++;
			switch (udlr) {
				case 'u': curr.y--; break;
				case 'd': curr.y++; break;
				case 'l': curr.x--; break;
				case 'r': curr.x++; break;
			}
			if (isBody(curr, snake))
				break;
			boolean isApple = false;
			for (int i = 0; i < m; i++) {
				isApple = (apples[i][0] == curr.x) && (apples[i][1] == curr.y);
				if (isApple) {
					apples[i][0] = 0;
					apples[i][1] = 0;
					break;
				}
			}
			snake.add((Point) curr.clone());
			if (!isApple)
				snake.poll();
			if (!infos.isEmpty() && (gameTime == infos.getFirst().sec)) {
				char cmd = infos.getFirst().cmd;
				if (((udlr == 'r') && (cmd == 'L')) || ((udlr == 'l') && (cmd == 'D'))) {
					udlr = 'u';
				} else if (((udlr == 'r') && (cmd == 'D')) || ((udlr == 'l') && (cmd == 'L'))) {
					udlr = 'd';
				} else if (((udlr == 'u') && (cmd == 'L')) || ((udlr == 'd') && (cmd == 'D'))) {
					udlr = 'l';
				} else {
					udlr = 'r';
				}
				infos.poll();
			}
		}
		
		System.out.println(gameTime);
	}

	private static boolean isOk(Point curr, int n) {
		return (((curr.x > 0) && (curr.x <= n)) && ((curr.y > 0) && (curr.y <= n)));
	}

	private static boolean isBody(Point curr, LinkedList<Point> snake) {
		for (int i = 0; i < snake.size(); i++) {
			if ((snake.get(i).x == curr.x) && (snake.get(i).y == curr.y)) {
				return true;
			}
		}
		return false;
	}

}
