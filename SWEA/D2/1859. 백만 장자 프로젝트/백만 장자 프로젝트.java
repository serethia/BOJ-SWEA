import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] price = new int[n];
			for (int i = n - 1; i >= 0; i--) { // 거꾸로 가격 저장!
				price[i] = sc.nextInt();
			}

			long surplus = 0;
			int max = price[0];
			for (int i = 0; i < n; i++) {
				if (price[i] >= max) {
					max = price[i];
				} else {
					surplus += max - price[i];
				}
			}
			System.out.println("#" + t + " " + surplus);
		}
	}
}