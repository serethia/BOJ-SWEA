import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		int ans = 0;
		for (int i = 1; i <= 1000000; i++) {
			int sum = i;
			int now = i;
			while (now != 0) {
				sum += now % 10;
				now = now / 10;
			}
			if (sum == n) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
}