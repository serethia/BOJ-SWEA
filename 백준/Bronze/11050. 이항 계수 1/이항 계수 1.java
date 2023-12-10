import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 이항계수 = nCk = (n)!/{(n-k)!(k)!}
		int ans = fac(n) / (fac(n - k) * fac(k));

		System.out.println(ans);
	}

	public static int fac(int f) { // factorial
		int result = 1;
		for (int i = f; i >= 1; i--) {
			result *= i;
		}
		return result;
	}
}