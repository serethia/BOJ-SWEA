import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int k;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테케
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 가로 (1~50)
			n = Integer.parseInt(st.nextToken()); // 세로 (1~50)
			k = Integer.parseInt(st.nextToken()); // 배추 위치 수 (1~2500)
			map = new int[n][m];
			visited = new boolean[n][m];
			cnt = 0; // 영역 수
			for (int g = 0; g < k; g++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}
			// 시작점 (1) 탐색
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (!visited[r][c] && map[r][c] == 1) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			// 출력
			System.out.println(cnt);
		}
	}

	public static void bfs(int r, int c) { // 행 r, 열 c
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int nowr = curr[0];
			int nowc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] != 1 || visited[nr][nc]) {
					continue;
				}
				q.offer(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
