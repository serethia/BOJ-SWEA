import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] cheese;
	static boolean[][] ate;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n;
	static int eat;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			cheese = new int[n][n];
			int max = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					cheese[r][c] = sc.nextInt();
					max = Math.max(max, cheese[r][c]);
				}
			}

			int maxcheese = Integer.MIN_VALUE;
			for (eat = 0; eat < max; eat++) {
				ate = new boolean[n][n];
				int cnt = 0;
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (!ate[r][c] && cheese[r][c] > eat) {
							cnt++;
							bfs(r, c);
						}
					}
				}
				maxcheese = Math.max(maxcheese, cnt);
			}
			System.out.println("#" + tc + " " + maxcheese);
		}
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		ate[r][c] = true;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int row = tmp[0];
			int col = tmp[1];
			for (int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && !ate[nr][nc] && cheese[nr][nc] > eat) {
					ate[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}
}