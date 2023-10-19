import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;
	static int n;
	static int m;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		visited = new boolean[n][m];
		for (int r = 0; r < n; r++) {
			String str = sc.next();
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		cnt = 0; // 출력할 총 판자 수
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(!visited[r][c]) { // 미방문 시작점 탐색
				dfs(r,c);
				cnt++; // 탐색 종료 후 판자+1
				}
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true; // 방문 처리
		if (map[r][c] == '-') {
			for (int d = 2; d <= 3; d++) { // 좌우 이동만
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == '-') { // 같은 무늬면 재귀, 판자는 그대로
					dfs(nr, nc);
				}
			}
		} else if (map[r][c] == '|') {
			for (int d = 0; d <= 1; d++) { // 상하 이동만
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] == '|') { // 같은 무늬면 재귀, 판자는 그대로
					dfs(nr, nc);
				}
			}
		}
	}
}