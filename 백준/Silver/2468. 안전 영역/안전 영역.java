import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int limit;
	static int maxlm;
	static int max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				map[r][c] = sc.nextInt();
				maxlm = Math.max(maxlm, map[r][c]); // limit의 최대값 제한 걸기 위한 변수 maxlm
			}
		}
		max = 0;
		
		for (limit = 0; limit < maxlm; limit++) { // limit 0부터 +1 해서 maxlm까지 반복
			int cnt =0;
			visited = new boolean[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					if (!visited[r][c] && map[r][c] > limit) { // limit 초과 영역은 물에 잠기지 않음
						bfs(r, c);
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
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
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && map[nr][nc] > limit) {
					visited[nr][nc] = true;
					q.offer(new int[]{nr, nc});
				}
			}
		}
	}
}