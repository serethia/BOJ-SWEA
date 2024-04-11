import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int[] cnt;
	static StringBuilder sb;
	// 4방향
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];
		cnt = new int[n * n];
		for (int r = 0; r < n; r++) {
			String str = br.readLine();
			for (int c = 0; c < n; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		int idx = 0;
		int count = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (!visited[r][c] && map[r][c] == 1) {
					bfs(r, c, idx++);
					count++;
				}
			}
		}

		System.out.println(count);
		Arrays.sort(cnt);
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0) {
				System.out.println(cnt[i]);
			}
		}
	}

	public static void bfs(int r, int c, int idx) { // 1: 이동 가능, 0: 이동 불가
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		cnt[idx] = 1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int currx = curr[0] + dr[d];
				int curry = curr[1] + dc[d];
				if (currx < 0 || currx >= n || curry < 0 || curry >= n || map[currx][curry] == 0) {
					continue;
				}
				if (!visited[currx][curry] && map[currx][curry] == 1) {
					q.add(new int[] { currx, curry });
					visited[currx][curry] = true;
					cnt[idx]++;
				}
			}
		}
	}
}
