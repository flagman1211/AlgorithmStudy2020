package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bracket_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int cnt;
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			cnt = 0;
			for (int j = 0; j < data.length(); j++) {
				if (data.charAt(j) == '(') {
					cnt++;
				} else {
					cnt--;
					if (cnt < 0)
						break;
				}
			}
			if (cnt == 0)
				sb.append("YES");
			else
				sb.append("NO");
			if (i < n - 1)
				sb.append("\n");
		}
		System.out.println(sb);
	}

}
