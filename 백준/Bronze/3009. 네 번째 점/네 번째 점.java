import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] x = new int[1000];
		int[] y = new int[1000];
		for (int i = 1; i <= 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[Integer.parseInt(st.nextToken()) - 1]++;
			y[Integer.parseInt(st.nextToken()) - 1]++;
		}
		int ansx = 0;
		int ansy = 0;
		for (int i = 0; i < 1000; i++) {
			if (x[i] == 1) {
				ansx = i + 1;
			}
			if (y[i] == 1) {
				ansy = i + 1;
			}
		}
		sb.append(ansx).append(" ").append(ansy);
		System.out.println(sb);
	}
}