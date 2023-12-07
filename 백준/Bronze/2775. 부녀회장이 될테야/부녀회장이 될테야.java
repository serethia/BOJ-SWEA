import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테케 수
		for (int tc = 1; tc <= t; tc++) {
			int k = sc.nextInt(); // 층 (0에서 시작) (1~14)
			int n = sc.nextInt(); // 호 (1에서 시작) (0층에서 n호에 n명 거주) (1~14)
			// k층 n호의 거주민 수 (출력값) = (k-1)층의 1~n호까지의 사람 수 합
			int[][] people = new int[15][15]; // 각 층 각 호 거주민 2차원 배열
			for (int j = 0; j <= 14; j++) { // 0~14층
				for (int m = 1; m <= 14; m++) { // 1~14호 거주민 수
					if (j == 0) { // 0층 거주민 수
						people[j][m] = m;
					} else { // 그 외 층 거주민 수
						for (int f = 1; f <= m; f++) {
							people[j][m] += people[j - 1][f];
						}
					}
				}
			}
			System.out.println(people[k][n]);
		}
	}
}