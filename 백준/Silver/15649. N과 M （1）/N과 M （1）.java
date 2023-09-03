import java.util.Scanner;

public class Main {
	public static int n;
	public static int m;
	public static int[] nums;
	public static boolean[] visit;
	public static int[] pickednums;

	public static void main(String[] args) { // 순열
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n];
		visit = new boolean[n];
		pickednums = new int[m];
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
		}
		pick(0);
	}

	public static void pick(int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(pickednums[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				continue;
			}
			pickednums[idx] = nums[i];
			visit[i] = true;
			pick(idx + 1);
			visit[i] = false;
		}
	}
}