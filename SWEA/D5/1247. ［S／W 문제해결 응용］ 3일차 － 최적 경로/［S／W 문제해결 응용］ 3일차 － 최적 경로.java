import java.util.Scanner;

public class Solution {
	static class xy { // 클래스 구현 연습
		int x;
		int y;
		public xy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n;
	static xy company;
	static xy home;
	static int best;
	static xy[] customer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			company = new xy(sc.nextInt(), sc.nextInt());
			home = new xy(sc.nextInt(), sc.nextInt());
			best = Integer.MAX_VALUE;
			customer = new xy[n];
			for (int i = 0; i < n; i++) {
				customer[i] = new xy(sc.nextInt(), sc.nextInt());
			}
			visit(0, company, 0, 0); // 회사에서 출발
			System.out.println("#" + tc + " " + best);
		}
	}

	public static void visit(int idx, xy now, int visited, int distancesum) { // 순열
		if (idx == n) { // 귀가
			distancesum += Math.abs(home.x - now.x) + Math.abs(home.y - now.y);
			best = Math.min(best, distancesum);
			return;
		}

		for (int i = 0; i < n; i++) { // 중복 제거
			if ((visited & (1 << i)) == 0) { // visited의 i번째 비트가 1이 아니면 (거쳐간 곳 아니면)
				visit(idx + 1, customer[i], visited | (1 << i), distancesum + Math.abs(now.x - customer[i].x) + Math.abs(now.y - customer[i].y)); // visited의 i번째 비트를 1로 만들자
			}
		}
	}
}