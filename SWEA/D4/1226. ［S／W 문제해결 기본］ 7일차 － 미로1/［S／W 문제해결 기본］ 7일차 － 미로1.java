import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int goal;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt(); // 테케 번호 날리기
			map = new int[16][16];
			for (int r = 0; r < 16; r++) {
				String str = sc.next();
				for (int c = 0; c < 16; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}

			goal = 0; // 도달 가능하면 1로 변경
			visited = new boolean[16][16];
			for (int r = 0; r < 16; r++) {
				for (int c = 0; c < 16; c++) {
					if (!visited[r][c] && map[r][c] == 2) { // 2 = 시작 지점
						bfs(r, c);
					}
				}
			}
			System.out.println("#" + tc + " " + goal);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited[r][c] = true;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && map[nr][nc] == 0) { // 길
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && map[nr][nc] == 3) { // 3 = 도착 지점 도달
					visited[nr][nc] = true;
					goal = 1;
				}
			}
		}
	}
}