// https://www.acmicpc.net/problem/11724

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CountOfLink_11724 {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			
			graph.get(nodeA).add(nodeB);
			graph.get(nodeB).add(nodeA);
		}
		
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfsFunc(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void dfsFunc(int node) {
		visited[node] = true;
		
		for (int i = 0; i < graph.get(node).size(); i++) {
			int next = graph.get(node).get(i);
			if (!visited[next])
				dfsFunc(next);
		}
	}

}
