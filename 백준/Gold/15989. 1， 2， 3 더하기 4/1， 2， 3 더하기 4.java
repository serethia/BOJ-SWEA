import java.io.*;
//import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// t 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		// 끝 숫자 (정렬 필요) & 원래 값 = 2차원 DP
		int[][] dp = new int[4][10001]; // 합산식 종류 수 (n은 10000 이하의 양수, 1~3으로 끝남)

		// 초기값
		dp[1][1] = 1; // 1 = 1
		dp[1][2] = 1; // 1+1 = 2
		dp[2][2] = 1; // 2 = 2
		dp[1][3] = 1; // 1+1+1 = 3
		dp[2][3] = 1; // 1+2 = 3
		dp[3][3] = 1; // 3 = 3
		for (int i = 4; i <= 10000; i++) { // 4 이상의 값
			dp[1][i] = dp[1][i - 1]; // 1
			dp[2][i] = dp[2][i - 2] + dp[1][i - 2]; // 2 = 1+1
			dp[3][i] = dp[3][i - 3] + dp[2][i - 3] + dp[1][i - 3]; // 3 = 1+2 = 1+1+1
		}

		// test case 반복
		for (int tc = 0; tc < t; tc++) {
			// n 입력
			int n = Integer.parseInt(br.readLine());
			// dp에서 n값의 식 종류 수 뽑아 출력
			System.out.println(dp[1][n] + dp[2][n] + dp[3][n]);
		}
	}
}