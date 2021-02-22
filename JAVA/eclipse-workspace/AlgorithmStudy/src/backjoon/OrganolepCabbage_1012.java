package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganolepCabbage_1012 {
	
	static final int[] dy = {0, -1, 1, 0};
	static final int[] dx = {-1, 0, 0, 1};
	
	static final int max = 50;
	
	static int[][] fields = new int[max][max];
	static boolean[][] visited = new boolean[max][max];
	
	static int m;
	static int n;
	static int k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < m; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					fields[j][j2] = 0;
					visited[j][j2] = false;
				}
			}
			
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				fields[x][y] = 1;
			}
			int count = 0;
			for (int j = 0; j < m; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if (fields[j][j2] == 1 && !visited[j][j2]) {
						count++;
						dfs(j, j2);
					}
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			
			if (ax < 0 || ax >= m || ay < 0 || ay >= n)
				continue;
			
			if (fields[ax][ay] == 0 || visited[ax][ay])
				continue;
			
			dfs(ax, ay);
		}
	}
}
