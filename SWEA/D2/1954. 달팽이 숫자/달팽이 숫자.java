import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int num = 1; // 구현할 숫자

			// 우하좌상
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			// 현재 좌표
			int r = 0;
			int c = 0;
			int d = 0;

			while (num <= n * n) {
				map[r][c] = num++;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= n || nr < 0 || nc >= n || nc < 0 || map[nr][nc] != 0) {
					d = (d + 1) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				r = nr;
				c = nc;
			}

			System.out.println("#" + i);
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					System.out.print(map[row][col] + " ");
				}
				System.out.println();
			}
		}
	}
}