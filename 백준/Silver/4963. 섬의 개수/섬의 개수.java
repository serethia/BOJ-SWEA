import java.util.Scanner;

public class Main {
	static int w, h;
	static int[][] map;
	// 상하좌우대각선
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					map[r][c] = sc.nextInt();
				}
			} // 1은 땅, 0은 바다
			int isl = 0; // 섬 개수
			visited = new boolean[h][w];
			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visited[r][c] && map[r][c] == 1) {
						visited[r][c] = true;
						doDFS(r, c);
						isl++;
					}
				}
			}
			System.out.println(isl);
		}
	}

	public static void doDFS(int r, int c) {

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				doDFS(nr, nc);
			}
		}
	}
}