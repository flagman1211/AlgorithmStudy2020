package backjoon;

import java.util.Scanner;

public class DragonAndDunjeon_16434 {
	
	static final int GB_ = 0;
	static final int ATK = 1;
	static final int HP_ = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long hATK = sc.nextInt();
		
		long[][] arr = new long[n][3];
		
		long l = 1;
		long r = Long.MAX_VALUE;	// 최대값 설정이 관건이었었다. 제한이 따로 없어서 Long의 최대값에서 포션의 HP만큼 빼주어 오버플로가 나지 않도록 했다.
		for (int i = 0; i < n; i++) {
			arr[i][GB_] = sc.nextLong();
			arr[i][ATK] = sc.nextLong();
			arr[i][HP_] = sc.nextLong();
			if (arr[i][GB_] == 1) {
				r -= arr[i][HP_]; 
			}
		}
		sc.close();
		
		long result = r;
		while (l <= r) {
			long mid = (l + r) >> 1;
			if (Go(arr, n, mid, hATK)) {
				r = mid - 1;
				result = Math.min(mid, result);
			} else {
				l = mid + 1;
			}
		}
		System.out.println(result);		
	}
	
	public static boolean Go(long[][] arr, int n, long maxHP, long atk) {
		long currHP = maxHP;
		for (int i = 0; i < n; i++) {
			if (arr[i][GB_] == 1) {		// 몬스터
				long monsterAtkCount;
				if (arr[i][HP_] % atk == 0) {
					monsterAtkCount = arr[i][HP_] / atk - 1; 
				} else {
					monsterAtkCount = arr[i][HP_] / atk;
				}
				currHP = currHP - monsterAtkCount * arr[i][ATK];
				if (currHP <= 0) {
					return false;
				}
			} else {					// 포션
				atk += arr[i][ATK];
				currHP = Math.min(currHP + arr[i][HP_], maxHP);
			}
		}		
		return true;
	}

}
