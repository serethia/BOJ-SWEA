import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] nums;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken()); // m 이상
		n = Integer.parseInt(st.nextToken()); // n 이하 (1 ~ 1,000,000)
		nums = new boolean[n + 1]; // true, 0, 1은 소수 아님

		primeOrNot();

		for (int i = m; i <= n; i++) {
			if (!nums[i]) { // false(소수)만 출력
				System.out.println(i);
			}
		}
	}

	public static void primeOrNot() {
		nums[0] = true;
		nums[1] = true;
		for (int i = 2; i <= Math.sqrt(n + 1); i++) {
			if (nums[i]) { // true는 스킵
				continue;
			}
			for (int j = i * i; j < n + 1; j += i) { // 소수 i의 배수들 지우기 = true
				nums[j] = true;
			}
		}
	}
}