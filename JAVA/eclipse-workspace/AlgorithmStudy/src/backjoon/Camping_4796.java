package backjoon;

import java.util.Scanner;

public class Camping_4796 {
	public static int camping(int l, int p, int v) {
		int d = 0;
		while (v >= p) {
			v -= p;
			d += l;
		}
		if (v >= l)
			d += l;
		else
			d += v;
		return d;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();
			if ((l == p) && (p == v) && (l == 0))
				break;
			sb.append("Case " + i + ": " + camping(l, p, v) + "\n");
			i++;
		}
		sc.close();
		System.out.println(sb);
	}

}
