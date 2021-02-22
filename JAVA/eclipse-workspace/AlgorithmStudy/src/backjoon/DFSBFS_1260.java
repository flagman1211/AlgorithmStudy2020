package backjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFSBFS_1260{
	public static void DFS(ArrayList<Integer>[] lines, int v) {
		Stack<Integer> candidate = new Stack<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		candidate.add(v);		
		do {
			if (candidate.size() > 0) {
				int i = candidate.pop();
				if (visited.indexOf(i) >= 0)
					continue;
				visited.add(i);
				if (lines[i].size() > 1) {
					for (int j = lines[i].size() - 1; j > 0; j--)
						candidate.push(lines[i].get(j));
				}
				if (lines[i].size() > 0)
					candidate.push(lines[i].get(0));
			} else
				break;
		} while (visited.size() < lines.length);
		String msg = "";
		for (int i = 0; i < visited.size(); i++) {
			msg += (visited.get(i) + 1);
			if (i < visited.size() - 1)
				msg += " ";
		}
		System.out.println(msg);
	}
	
	public static void BFS(ArrayList<Integer>[] lines, int v) {
		LinkedList<Integer> candidate = new LinkedList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		candidate.add(v);		
		do {
			if (candidate.size() > 0) {
				int i = candidate.poll();
				if (visited.indexOf(i) >= 0)
					continue;
				visited.add(i);
				for (int j = 0; j < lines[i].size(); j++) {
					candidate.add(lines[i].get(j));
				}
			} else
				break;
		} while (visited.size() < lines.length);
		String msg = "";
		for (int i = 0; i < visited.size(); i++) {
			msg += (visited.get(i) + 1);
			if (i < visited.size() - 1)
				msg += " ";
		}
		System.out.println(msg);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt() - 1;
		
		int[][] input = new int[m][2];
		for (int i = 0; i < m; i++) {
			input[i][0] = sc.nextInt() - 1;
			input[i][1] = sc.nextInt() - 1;
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] lines = new ArrayList[n];
		for (int i = 0; i < lines.length; i++)
			lines[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length; i++) {
			int a = input[i][0];
			int b = input[i][1];
			lines[a].add(b);
			lines[b].add(a);
		}
		
		for (int i = 0; i < lines.length; i++)
			Collections.sort(lines[i]);
			
		DFS(lines, v);
		BFS(lines, v);
				
		sc.close();
	}

}
