import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 0 ~ 3 * 10^5
		int ans = 0; // n이 0이면 0 출력
		if (n != 0) {
			int[] comments = new int[n];
			for (int i = 0; i < n; i++) {
				comments[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(comments); // 오름차순
			int except = (int) Math.round(n * 0.15); // 반올림
			double sum = 0; // 각 값 1 ~ 30 범위 = 최대 9 * 10^6
			for (int i = except; i < n - except; i++) {
				sum += comments[i];
			}
			ans = (int) Math.round(sum / (n - (except * 2))); // 반올림
		}
		System.out.println(ans);
	}
}