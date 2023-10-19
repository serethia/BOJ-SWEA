import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int k, w, h;
	static int[][] map;
	static boolean[][][] visited;
	// 나이트 이동 방향 (k회 제한)
	static int[] kdr = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] kdc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int movecnt;

	public static void main(String[] args) { // 최단거리 = BFS
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); // k번만 나이트처럼 이동 가능, 소진 시 상하좌우만 이동 가능
		w = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][w]; // 0은 평지, 1은 장애물(이동 불가)
		visited = new boolean[h][w][k + 1]; // 마지막은 남은 횟수 0~k
		movecnt = 0; // 맨 왼쪽 위 => 맨 오른쪽 아래까지 최단거리로 갈 때의 이동 횟수

		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		movecnt = Integer.MAX_VALUE;
		bfs(0, 0);
		if (movecnt == Integer.MAX_VALUE) {
			System.out.println(-1); // 불가능 시 -1
		} else {
			System.out.println(movecnt);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c][0] = true;
		q.offer(new int[] { r, c, 0, 0 }); // 행좌표, 열좌표, k횟수, 이동수

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			int kcnt = tmp[2];
			int dist = tmp[3];

			if (row == h - 1 && col == w - 1) {
				movecnt = Math.min(movecnt, dist);
			}

			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc][kcnt] && map[nr][nc] == 0) {
					visited[nr][nc][kcnt] = true;
					q.offer(new int[] { nr, nc, kcnt, dist + 1 });
				}
			}

			if (kcnt < k) {
				for (int kd = 0; kd < 8; kd++) {
					int nr = row + kdr[kd];
					int nc = col + kdc[kd];
					if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
						if (!visited[nr][nc][kcnt + 1] && map[nr][nc] == 0) {
							visited[nr][nc][kcnt + 1] = true;
							q.offer(new int[] { nr, nc, kcnt + 1, dist + 1 });
						}
					}
				}
			}
		}
	}
}