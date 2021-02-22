// https://www.acmicpc.net/problem/3078
// https://yeeybook.tistory.com/51 참고
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class GoodFriend_3078 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] queueArr = new LinkedList[21];
		for (int i = 2; i < queueArr.length; i++) {
			queueArr[i] = new LinkedList<Integer>();
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			result += putInQueue(queueArr[name.length()], i, k);
		}
		System.out.println(result);
	}
	
	public static long putInQueue(LinkedList<Integer> list, int rank, int k) {
		while (!list.isEmpty() && (rank - list.getFirst() > k))
			list.removeFirst();
		long result = list.size();
		list.addLast(rank);
		return result;
	}

}
