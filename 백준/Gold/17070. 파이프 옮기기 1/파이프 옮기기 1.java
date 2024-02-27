import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int cnt; // 총 이동 방법 수: (0,1)에서 시작 => (n-1,n-1) 도달 시 종료
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 3 ~ 16
		map = new int[n][n]; // (0,0)부터 시작 => 0들은 제외
		cnt = 0;
		for (int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 탐색
		dfs(0, 1, 0);
		// 출력
		System.out.println(cnt);
	}

	public static void dfs(int r, int c, int d) { // 행 r, 열 c, 이전 파이프 방향 d
		if (r == n - 1 && c == n - 1) { // 기저 조건: 도달 시 cnt+1
			cnt++;
			return;
		}
		if (d == 0) { // 오른쪽
			if (c < n - 1 && map[r][c + 1] == 0) { // 오른쪽
				dfs(r, c + 1, 0);
			}
			if (r < n - 1 && c < n - 1 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) { // 오른쪽아래
				dfs(r + 1, c + 1, 1);
			}
		} else if (d == 1) { // 오른쪽아래
			if (c < n - 1 && map[r][c + 1] == 0) { // 오른쪽
				dfs(r, c + 1, 0);
			}
			if (r < n - 1 && c < n - 1 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) { // 오른쪽아래
				dfs(r + 1, c + 1, 1);
			}
			if (r < n - 1 && map[r + 1][c] == 0) { // 아래쪽
				dfs(r + 1, c, 2);
			}
		} else { // 아래쪽
			if (r < n - 1 && c < n - 1 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0 && map[r][c + 1] == 0) { // 오른쪽아래
				dfs(r + 1, c + 1, 1);
			}
			if (r < n - 1 && map[r + 1][c] == 0) { // 아래쪽
				dfs(r + 1, c, 2);
			}
		}
	}
}