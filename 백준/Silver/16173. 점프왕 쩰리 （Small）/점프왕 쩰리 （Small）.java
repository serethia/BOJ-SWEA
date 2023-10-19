import java.util.Scanner;

public class Main {
	static int[] dr = { 0, 1 }; // 우, 하
	static int[] dc = { 1, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static String ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		ans = "Hing"; // 도달 불가능 시
		visited[0][0] = true; // 시작 지점 방문 처리
		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int r, int c) {
		if (map[r][c] == -1) { // 도달 지점
			ans = "HaruHaru"; // 도달 가능 시
			return;
		}

		for (int d = 0; d < 2; d++) { // 델타 이용. map 현재 바닥의 값만큼 해당 방향으로만 점프 가능.
			int nr = r + dr[d] * map[r][c];
			int nc = c + dc[d] * map[r][c];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) { // 경계조건 충족 + 미방문 상태일 때
				visited[nr][nc] = true; // 방문 처리
				dfs(nr, nc);
				visited[nr][nc] = false; // 선택 안 했으면 방문 미처리
			}
		}
	}
}