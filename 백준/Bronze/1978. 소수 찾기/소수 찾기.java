import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		boolean[] sosu = new boolean[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			sosu[i] = true;
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				sosu[i] = false;
				continue;
			}
			for (int j = 2; j <= nums[i] / 2; j++) {
				if (nums[i] % j == 0) {
					sosu[i] = false;
					break;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < sosu.length; i++) {
			if (sosu[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}