package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs_2309 {
	
	static int[] dwarfs = new int[9];
	
	public static void solution() {
		int sum = 0;
		for (int i = 0; i < dwarfs.length; i++) {
			sum += dwarfs[i];
		}
		int fake1 = 0, fake2 = 0;
		boolean isFind = false;
		for (fake1 = 0; fake1 < dwarfs.length; fake1++) {
			for (fake2 = 0; fake2 < dwarfs.length; fake2++) {
				if (fake2 == fake1)
					continue;
				isFind = sum - dwarfs[fake2] - dwarfs[fake1] == 100;
				if (isFind)
					break;
			}
			if (isFind)
				break;
		}
		String sevenDwarfs = "";
		for (int i = 0; i < dwarfs.length; i++) {
			if ((i == fake1) || (i == fake2))
				continue;
			sevenDwarfs += dwarfs[i] + "\n";
		}
		System.out.println(sevenDwarfs);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
		}
		Arrays.sort(dwarfs);
		sc.close();
		solution();
	}

}
