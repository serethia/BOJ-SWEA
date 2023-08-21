import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int[] bus = new int[5001];
			int n = sc.nextInt();
			for (int k = 0; k < n; k++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for (int i = start; i <= end; i++) {
					bus[i] += 1;
				}
			}
			int p = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= p; j++) {
				int stop = sc.nextInt();
				sb.append(" " + bus[stop]);
			}
			System.out.printf("#%d%s%n", tc, sb);
		}
	}
}