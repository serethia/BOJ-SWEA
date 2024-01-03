import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 1~500
		int m = Integer.parseInt(st.nextToken()); // 1~500
		int b = Integer.parseInt(st.nextToken()); // 0~6.4*10^7
		int[][] map = new int[n][m];
		int minheight = Integer.MAX_VALUE; // 입력 범위 내 최소 높이
		int maxheight = Integer.MIN_VALUE; // 입력 범위 내 최대 높이
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				minheight = Math.min(minheight, map[r][c]);
				maxheight = Math.max(maxheight, map[r][c]);
			}
		}

		// 브루트 포스
		StringBuilder sb = new StringBuilder();
		int ansheight = 0; // 최대 높이
		int anstime = Integer.MAX_VALUE; // 최소 시간
		for (int h = minheight; h <= maxheight; h++) { // 만들 높이: 최소 높이~최대 높이 탐색
			int plusblock = 0; // 더할 블록 수
			int minusblock = 0; // 뺄 블록 수
			int time = 0; // h 높이로 만드는 데 걸리는 시간
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] > h) { // 블록 제거: 2초
						minusblock += (map[r][c] - h);
					}
					if (map[r][c] < h) { // 인벤 꺼내기: 1초
						plusblock += (h - map[r][c]);
					}
				}
			}
			if (plusblock - minusblock <= b) { // 인벤 음수 아닐 경우
				time = 2 * minusblock + plusblock; // 시간 갱신
				anstime = Math.min(anstime, time); // 최소 시간
				if (time == anstime) { // 최소 시간에 해당하면
					ansheight = Math.max(ansheight, h); // 여러 높이 중 최대 높이
				}
			}
		}

		// 출력
		sb.append(anstime).append(" ").append(ansheight);
		System.out.println(sb);
	}
}