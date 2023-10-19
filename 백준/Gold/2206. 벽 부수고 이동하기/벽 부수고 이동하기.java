import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] map;
	static boolean[][][] visited; // 3차원 배열 (부순 경우와 안 부순 경우를 구별)
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min;

	public static void main(String[] args) { // 최단거리 = BFS
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //1~1000
		m = sc.nextInt(); //1~1000
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1][2]; // 벽을 0,1개 부술 수 있어 벽 부순 횟수도 기억해야.

		for (int r = 1; r <= n; r++) {
			String str = sc.next();
			for (int c = 1; c <= m; c++) {
				map[r][c] = str.charAt(c-1)-'0';
			}
		}

		min = Integer.MAX_VALUE;
		bfs(1,1);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1); // 불가능 시 -1 출력
		} else {
		System.out.println(min);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c][0] = true;
		q.offer(new int[] { r, c, 0, 1 }); // 행좌표, 열좌표, 벽부순횟수, 거리
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			int cnt = tmp[2];
			int dist = tmp[3];

			if (row == n && col == m) {
				min = Math.min(min, dist);
			}

			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 1 && nr <= n && nc >= 1 && nc <= m && !visited[nr][nc][cnt] && map[nr][nc] == 0) {
					visited[nr][nc][cnt] = true;
					q.offer(new int[] { nr, nc, cnt, dist + 1 });
				}
				if (nr >= 1 && nr <= n && nc >= 1 && nc <= m && cnt == 0 && !visited[nr][nc][cnt + 1] && map[nr][nc] == 1) {
					visited[nr][nc][cnt + 1] = true;
					q.offer(new int[] { nr, nc, cnt + 1, dist + 1 });
				}
			}
		}
	}
}