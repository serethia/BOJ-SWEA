import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static StringBuilder sb;
	// 4방향
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		bfs(0, 0);

		// 도착 지점까지 총 칸 수 출력
		System.out.println(map[n - 1][m - 1]);
	}

	public static void bfs(int r, int c) { // 1: 이동 가능, 0: 이동 불가
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int currx = curr[0] + dr[d];
				int curry = curr[1] + dc[d];
				if (currx < 0 || currx >= n || curry < 0 || curry >= m || map[currx][curry] == 0) {
					continue;
				}
				if (!visited[currx][curry] && map[currx][curry] == 1) {
					q.add(new int[] { currx, curry });
					visited[currx][curry] = true;
					// 이전 칸 depth에 1 더해주기
					map[currx][curry] = map[curr[0]][curr[1]] + 1;
				}
			}
		}
	}
}
