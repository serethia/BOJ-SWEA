import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] num1 = new int[n][m];
		int[][] num2 = new int[n][m];
		int[][] ans = new int[n][m];
		for (int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				num1[r][c] = sc.nextInt();
			}
		}
		for(int r = 0; r < n; r++) {
			for(int c = 0; c<m; c++) {
				num2[r][c] = sc.nextInt();
			}
		}
		for(int r = 0; r < n; r++) {
			for(int c = 0; c<m; c++) {
				ans[r][c] = num1[r][c] + num2[r][c];
				System.out.print(ans[r][c]+" ");
			}
			System.out.println();
		}
	}
}