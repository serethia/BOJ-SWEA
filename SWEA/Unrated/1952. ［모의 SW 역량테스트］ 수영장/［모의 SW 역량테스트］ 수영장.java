import java.util.Scanner;

public class Solution {
	static int mincost;
	static int[] price;
	static int[] month;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			mincost = Integer.MAX_VALUE;
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			month = new int[13];
			for (int i = 1; i <= 12; i++) {
				month[i] = sc.nextInt();
			}
			pick(1, 0); // 1월, 0원으로 시작
			System.out.println("#" + tc + " " + mincost);
		}
	}

	public static void pick(int m, int cost) {
		if (m >= 13) {
			mincost = Math.min(mincost, cost);
			return;
		}

		pick(m + 1, cost + month[m] * price[0]);
		pick(m + 1, cost + price[1]);
		pick(m + 3, cost + price[2]);
		pick(m + 12, cost + price[3]);
	}
}