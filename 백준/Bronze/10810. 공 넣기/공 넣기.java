import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int begin = 0;
		int end = 0;
		int ball = 0;
		int[] basket = new int[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			begin = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			ball = Integer.parseInt(st.nextToken());
			for (int j = begin; j <= end; j++) {
				basket[j] = ball;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i == n) {
				sb.append(basket[i]);
			} else {
				sb.append(basket[i]).append(" ");
			}
		}
		System.out.println(sb);
	}
}