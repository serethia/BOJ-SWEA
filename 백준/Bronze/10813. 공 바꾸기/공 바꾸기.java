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
		int[] basket = new int[n + 1];
		for (int k = 1; k <= n; k++) {
			basket[k] = k;
		}
		int i = 0;
		int j = 0;
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			if (i != j) {
				int tmp = basket[i];
				basket[i] = basket[j];
				basket[j] = tmp;
			}
		}
		for (int k = 1; k <= n; k++) {
			if (k == n) {
				sb.append(basket[k]);
			} else {
				sb.append(basket[k]).append(" ");
			}
		}
		System.out.println(sb);
	}
}