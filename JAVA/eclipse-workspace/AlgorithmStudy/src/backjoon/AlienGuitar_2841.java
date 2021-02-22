//	https://www.acmicpc.net/problem/2841
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AlienGuitar_2841 {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unchecked")
		Stack<Integer>[] guitar = new Stack[7];
		for (int i = 1; i < guitar.length; i++) {
			guitar[i]= new Stack<Integer>();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		
		int n = Integer.parseInt(data[0]);
		int p = Integer.parseInt(data[1]);
		
		int result = 0;
		int numOfLine;
		int numOfFret;		
		for (int i = 0; i < n; i++) {
			data = br.readLine().split(" ");
			numOfLine = Integer.parseInt(data[0]);
			numOfFret = Integer.parseInt(data[1]);
			if ((numOfLine > 6) || (numOfFret > p))
				continue;
			if (!guitar[numOfLine].empty()) {
				while (!guitar[numOfLine].empty() && (guitar[numOfLine].peek() > numOfFret)) {
					guitar[numOfLine].pop();
					result++;
				}
				if (!guitar[numOfLine].empty() && (guitar[numOfLine].peek() == numOfFret))
					continue;
			}
			guitar[numOfLine].push(numOfFret);
			result++;
		}
		System.out.println(result);
		
	}

}
