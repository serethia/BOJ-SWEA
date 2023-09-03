import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int[][] sudoku = new int[9][9];
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			
			int ans = 1; // 출력값

			// 행 검사
			for (int r = 0; r < 9; r++) {
				int[] count = new int[10]; // 0~9번까지 (1~9 검사)
				for (int c = 0; c < 9; c++) {
					count[sudoku[r][c]]++;
					if (count[sudoku[r][c]] > 1) { // 중복이 있을 시
						ans = 0; // 스도쿠 아님
						break;
					}
				}
			}


			// 열 검사
			for (int c = 0; c < 9; c++) {
				int[] count2 = new int[10]; // 0~9번까지 (1~9만 검사)
				for (int r = 0; r < 9; r++) {
					count2[sudoku[r][c]]++;
					if (count2[sudoku[r][c]] > 1) { // 중복이 있을 시
						ans = 0; // 스도쿠 아님
						break;
					}
				}
			}
			
			// 3x3 검사
			// 시작점 변경
			p: for (int r = 0; r < 9; r += 3) {
				for (int c = 0; c < 9; c += 3) {
					int[] count = new int[10]; // 0~9번까지 (1~9만 검사)
					// 3x3 탐색
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							count[sudoku[r + y][c + x]]++;
							if (count[sudoku[r + y][c + x]] > 1) { // 중복이 있을 시
								ans = 0; // 스도쿠 아님
								break p;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}