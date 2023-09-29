import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1]; // 0번은 제외, DP 이용
		dp[1] = 1; // 초기값 설정
		if (n > 1) { // n이 1일 때를 상정해 구분
			dp[2] = 2; // 피보나치 수열
			if (n > 2) { // n이 2일 때를 상정해 구분
				for (int i = 3; i < n + 1; i++) {
					dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 10007로 나눈 나머지만
				}
			}
		}
		System.out.println(dp[n]);
	}
}