import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1]; // 0번은 제외, DP 이용
		dp[1] = 0; // 초기값 설정
		for (int i = 2; i < n + 1; i++) { // 더 작은 값으로 계속 갱신
			dp[i] = dp[i - 1] + 1; // 1을 뺀 기본 점화식
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]); // 3으로 나눠 떨어질 때 점화식
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]); // 2로 나눠 떨어질 때 점화식
			}
		}
		System.out.println(dp[n]);
	}
}