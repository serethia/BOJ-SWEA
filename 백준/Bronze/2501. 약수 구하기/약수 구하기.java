import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] factors = new int[n];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				factors[idx++] = i; // 약수 모두 구하고
			}
		}
		if (factors.length < k) { // 적으면 0
			System.out.println(0);
		} else { // 적지 않으면 k번째 출력
			System.out.println(factors[k - 1]);
		}
	}
}