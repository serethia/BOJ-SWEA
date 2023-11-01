import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int r = 3;
	static int max;
	static int[] cards;
	static int[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		max = Integer.MIN_VALUE;
		cards = new int[n];
		selected = new int[r];
		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}
			
		comb(0, 0, 0);

		System.out.println(max);
	}

	public static void comb(int idx, int sidx, int sum) {
		if (sum > m)
			return;
		if (sidx == r) {
			max = Math.max(max, sum);
			return;
		}
		if (idx == n)
			return;
		selected[sidx] = cards[idx];
		comb(idx + 1, sidx + 1, sum + cards[idx]);
		comb(idx + 1, sidx, sum);
	}
}