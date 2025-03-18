import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // row
		int m = Integer.parseInt(st.nextToken()); // col
		int r = Integer.parseInt(st.nextToken()); // 회전 수
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 반시계 회전 (동: 상, 서: 하, 남: 우, 북: 좌)
		int g = Math.min(n, m) / 2; // 그룹 수 (경계선마다 한 그룹)
		for (int i = 0; i < r; i++) { // 회전 수만큼 for문
			for (int j = 0; j < g; j++) { // 그룹 수만큼 for문
				int bg = map[j][j]; // 시작점 값 (a,a)
				// 상하좌우가 차례로 연결되도록 작성해야 함 (좌-상-우-하)
				for (int k = j; k < m - 1 - j; k++) { // 좌: 합이 m-1
					map[j][k] = map[j][k + 1]; // row 그대로
				}
				for (int k = j; k < n - 1 - j; k++) { // 상: 합이 n-1
					map[k][m - 1 - j] = map[k + 1][m - 1 - j]; // col 그대로
				}
				for (int k = m - 1 - j; k > j; k--) { // 우: 합이 m-1
					map[n - 1 - j][k] = map[n - 1 - j][k - 1]; // row 그대로
				}
				for (int k = n - 1 - j; k > j; k--) { // 하: 합이 n-1
					map[k][j] = map[k - 1][j]; // col 그대로
				}
				map[j + 1][j] = bg; // 시작점 값을 한 칸 아래로
			}
		}

		// 회전 결과 출력 (2차원 배열)
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}