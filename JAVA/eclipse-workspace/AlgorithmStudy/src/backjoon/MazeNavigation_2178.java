package backjoon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MazeNavigation_2178 {
	
	public static void findPath(Point[][] maze, Point dest) {
		ArrayList<Point> visited = new ArrayList<Point>();
		LinkedList<Point> queue = new LinkedList<Point>();
		dest.x--;
		dest.y--;
		queue.add(new Point(0, 0));
		maze[0][0].y = 1;
		do {
			if (queue.size() > 0) {
				Point pos = queue.poll();
				if (visited.indexOf(pos) >= 0)
					continue;				
				if ((pos.x == dest.x) && (pos.y == dest.y))
					break;
				visited.add(pos);
				if (pos.x - 1 >= 0) {
					if ((maze[pos.x - 1][pos.y].x == 1) && (maze[pos.x - 1][pos.y].y > maze[pos.x][pos.y].y)) {
						queue.add(new Point(pos.x - 1, pos.y));
						maze[pos.x - 1][pos.y].y = maze[pos.x][pos.y].y + 1;
					}
				} 
				if (pos.x + 1 < maze.length) {
					if ((maze[pos.x + 1][pos.y].x == 1) && (maze[pos.x + 1][pos.y].y > maze[pos.x][pos.y].y)) {
						queue.add(new Point(pos.x + 1, pos.y));
						maze[pos.x + 1][pos.y].y = maze[pos.x][pos.y].y + 1;
					}
				} 
				if (pos.y - 1 >= 0) {
					if ((maze[pos.x][pos.y - 1].x == 1) && (maze[pos.x][pos.y - 1].y > maze[pos.x][pos.y].y)) {
						queue.add(new Point(pos.x, pos.y - 1));
						maze[pos.x][pos.y - 1].y = maze[pos.x][pos.y].y + 1;
					}
				} 
				if (pos.y + 1 < maze[0].length) {
					if ((maze[pos.x][pos.y + 1].x == 1) && (maze[pos.x][pos.y + 1].y > maze[pos.x][pos.y].y)) {
						queue.add(new Point(pos.x, pos.y + 1));
						maze[pos.x][pos.y + 1].y = maze[pos.x][pos.y].y + 1;
					}
				}
			} else
				break;
		} while (true);
		System.out.println(maze[dest.x][dest.y].y);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point dest = new Point();
		dest.x = sc.nextInt();
		dest.y = sc.nextInt();
		sc.nextLine();
		Point[][] maze = new Point[dest.x][dest.y];
		for (int i = 0; i < dest.x; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < input.length(); j++) {
				maze[i][j] = new Point(input.charAt(j) - '0', 99999);
			}
		}
		findPath(maze, dest);
		
		sc.close();
	}

}
