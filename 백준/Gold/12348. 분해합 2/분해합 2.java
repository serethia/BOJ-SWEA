import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		String str = s.nextToken();
		long len = str.length();
		long n = Long.parseLong(str); // 1 ~ 10^18
		long ans = 0;
		for (long i = n - (9 * len); i <= n; i++) { // 분해합 >= 생성자, 한 자릿수 (1 ~ 9) 주의, n의 자릿수 * 9를 뺀 값부터 시작
			long sum = i;
			long now = i;
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